package com.ilzf.security.service;

import com.ilzf.util.LogUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Component;

/**
 * TokenServices控制token的服务
 * 集成了AuthorizationServerTokenServices, ResourceServerTokenServices, ConsumerTokenServices, InitializingBean
 * 集万千宠爱于一身，也就是集成了OAuth2.0的所有的tokenServer
 * <p>
 * <p>
 * 控制token的声明周期，创建，刷新，删除，获取
 */
@Component
public class MyTokenServices extends DefaultTokenServices {
    /**
     * 控制token的声明周期，创建，刷新，获取
     */
    //--------------这块代码实现了AuthorizationServerTokenServices
    @Override
    public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {
        LogUtil.log("MyTokenServices.createAccessToken");
        return super.createAccessToken(authentication);
    }

    @Override
    public OAuth2AccessToken refreshAccessToken(String refreshTokenValue, TokenRequest tokenRequest) throws AuthenticationException {
        LogUtil.log("MyTokenServices.refreshAccessToken");
        return super.refreshAccessToken(refreshTokenValue, tokenRequest);
    }

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        LogUtil.log("MyTokenServices.getAccessToken");
        return super.getAccessToken(authentication);
    }

    //------------------ResourceServerTokenServices
    @Override
    public OAuth2Authentication loadAuthentication(String accessTokenValue) throws AuthenticationException, InvalidTokenException {
        LogUtil.log("MyTokenServices.loadAuthentication");
        return super.loadAuthentication(accessTokenValue);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        LogUtil.log("MyTokenServices.readAccessToken");
        return super.readAccessToken(accessToken);
    }

    //-------------ConsumerTokenServices
    @Override
    public boolean revokeToken(String tokenValue) {
        LogUtil.log("MyTokenServices.revokeToken");
        return super.revokeToken(tokenValue);
    }
}
