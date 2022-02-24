package com.lanca.security.controller;

import com.lanca.security.service.LoginService;
import com.lanca.vo.AjaxResult;
import com.lanca.vo.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mei.hongliang
 * @since 2022/2/24 14:50
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 退出
     *
     * @return String
     */
    @GetMapping("/login")
    public AjaxResult login(LoginParam loginParam) {
        //
        loginService.login(loginParam);
        SecurityContextHolder.clearContext();
        AjaxResult success = AjaxResult.success("success");
        success.put("", "");
        return success;
    }

    /**
     * 退出
     *
     * @return String
     */
    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "退出成功";
    }
}
