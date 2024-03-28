package com.ilzf.security.manage;

import com.ilzf.util.LogUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 在获取authentication时 中间商处理
 */
public class MyAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication.setAuthenticated(true);
        LogUtil.log("MyAuthenticationManager");
        return authentication;
    }
}
