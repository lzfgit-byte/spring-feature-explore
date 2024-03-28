package com.ilzf.security.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 *
 */
@Slf4j
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        log.info("decide");
        return;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        log.info("decide1");
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        log.info("supports2");
        return true;
    }
}
