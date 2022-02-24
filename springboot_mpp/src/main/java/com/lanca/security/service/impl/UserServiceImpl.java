package com.lanca.security.service.impl;

import com.lanca.security.SysUser;
import com.lanca.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author mei.hongliang
 * @since 2022/2/24 14:46
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 数据库查询系统用户
     *
     * @param username username
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Wrapper<SysUser> query=;
        // userMapper.selectOne(query);
//        SysUser sysUser = xxxMapper.select(username);
        // 查数据 校验密码 根据各种情况抛出异常
        return new SysUser("admin", "", null);
    }
}
