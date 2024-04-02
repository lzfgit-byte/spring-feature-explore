package com.ilzf.security.handler;

import com.ilzf.security.entity.MyUser;
import com.ilzf.security.service.MyClientDetailsServer;
import com.ilzf.util.ApplicationContextHolder;
import com.ilzf.util.LogUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LogUtil.log("登录成功");
        response.setContentType("application/json;charset=UTF-8");
        MyUser principal = (MyUser) authentication.getPrincipal();
        //集成oauth2 生成bear token
        //生成token
        String clientId = "client";
        String clientSecret = "clientSecret";

        //登录成功，生成单点登录token
        MyClientDetailsServer bean = ApplicationContextHolder.getContext().getBean(MyClientDetailsServer.class);
        AuthorizationServerTokenServices bean1 = ApplicationContextHolder.getContext().getBean(AuthorizationServerTokenServices.class);

        ClientDetails clientDetails = bean.loadClientByClientId(clientId);
        TokenRequest tokenRequest = new TokenRequest(new HashMap<>(), clientId, clientDetails.getScope(), "custom");
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
        OAuth2AccessToken token = bean1.createAccessToken(oAuth2Authentication);

        Map<String, Object> res = new HashMap<>();
        res.put("msg", "登录成功");
        res.put("code", 200);
        res.put("data", principal);
        res.put("token", token);
        response.getWriter().println(res);
    }
}
