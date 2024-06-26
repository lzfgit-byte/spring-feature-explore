package com.ilzf.security.entity;

import com.ilzf.security.constant.SecurityInfo;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class MyClientDetailEntity extends BaseClientDetails {
    /**
     * Oauth支持的5类 grant_type 及说明
     * authorization_code — 授权码模式(即先登录获取code,再获取token)
     * password — 密码模式(将用户名,密码传过去,直接获取token)
     * client_credentials — 客户端模式(无用户,用户向客户端注册,然后客户端以自己的名义向’服务端’获取资源)
     * implicit — 简化模式(在redirect_uri 的Hash传递token; Auth客户端运行在浏览器中,如JS,Flash)
     * refresh_token — 刷新access_token
     */
    public MyClientDetailEntity(String clientId, String resourceIds, String scopes, String authorities) {
        this(clientId, resourceIds, scopes, "refresh_token", authorities, (String) null);
    }

    public MyClientDetailEntity(String clientId, String resourceIds, String scopes, String grantTypes, String authorities, String redirectUris) {
        super(clientId, resourceIds, scopes, grantTypes, authorities, redirectUris);
    }

    /**
     * 授权有效时间是10秒
     *
     * @return
     */
    public Integer getAccessTokenValiditySeconds() {
        return SecurityInfo.EXPIRE_DATE;
    }

}
