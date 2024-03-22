package com.ilzf.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public class MyUser implements Serializable, UserDetails {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号是否未过期
     */
    private boolean accountNonExpired = true;
    /**
     * 账号是否未锁定
     */
    private boolean accountNonLocked = true;
    /**
     * 凭证是否未过期
     */
    private boolean credentialsNonExpired = true;
    /**
     * 账号是否启用
     */
    private boolean enabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
    }

    @Override
    public String getUsername() {
        return this.userName;
    }
}
