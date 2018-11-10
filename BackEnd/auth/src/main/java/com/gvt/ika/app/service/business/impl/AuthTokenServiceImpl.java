package com.gvt.ika.app.service.business.impl;

import com.gvt.ika.app.entity.bo.AuthToken;
import com.gvt.ika.app.entity.exception.InvalidToken;
import com.gvt.ika.app.service.business.AuthTokenService;
import com.gvt.ika.app.service.repository.AuthTokenRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;


@Service
public class AuthTokenServiceImpl implements AuthTokenService {

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Scheduled(fixedDelay = 10*1*60*1000)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void init()
    {
        authTokenRepository.removeInvalidTokens();
    }


    @Transactional
    public AuthToken generateToken(AuthToken authToken,Integer expiry) throws  InvalidToken
        {
            AuthToken existing = authTokenRepository.findByCompanyIdApplicationIdUserIdAndTokenValue(authToken.getCompanyId(),authToken.getApplicationId(),authToken.getUserId(),authToken.getToken());
            if(existing!=null)
            {
                throw new InvalidToken("Invalid Token");
            }
            AuthToken alreadyActiveToken=authTokenRepository.findActiveTokenByCompanyIdApplicationIdUserId(authToken.getCompanyId(),authToken.getApplicationId(),authToken.getUserId());
            if(alreadyActiveToken!=null)
            {
                authTokenRepository.delete(alreadyActiveToken.getId());
            }
            authToken.generate(expiry);
            authToken= authTokenRepository.saveOrUpdate(authToken,authToken.getId());
            return authToken;
        }

        @Transactional(noRollbackFor = InvalidToken.class)
        public AuthToken updateToken(AuthToken authToken,Integer expiry)
        {
            AuthToken existing = authTokenRepository.findByCompanyIdApplicationIdUserIdAndTokenValue(authToken.getCompanyId(),authToken.getApplicationId(),authToken.getUserId(),authToken.getToken());
            if(existing!=null)
            {
                if(existing.getExpireOn()>System.currentTimeMillis())
                {
                    authToken = existing.update(expiry);
                    authTokenRepository.saveOrUpdate(authToken, authToken.getId());
                    authToken.setAuthTokenStatus(AuthToken.AuthTokenStatus.VALID);
                    return authToken;
                }
                else
                {
                    authTokenRepository.delete(existing.getId());
                    authToken.setAuthTokenStatus(AuthToken.AuthTokenStatus.EXIPRED);
                    return authToken;
                }
            }
            else
            {
                authToken.setAuthTokenStatus(AuthToken.AuthTokenStatus.INVALID);
                return authToken;
            }
        }
}
