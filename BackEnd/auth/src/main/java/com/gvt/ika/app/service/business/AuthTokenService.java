package com.gvt.ika.app.service.business;

import com.gvt.ika.app.entity.bo.AuthToken;
import com.gvt.ika.app.entity.exception.InvalidTokenException;

public interface AuthTokenService {

    public AuthToken generateToken(AuthToken authToken, Integer expiry) throws InvalidTokenException;

    public AuthToken updateToken(AuthToken authToken,Integer expiry) ;
}
