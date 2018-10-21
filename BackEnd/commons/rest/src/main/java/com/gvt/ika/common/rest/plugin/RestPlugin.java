package com.gvt.ika.common.rest.plugin;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.URI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.gvt.ika.common.rest.entity.dto.Response;
import com.gvt.ika.common.rest.entity.exception.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

public class RestPlugin<RQ, RS> {

    private final Logger LOGGER = LoggerFactory.getLogger(RestPlugin.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    private HttpHeaders headers = new HttpHeaders();



    ParameterizedTypeReference<Response<RS>> parameterizedTypeReference;

    public RestPlugin(ParameterizedTypeReference<Response<RS>> parameterizedTypeReference) {
        this.parameterizedTypeReference = parameterizedTypeReference;
    }

    public ResponseEntity<Response<RS>> post(String url, HttpHeaders httpHeaders, RQ data) {
        return trigger(HttpMethod.POST, httpHeaders, url, data);
    }

    public ResponseEntity<Response<RS>> get(String url) {
        return trigger(HttpMethod.GET, url, null);
    }


    public ResponseEntity<Response<RS>> post(String url, RQ data) {

        return trigger(HttpMethod.POST, url, data);
    }

    public ResponseEntity<Response<RS>> put(String url, RQ data) {
        return trigger(HttpMethod.PUT, url, data);
    }


    public void setHttpHeader(String key, String value) {
        headers.set(key, value);

    }

    private URI uriComponentsBuilder(String url) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        return builder.build().toUri();
    }

    private HttpEntity<RQ> httpEntity(HttpHeaders httpHeaders, RQ data) {
        HttpEntity<RQ> httpEntity = new HttpEntity<>(data, httpHeaders);
        return httpEntity;
    }

    private ParameterizedTypeReference<Response<RS>> parameterizedTypeReference() {

        ParameterizedTypeReference<Response<RS>> parameterizedTypeReference = new ParameterizedTypeReference<Response<RS>>() {


        };
        return parameterizedTypeReference;
    }

    private ResponseEntity<Response<RS>> trigger(HttpMethod httpMethod, String url, RQ data) {
        String requestId = "" + System.currentTimeMillis();
        setHttpHeader("requestId", requestId);
        setHttpHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        setHttpHeader("requestId", requestId);
        HttpEntity<RQ> httpEntity = httpEntity(headers, data);
        return trigger(requestId, httpMethod, httpEntity, url);
    }

    private ResponseEntity<Response<RS>> trigger(HttpMethod httpMethod, HttpHeaders httpHeaders, String url, RQ data) {
        String requestId = "" + System.currentTimeMillis();
        httpHeaders.set("requestId", requestId);
        HttpEntity<RQ> httpEntity = httpEntity(httpHeaders, data);
        return trigger(requestId, httpMethod, httpEntity, url);
    }

    @SuppressWarnings("unchecked")
    private ResponseEntity<Response<RS>> trigger(String requestId, HttpMethod httpMethod, HttpEntity<RQ> httpEntity, String url) {

        ResponseEntity<Response<RS>> responseEntity = null;
        try {
            LOGGER.info("Requesting  " + url + " with method type " + httpMethod.name() + " with RequestId : " + requestId + " body :" + httpEntity.getBody());
            org.springframework.http.client.SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new org.springframework.http.client.SimpleClientHttpRequestFactory();
            simpleClientHttpRequestFactory.setOutputStreaming(false);
            RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);

            if(this.parameterizedTypeReference==null)
            {
             this.parameterizedTypeReference= new ParameterizedTypeReference<Response<RS>>() { };
            }

            responseEntity = restTemplate.exchange(uriComponentsBuilder(url), httpMethod, httpEntity, this.parameterizedTypeReference);

            LOGGER.info("Response Received from  " + url + " with method type " + httpMethod.name() + " http status : " + responseEntity.getStatusCode().value() + " | " + responseEntity.getStatusCode().getReasonPhrase());
        } catch (ResourceAccessException resourceAccessException) {
            LOGGER.info("Exception : ", resourceAccessException);
            responseEntity = new ResponseEntity(null, HttpStatus.SERVICE_UNAVAILABLE);
        } catch (HttpClientErrorException httpClientErrorException) {
            Response<RS> response = null;
            String json = httpClientErrorException.getResponseBodyAsString();
            LOGGER.error("RESPONSE JSON : " + json);
            if (json != null && json.trim().length() > 0) {
                try {
                    response = objectMapper.readValue(json, Response.class);
                    responseEntity = new ResponseEntity<Response<RS>>(response, httpClientErrorException.getStatusCode());
                } catch (JsonParseException jsonParseException) {
                    throw new RestException(jsonParseException.getLocalizedMessage(), jsonParseException);
                } catch (JsonMappingException jsonMappingException) {
                    throw new RestException(jsonMappingException.getLocalizedMessage(), jsonMappingException);
                } catch (IOException ioException) {
                    throw new RestException(ioException.getLocalizedMessage(), ioException);
                }
            }
            responseEntity = new ResponseEntity<Response<RS>>(response, httpClientErrorException.getStatusCode());
            LOGGER.error(responseEntity.toString());
        } catch (Exception e) {
            LOGGER.info("Exception : ", e);
            if (e instanceof java.net.ConnectException) {
                responseEntity = new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
            } else {
                responseEntity = new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return responseEntity;
    }


}
