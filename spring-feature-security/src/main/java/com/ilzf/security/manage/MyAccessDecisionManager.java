package com.ilzf.security.manage;

import com.ilzf.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 *
 */
@Slf4j
public class MyAccessDecisionManager extends AbstractAccessDecisionManager {
    protected MyAccessDecisionManager(List<AccessDecisionVoter<?>> decisionVoters) {
        super(decisionVoters);
        LogUtil.log("MyAccessDecisionManager 构造");
    }

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
