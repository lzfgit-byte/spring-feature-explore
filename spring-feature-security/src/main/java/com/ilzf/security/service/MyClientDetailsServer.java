package com.ilzf.security.service;

import com.ilzf.security.constant.SecurityInfo;
import com.ilzf.util.LogUtil;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建自定义clientDetails
 * 可以从数据库查，可以从redis查，可以返回固定的
 */
@Component
public class MyClientDetailsServer extends InMemoryClientDetailsService {

    /**
     * Oauth支持的5类 grant_type 及说明
     * authorization_code — 授权码模式(即先登录获取code,再获取token)
     * password — 密码模式(将用户名,密码传过去,直接获取token)
     * client_credentials — 客户端模式(无用户,用户向客户端注册,然后客户端以自己的名义向’服务端’获取资源)
     * implicit — 简化模式(在redirect_uri 的Hash传递token; Auth客户端运行在浏览器中,如JS,Flash)
     * refresh_token — 刷新access_token
     */
    public void loadClientDetails() {
        Map<String, ClientDetails> store = new HashMap<>();
        store.put("client", new BaseClientDetails("client", SecurityInfo.RESOURCE_ID, "app", "refresh_token ", "all"));
        store.put("client2", new BaseClientDetails("client2", SecurityInfo.RESOURCE_ID, "app", "refresh_token ", "all"));
        store.put("client3", new BaseClientDetails("client3", SecurityInfo.RESOURCE_ID, "app", "refresh_token ", "all"));
        this.setClientDetailsStore(store);
    }

    @Override
    public void setClientDetailsStore(Map<String, ? extends ClientDetails> clientDetailsStore) {
        LogUtil.log("setClientDetailsStore");
        super.setClientDetailsStore(clientDetailsStore);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        LogUtil.log("loadClientByClientId");
//        super.loadClientByClientId(clientId);
        return super.loadClientByClientId(clientId);
    }
}
