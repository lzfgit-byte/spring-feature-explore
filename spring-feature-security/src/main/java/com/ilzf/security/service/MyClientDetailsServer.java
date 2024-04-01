package com.ilzf.security.service;

import com.ilzf.util.LogUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 创建自定义clientDetails
 * 可以从数据库查，可以从redis查，可以返回固定的
 */
@Component
public class MyClientDetailsServer extends InMemoryClientDetailsService {


    @Override
    public void setClientDetailsStore(Map<String, ? extends ClientDetails> clientDetailsStore) {
        LogUtil.log("setClientDetailsStore");
        super.setClientDetailsStore(clientDetailsStore);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        LogUtil.log("loadClientByClientId");
        return new BaseClientDetails("postman", "pp", "app", "all", "all");
    }
}
