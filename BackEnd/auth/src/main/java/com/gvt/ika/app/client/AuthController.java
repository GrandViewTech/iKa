package com.gvt.ika.app.client;

import com.gvt.ika.app.entity.bo.AuthToken;
import com.gvt.ika.app.entity.exception.InvalidToken;
import com.gvt.ika.app.service.business.AuthTokenService;
import com.gvt.ika.common.rest.entity.dto.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
public class AuthController
{
    @Autowired
    private  AuthTokenService authTokenService;

    private Long expiryTime=new Long(  (5));

    @GetMapping(value = "/v1/validate")
    @ResponseBody
    public ResponseEntity<Response<Map<String, Object>>> authorize
                (
                    @RequestHeader("XCompanyId") Long companyId,
                    @RequestHeader("XApplicationId") Long applicationId,
                    @RequestHeader("XUserId") Long userId,
                    @RequestHeader("Authorization") String token
                )   throws InvalidToken
    {

        Map<String, Object> responseBody = new HashMap<>();
        AuthToken authToken= authTokenService.updateToken(new AuthToken(companyId,applicationId,userId,token.split("BEARER : ")[1]),expiryTime.intValue());
        responseBody.put("status",authToken);
        HttpStatus httpStatus =null;
        String message="";
        switch(authToken.getAuthTokenStatus())
        {
            case VALID: {
                            httpStatus=HttpStatus.OK;
                            message="Authorization Passed";
                            break;
                        }
            case EXIPRED:{
                            httpStatus=HttpStatus.UNAUTHORIZED;
                            message="Authorization Failed";
                            break;
                        }

            case INVALID: {
                                httpStatus=HttpStatus.UNAUTHORIZED;
                                message="Authorization Failed";
                                break;
                            }

        }
        Response<Map<String, Object>>  response= new  Response<Map<String, Object>>(httpStatus.value(), message, responseBody);
        ResponseEntity<Response<Map<String, Object>>> responseEntity = new ResponseEntity<Response<Map<String, Object>>>(response,httpStatus);
        return responseEntity;
    }



    @PostMapping(value="/v1/login")
    @ResponseBody
    public ResponseEntity<Response<Map<String, Object>>> authenticate(@RequestBody Map<String,String> body) throws InvalidToken
    {
        String username=body.get("username");
        String password=body.get("password");
        String token = UUID.randomUUID().toString();
        byte[] byteArray=  Base64.getDecoder().decode(password);
        String pass = new String(byteArray);
        HttpStatus httpStatus = null;
        Map<String, Object> responseBody = new HashMap<>();
        String message="";
        if(pass.equals("pass@123"))
            {
                List<AuthToken> authTokenList = new ArrayList<>();
                AuthToken authToken=authTokenService.generateToken(new AuthToken(1L,1L,1L,token),expiryTime.intValue());
                authTokenList.add(authToken);
                message="Authentication Passed";
                httpStatus=HttpStatus.OK;
                responseBody.put("tokens", authTokenList);
            }
        else
            {
                message="Authentication Failed";
                httpStatus=HttpStatus.UNAUTHORIZED;
            }
        Response<Map<String, Object>>  response= new  Response<Map<String, Object>>(httpStatus.value(), message, responseBody);
        ResponseEntity<Response<Map<String, Object>>> responseEntity = new ResponseEntity<Response<Map<String, Object>>>(response,httpStatus);
        return responseEntity;
    }
}
