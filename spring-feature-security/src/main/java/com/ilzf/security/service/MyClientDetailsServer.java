package com.ilzf.security.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * 创建自定义clientDetails
 * 可以从数据库查，可以从redis查，可以返回固定的
 */
public class MyClientDetailsServer extends JdbcClientDetailsService {
    /**
     * 数据库创建
     *
     * @param dataSource
     */
    public MyClientDetailsServer(DataSource dataSource) {
        super(dataSource);
    }
}
