package com.ilzf.security.config;

import com.ilzf.security.manage.MyAuthenticationManager;
import com.ilzf.security.service.MyClientDetailsServer;
import com.ilzf.security.service.MyUserDetailService;
import com.ilzf.security.store.MyStore;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {
    @Resource
    private DataSource dataSource;

    /**
     * 用来配置客户端详情服务（ClientDetailsService），
     * 客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
     * <p>
     * clientId是什么？假设登录京东时，借助微信登录，那么提供授权服务就是微信，微信拥有oauth_client_details表，
     * 然后京东提前在微信注册了一个clientId，京东使用这个id来向微信表明身份，这样，微信就知道是京东来访问自己了。
     * client_id 校验是自由处理的
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);
        MyClientDetailsServer myClientDetailsServer = new MyClientDetailsServer(dataSource);
        clients.withClientDetails(myClientDetailsServer);
        clients.inMemory()
                .withClient("client")   // client_id
                .secret("secret")       // client_secret
                .authorizedGrantTypes("authorization_code")     // 该client允许的授权类型
                .scopes("app")     // 允许的授权范围
                .autoApprove(true); //登录后绕过批准询问(/oauth/confirm_access)
    }

    //用来配置令牌端点(Token Endpoint)的安全约束.
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    /**
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
     */
    /**
     * AuthorizationServerEndpointsConfigurer其实是一个装载类，
     * 装载Endpoints所有相关的类配置（AuthorizationServer、TokenServices、TokenStore、ClientDetailsService、
     * UserDetailsService）。
     * <p>
     * 也就是说进行密码验证的一些工具类或服务类，均在这个地方进行注入，例如UserDetailsService，
     * 我们知道UserDetailsService是负责从数据库读取用户数据的，用户数据包含密码信息，这样，
     * 框架就可以判断前端传入的用户名和密码是否正确。
     * <p>
     * 如果启用token校验的话，就需要注入TokenServices，TokenStore是对token的额外补充，用来确定token存储的。
     * <p>
     * 因此，不是所有的参数都是必须的，需要根据实际场景来确定使用的参数。
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
        //
        endpoints.authenticationManager(new MyAuthenticationManager());
        //将userDetailsService直接声明为bean也是可行的
        endpoints.userDetailsService(new MyUserDetailService());
        //是否可以直接将tokenStore声明为bean
        endpoints.tokenStore(new InMemoryTokenStore());
    }
}
