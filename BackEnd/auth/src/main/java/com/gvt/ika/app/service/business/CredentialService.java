package com.gvt.ika.app.service.business;

import com.gvt.ika.app.entity.bo.Credential;
import com.gvt.ika.app.entity.exception.PasswordValidationException;
import com.gvt.ika.app.entity.exception.UsernameAlreadyExistException;

import java.security.NoSuchAlgorithmException;

public interface CredentialService
{
    public Credential saveCredential(Long userId,String username ,String password) throws PasswordValidationException, NoSuchAlgorithmException, UsernameAlreadyExistException;

}
