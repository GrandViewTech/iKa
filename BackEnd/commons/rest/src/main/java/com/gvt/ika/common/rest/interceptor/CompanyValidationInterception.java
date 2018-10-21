package com.gvt.ika.common.rest.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gvt.ika.common.rest.entity.dto.Response;
import com.gvt.ika.common.rest.plugin.RestPlugin;
import com.gvt.ika.shared.entity.constant.StatusCode;
import com.gvt.ika.shared.entity.dto.Code;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * uses header XCID for validating company id
 */


public class CompanyValidationInterception implements Filter {

    ObjectMapper objectMapper = new ObjectMapper();

    ParameterizedTypeReference<Response<Map<String, String>>> parameterizedTypeReference = new ParameterizedTypeReference<Response<Map<String, String>>>() {
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isError = false;
        Code code = null;
        HttpStatus httpStatus = null;
        Response<Map<String, String>> resposne = new Response<>();
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String companyId = httpRequest.getHeader("XCID");
        if (companyId != null) {
            RestPlugin<Void, Map<String, String>> request = new RestPlugin<>(parameterizedTypeReference);
            ResponseEntity<Response<Map<String, String>>> entity = request.get("http://localhost:8093/tms/company/" + companyId);
            if (!entity.getStatusCode().is2xxSuccessful()) {
                if (entity.getStatusCode().value() == HttpStatus.NOT_FOUND.value()) {

                    isError = true;
                    code = StatusCode.COMPANY_NOT_FOUND;
                    httpStatus = HttpStatus.NOT_FOUND;
                } else {
                    isError = true;
                    httpStatus = entity.getStatusCode();
                    code = new Code(httpStatus.value(), httpStatus.getReasonPhrase());
                }
            }

        } else {
            isError = true;
            code = StatusCode.HEADER_MISSING;
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        if (isError) {
            httpResponse.setStatus(httpStatus.value());
            resposne.setStatusAndMessageCode(code);
            String jsonR = objectMapper.writeValueAsString(resposne);
            httpResponse.getWriter().write(jsonR);
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        } else {
            filterChain.doFilter(httpRequest, httpResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
