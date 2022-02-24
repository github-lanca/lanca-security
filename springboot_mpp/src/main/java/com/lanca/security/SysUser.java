package com.lanca.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author mei.hongliang
 * @since 2022/2/24 14:39
 */
public class SysUser extends User {

    public SysUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
