package com.ilzf.security.manage;

import com.ilzf.util.LogUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 在获取authentication时 中间商处理
 * AuthenticationManager是一个用来处理认证（Authentication）请求的接口。
 * 在其中只定义了一个方法authenticate()，该方法只接收一个代表认证请求的Authentication对象作为参数，
 * 如果认证成功，则会返回一个封装了当前用户权限等信息的Authentication对象进行返回。
 * <p>
 * Authentication authenticate(Authentication authentication) throws AuthenticationException;
 * 1
 * 在Spring Security中，AuthenticationManager的默认实现是ProviderManager，
 * 而且它不直接自己处理认证请求，而是委托给其所配置的AuthenticationProvider列表，
 * 然后会依次使用每一个AuthenticationProvider进行认证：
 * <p>
 * 如果有一个AuthenticationProvider认证后的结果不为null，则表示该AuthenticationProvider已经认证成功，
 * 之后的AuthenticationProvider将不再继续认证。然后直接以该AuthenticationProvider的认证结果作为ProviderManager的认证结果。
 * <p>
 * 如果所有的AuthenticationProvider的认证结果都为null，则表示认证失败，将抛出一个ProviderNotFoundException。
 * <p>
 * 校验认证请求最常用的方法是根据请求的用户名加载对应的UserDetails，
 * 然后比对UserDetails的密码与认证请求的密码是否一致，一致则表示认证通过。
 * <p>
 * Spring Security内部的DaoAuthenticationProvider就是使用的这种方式。
 * 其内部使用UserDetailsService来负责加载UserDetails。
 * 在认证成功以后会使用加载的UserDetails来封装要返回的Authentication对象，
 * 加载的UserDetails对象是包含用户权限等信息的。认证成功返回的Authentication对象将会保存在当前的SecurityContext中。
 * <p>
 * <p>
 * 认证流程
 * ProviderManager-->DaoAuthenticationProvider--->userDetail
 * ProviderManager是一个AuthenticationManager。控制授权。
 * ProviderManager委托给DaoAuthenticationProvider进行授权校验，该provider会调用userDetail进行校验
 */
@Component
public class MyAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication.setAuthenticated(true);
        LogUtil.log("MyAuthenticationManager");
        return authentication;
    }
}
