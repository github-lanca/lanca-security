package com.lanca.security.service.impl;

import com.lanca.security.service.LoginService;
import com.lanca.vo.AjaxResult;
import com.lanca.vo.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author mei.hongliang
 * @since 2022/2/24 15:03
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public AjaxResult xxx() {
        return null;
    }

    @Override
    public AjaxResult login(LoginParam loginParam) {
        //
        UserDetails xxx = userService.loadUserByUsername(loginParam.getUsername());
        // bala吧啦

        return null;
    }
}
