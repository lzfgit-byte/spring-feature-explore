package com.ilzf.security.config;

import com.ilzf.security.service.MyClientDetailsServer;
import com.ilzf.security.service.MyUserDetailService;
import com.ilzf.security.store.MyTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {

    @Autowired
    MyClientDetailsServer myClientDetailsServer;
    @Autowired
    MyTokenStore myStore;
    @Autowired
    MyUserDetailService myUserDetailService;
    /**
     * 自定义一下两位，暂时不可行。自定义tokenserver会导致注入两个相同的bean、导致授权失败
     */
//    @Autowired
//    MyTokenServices myTokenServices;
//    //    @Autowired
//    MyAuthenticationManager myAuthenticationManager;

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
        clients.withClientDetails(myClientDetailsServer);
        myClientDetailsServer.loadClientDetails();
    }

    /**
     * 用来配置令牌端点(Token Endpoint)的安全约束.
     * AuthorizationServerSecurityConfigurer继承SecurityConfigurerAdapter
     * 是一个 Spring Security安全配置提供给AuthorizationServer
     * 去配置AuthorizationServer的端点（/oauth/****）的安全访问规则、过滤器Filter。
     * <p>
     * ClientDetail加密方式
     * allowFormAuthenticationForClients 允许表单认证。针对/oauth/token端点。
     * 添加开发配置tokenEndpointAuthenticationFilters
     * tokenKeyAccess、checkTokenAccess访问权限。
     * <p>
     * *  配置：安全检查流程,用来配置令牌端点（Token Endpoint）的安全与权限访问
     * *  默认过滤器：BasicAuthenticationFilter
     * *  1、oauth_client_details表中clientSecret字段加密【ClientDetails属性secret】
     * *  2、CheckEndpoint类的接口 oauth/check_token 无需经过过滤器过滤，默认值：denyAll()
     * * 对以下的几个端点进行权限配置：
     * * /oauth/authorize：授权端点
     * * /oauth/token：令牌端点
     * * /oauth/confirm_access：用户确认授权提交端点
     * * /oauth/error：授权服务错误信息端点
     * * /oauth/check_token：用于资源服务访问的令牌解析端点
     * * /oauth/token_key：提供公有密匙的端点，如果使用JWT令牌的话
     * <p>
     * <p>
     * 配置通用接口的权限
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
//        security.allowFormAuthenticationForClients()//允许客户表单认证
//                .passwordEncoder(new BCryptPasswordEncoder())//设置oauth_client_details中的密码编码器
//                .tokenKeyAccess("permitAll()") // 开启/oauth/token_key验证端口无权限访问
//                .checkTokenAccess("isAuthenticated()")// 开启/oauth/check_token验证端口认证权限访问
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
        //将userDetailsService直接声明为bean也是可行的。自定义authenticationManager的时候可以不用配置userDetailsService
        endpoints.userDetailsService(myUserDetailService);
        //注入自己的tokenstore
        endpoints.tokenStore(myStore);
        //控制token的声明周期
//        endpoints.tokenServices(myTokenServices);
        //配置AuthenticationManager
//        endpoints.authenticationManager(myAuthenticationManager);
    }
}
