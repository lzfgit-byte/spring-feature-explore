package com.ilzf.security.store;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Collection;

/**
 * TokenStore的初始化在发生在AuthorizationServerEndpointsConfigurer中，默认的TokenStore是InMemoryTokenStore
 */
public class MyStore implements TokenStore {


    //根据token读取认证信息
    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken oAuth2AccessToken) {
        return null;
    }

    @Override
    public OAuth2Authentication readAuthentication(String s) {
        return null;
    }

    //存储token
    @Override
    public void storeAccessToken(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

    }

    //从存储中读取访问令牌
    @Override
    public OAuth2AccessToken readAccessToken(String s) {
        return null;
    }

    //从存储中删除访问令牌
    @Override
    public void removeAccessToken(OAuth2AccessToken oAuth2AccessToken) {

    }

    //将指定的刷新令牌存储在存储中
    @Override
    public void storeRefreshToken(OAuth2RefreshToken oAuth2RefreshToken, OAuth2Authentication oAuth2Authentication) {

    }

    //从存储读取刷新令牌
    @Override
    public OAuth2RefreshToken readRefreshToken(String s) {
        return null;
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {
        return null;
    }

    //从存储中删除刷新令牌
    @Override
    public void removeRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {

    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {

    }

    //根据认证信息获取token
    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication oAuth2Authentication) {
        return null;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String s, String s1) {
        return null;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String s) {
        return null;
    }
}
