package cn.lanca.security.util;

import cn.lanca.security.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUserUtil {


    /**
     * 获取当前登录用户
     *
     * @return SysUser
     */
    public static SysUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SysUser sysUser = (SysUser) authentication.getPrincipal();
        return sysUser;
    }
}
