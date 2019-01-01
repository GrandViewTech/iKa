package com.gvt.ika.app.service.business.impl;

import com.google.common.hash.Hashing;
import com.gvt.ika.app.entity.bo.Credential;
import com.gvt.ika.app.entity.exception.PasswordValidationException;
import com.gvt.ika.app.entity.exception.UsernameAlreadyExistException;
import com.gvt.ika.app.service.business.CredentialService;
import com.gvt.ika.app.service.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@Service
public class CredentialServiceImpl implements CredentialService
{
    @Autowired
    private CredentialRepository credentialRepository;

    @Transactional
        public Credential saveCredential(Long userId,String username ,String password) throws PasswordValidationException,NoSuchAlgorithmException, UsernameAlreadyExistException
        {
         if(  credentialRepository.findByUsername(username)!=null)
             {
              throw new UsernameAlreadyExistException(username+" is already taken");
             }
             Credential credential = new Credential();
            credential.setUserId(userId);
            credential.setUsername(username.toLowerCase());
            credential.setPassword(securePassword(validatePasswordStrength(password)));
            return credentialRepository.saveOrUpdate(credential,null);
        }

        private String validatePasswordStrength(String password) throws PasswordValidationException
        {
            String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
            if(password.matches(regex))
            {
                return  password;
            }
            else
            {
                throw new PasswordValidationException();
            }

        }

        private String securePassword(String  password) throws NoSuchAlgorithmException
        {
            return Hashing.sha256()
                    .hashString(password, StandardCharsets.UTF_8)
                    .toString();
        }
}
