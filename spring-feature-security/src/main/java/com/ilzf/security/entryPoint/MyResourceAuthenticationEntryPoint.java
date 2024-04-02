package com.ilzf.security.entryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilzf.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
        LogUtil.log("MyResourceAuthenticationEntryPoint");
        String message = authException.getMessage();
        Map<String, String> res = new HashMap<>();
        res.put("code", "401");
        res.put("msg", "登录失效");
        response.getWriter().write(objectMapper.writeValueAsString(res));
    }
}
