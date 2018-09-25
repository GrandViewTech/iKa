package com.gvt.ika.app.client;

import com.gvt.ika.common.rest.entity.dto.Response;
import org.hibernate.annotations.GeneratorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
public class AuthController {


    @GetMapping(value = "/validate")
    @ResponseBody
    public Response<Map<String, Object>> authenticate(@RequestHeader("Authorization") String authorization) {
        String token = UUID.randomUUID().toString();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("token", token);
        responseBody.put("life", 30000);
        return new Response<Map<String, Object>>(HttpStatus.OK.value(), "Authentication Passed", responseBody);
    }

}
