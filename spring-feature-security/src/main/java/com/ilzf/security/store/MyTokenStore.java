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
    public OAuth2Authentication readAuthentication(OAuth2AccessToken oAuth2AccessToken) {
        LogUtil.log("readAuthentication");
        return super.readAuthentication(oAuth2AccessToken);
    }

    @Override
    public OAuth2Authentication readAuthentication(String s) {
        LogUtil.log("readAuthentication");
        return super.readAuthentication(s);
    }

    //存储token
    @Override
    public void storeAccessToken(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        LogUtil.log("storeAccessToken");
        super.storeAccessToken(oAuth2AccessToken, oAuth2Authentication);
    }

    //从存储中读取访问令牌
    @Override
    public OAuth2AccessToken readAccessToken(String s) {
        LogUtil.log("readAccessToken");
        return super.readAccessToken(s);
    }

    //从存储中删除访问令牌
    @Override
    public void removeAccessToken(OAuth2AccessToken oAuth2AccessToken) {
        LogUtil.log("removeAccessToken");
        super.removeAccessToken(oAuth2AccessToken);
    }

    //将指定的刷新令牌存储在存储中
    @Override
    public void storeRefreshToken(OAuth2RefreshToken oAuth2RefreshToken, OAuth2Authentication oAuth2Authentication) {
        LogUtil.log("storeRefreshToken");
        super.storeRefreshToken(oAuth2RefreshToken, oAuth2Authentication);
    }

    //从存储读取刷新令牌
    @Override
    public OAuth2RefreshToken readRefreshToken(String s) {
        LogUtil.log("readRefreshToken");
        return super.readRefreshToken(s);
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {
        LogUtil.log("readAuthenticationForRefreshToken");
        return super.readAuthenticationForRefreshToken(oAuth2RefreshToken);
    }

    //从存储中删除刷新令牌
    @Override
    public void removeRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {
        LogUtil.log("removeRefreshToken");
        super.removeRefreshToken(oAuth2RefreshToken);
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {
        LogUtil.log("removeAccessTokenUsingRefreshToken");
        super.removeAccessTokenUsingRefreshToken(oAuth2RefreshToken);
    }

    //根据认证信息获取token
    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication oAuth2Authentication) {
        LogUtil.log("getAccessToken");
        return super.getAccessToken(oAuth2Authentication);
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String s, String s1) {
        LogUtil.log("findTokensByClientIdAndUserName");
        return super.findTokensByClientIdAndUserName(s, s1);
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String s) {
        LogUtil.log("findTokensByClientId");
        return super.findTokensByClientId(s);
    }
}
