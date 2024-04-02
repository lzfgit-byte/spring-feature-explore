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

    public void loadClientDetails() {
        Map<String, ClientDetails> store = new HashMap<>();
        store.put("client", new BaseClientDetails("client", SecurityInfo.RESOURCE_ID, "app", "all", "all"));
        store.put("client2", new BaseClientDetails("client2", SecurityInfo.RESOURCE_ID, "app", "all", "all"));
        store.put("client3", new BaseClientDetails("client3", SecurityInfo.RESOURCE_ID, "app", "all", "all"));
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
