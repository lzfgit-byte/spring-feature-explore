package com.ilzf.security.config;

import com.ilzf.security.constant.SecurityInfo;
import com.ilzf.security.handler.LoginFailHandler;
import com.ilzf.security.handler.LoginSuccessHandler;
import com.ilzf.security.store.MyTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * oauth2 使用下，不使用此处配置spring security
 * 资源配置，配置resource和springSecurity
 */
@Configuration
@EnableResourceServer
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    @Autowired
    LoginFailHandler loginFailHandler;


    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 如果没有下面的语句, 那么任何请求都可以免认证
        http.authorizeRequests()
                //不同写法
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .anyRequest()
                .authenticated()
//                以上设置请求的认证
                .and()
                .exceptionHandling()
                // 认证失败返回401状态码，前端页面可以根据401状态码跳转到登录页面。
                .authenticationEntryPoint((request, response, authException) ->
                        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase()))
                .and().cors()
                // csrf是否决定禁用，请自行考量。开放接口及时permitAll。没有csrftoken，仍然会403
                .and().csrf().disable()
                //记住我 ,customizers是对记住我这个程序的设置
                .rememberMe(rememberMe -> rememberMe.key("myKey").tokenValiditySeconds(7 * 24 * 3600))

                // 会匹配所有api开头的请求，多个请求匹配规则，以后出现的为主。在此处就是已requestMatcher的匹配为主
                //判断给那些请求进行权限校验
//                .antMatcher("/api/**")
                .requestMatcher(new RequestMatcher() {
                    //使用ant语法去进行匹配url
                    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

                    @Override
                    public boolean matches(HttpServletRequest request) {
                        /**
                         * 此处判断对那些请求进行权限校验
                         */
                        String requestURI = request.getRequestURI();
//                        LogUtil.log("requestURI", requestURI);
                        if (antPathMatcher.match("/api/logout", requestURI)) {
                            return false;
                        }
                        if (antPathMatcher.match("/api/**", requestURI)) {
                            return true;
                        }
                        return false;
                    }
                })
                //登录
                .formLogin().loginProcessingUrl("/api/login")
                .usernameParameter("userName").passwordParameter("password").permitAll()
                .successHandler(loginSuccessHandler).failureHandler(loginFailHandler)
                .and()
                //登出
                .logout().logoutUrl("/api/logout").permitAll()
                .and()
                // 采用http 的基本认证.
                .httpBasic();
    }

    @Autowired
    MyTokenStore myStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.tokenStore(myStore);
        resources.resourceId(SecurityInfo.RESOURCE_ID);
        //token 提取，从请求中提取token，两个位置
        /**
         *request.getParameter("access_token");
         * request.getHeaders("Authorization");
         * Authorization: Bearer {tokenValue}
         */
        resources.tokenExtractor(new BearerTokenExtractor());

    }
}
