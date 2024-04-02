package com.ilzf.security.entryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilzf.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyResourceAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        String message = authException.getMessage();
        LogUtil.log("MyResourceAuthenticationEntryPoint", message);
        Map<String, Object> res = new HashMap<>();
        res.put("code", HttpStatus.UNAUTHORIZED.value());
        res.put("msg", HttpStatus.UNAUTHORIZED.getReasonPhrase());
        response.getWriter().write(objectMapper.writeValueAsString(res));
    }
}
