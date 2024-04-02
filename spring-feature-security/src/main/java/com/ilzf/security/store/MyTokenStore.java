package com.ilzf.security.store;

import com.ilzf.util.LogUtil;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * TokenStore的初始化在发生在AuthorizationServerEndpointsConfigurer中，默认的TokenStore是InMemoryTokenStore
 */
@Component
public class MyTokenStore extends InMemoryTokenStore {


    //根据token读取认证信息
    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        LogUtil.log("readAuthentication");
        return super.readAuthentication(token);
    }

    @Override
    public OAuth2Authentication readAuthentication(String token) {
        LogUtil.log("readAuthentication");
        return super.readAuthentication(token);
    }

    //存储token
    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication oAuth2Authentication) {
        LogUtil.log("storeAccessToken");
        super.storeAccessToken(token, oAuth2Authentication);
    }

    //从存储中读取访问令牌
    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        LogUtil.log("readAccessToken");
        return super.readAccessToken(tokenValue);
    }

    //从存储中删除访问令牌
    @Override
    public void removeAccessToken(OAuth2AccessToken accessToken) {
        LogUtil.log("removeAccessToken");
        super.removeAccessToken(accessToken);
    }

    //将指定的刷新令牌存储在存储中
    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        LogUtil.log("storeRefreshToken");
        super.storeRefreshToken(refreshToken, authentication);
    }

    //从存储读取刷新令牌
    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        LogUtil.log("readRefreshToken");
        return super.readRefreshToken(tokenValue);
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        LogUtil.log("readAuthenticationForRefreshToken");
        return super.readAuthenticationForRefreshToken(token);
    }

    //从存储中删除刷新令牌
    @Override
    public void removeRefreshToken(OAuth2RefreshToken refreshToken) {
        LogUtil.log("removeRefreshToken");
        super.removeRefreshToken(refreshToken);
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        LogUtil.log("removeAccessTokenUsingRefreshToken");
        super.removeAccessTokenUsingRefreshToken(refreshToken);
    }

    //根据认证信息获取token
    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        LogUtil.log("getAccessToken");
        return super.getAccessToken(authentication);
    }

    /**
     * 根据clientId和userName获取token
     */
    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        LogUtil.log("findTokensByClientIdAndUserName");
        return super.findTokensByClientIdAndUserName(clientId, userName);
    }

    //列出clientId下的所有token
    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        LogUtil.log("findTokensByClientId");
        return super.findTokensByClientId(clientId);
    }
}
