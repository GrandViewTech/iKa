package com.gvt.ika.app.service.repository;

import com.gvt.ika.app.entity.bo.AuthToken;
import service.repository.GenericDao;

public interface AuthTokenRepository extends GenericDao<AuthToken> {

    public AuthToken findByCompanyIdApplicationIdUserIdAndTokenValue(Long companyId , Long applicationId , Long userId , String token);

    public AuthToken findActiveTokenByCompanyIdApplicationIdUserId(Long companyId , Long applicationId , Long userId );

    public void removeInvalidTokens();
}
