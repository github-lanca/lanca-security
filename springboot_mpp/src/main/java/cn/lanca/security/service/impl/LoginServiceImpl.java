package cn.lanca.security.service.impl;

import cn.lanca.security.SysUser;
import cn.lanca.security.util.JwtUtil;
import cn.lanca.vo.AjaxResult;
import cn.lanca.vo.LoginParam;
import cn.lanca.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AjaxResult login(LoginParam loginParam) {
        Authentication authenticate = null;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword()));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return AjaxResult.error("登录失败: " + e.getMessage());
        }
        String token = JwtUtil.generate(loginParam.getUsername());
        AjaxResult success = AjaxResult.success("登录成功");
        success.put("token", token);
        // SecurityContextHolder.getContext().setAuthentication(authenticate);
        return success;
    }
}
