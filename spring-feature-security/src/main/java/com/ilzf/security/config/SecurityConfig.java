package com.ilzf.security.config;

import com.ilzf.security.handler.FailHandler;
import com.ilzf.security.handler.SuccessHandler;
import com.ilzf.util.LogUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 如果没有下面的语句, 那么任何请求都可以免认证
        http.authorizeRequests()
                //不同写法
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .anyRequest()
                .authenticated()
//                以上设置请求的认证
                .and()
                .formLogin().loginPage("/api/login")
                .successHandler(new SuccessHandler()).failureHandler(new FailHandler())
                .and()
                .logout().logoutUrl("/api/logout")
                .and()
                .exceptionHandling()
                // 认证失败返回401状态码，前端页面可以根据401状态码跳转到登录页面。
                .authenticationEntryPoint((request, response, authException) ->
                        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase()))
                .and().cors()
                // csrf是否决定禁用，请自行考量
                .and().csrf()
//                .disable()
                .and()
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
                        LogUtil.log("requestURI", requestURI);
                        if (antPathMatcher.match("/api/**", requestURI)) {
                            return true;
                        }
                        return false;
                    }
                })
                // 采用http 的基本认证.
                .httpBasic();
//        super.configure(http);
    }
    //TODO 自定义SecurityFilterChain后出现问题，待处理
    //@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(Customizer.withDefaults())
//                .authorizeHttpRequests(authorize -> {
//                            authorize.regexMatchers("/doc.html").permitAll();
//                            authorize.anyRequest().authenticated();
//                        }
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//    }
}
