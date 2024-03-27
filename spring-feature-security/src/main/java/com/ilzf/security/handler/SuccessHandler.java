package com.ilzf.security.handler;

import com.ilzf.security.entity.MyUser;
import com.ilzf.util.LogUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LogUtil.log("登录成功");
        response.setContentType("application/json;charset=UTF-8");
        MyUser principal = (MyUser) authentication.getPrincipal();

        Map<String, Object> res = new HashMap<>();
        res.put("msg", "登录成功");
        res.put("code", 200);
        res.put("data", principal);
        response.getWriter().println(res);
    }
}
