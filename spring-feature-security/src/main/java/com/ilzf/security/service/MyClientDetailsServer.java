package com.ilzf.security.service;

import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * 创建自定义clientDetails
 */
public class MyClientDetailsServer extends JdbcClientDetailsService {
    /**
     * 构造方法，生成bean时自动注入
     *
     * @param dataSource
     */
    public MyClientDetailsServer(DataSource dataSource) {
        super(dataSource);
    }
}
