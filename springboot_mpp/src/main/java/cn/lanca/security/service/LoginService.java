package cn.lanca.security.service;

import cn.lanca.vo.AjaxResult;
import cn.lanca.vo.LoginParam;

/**
 * @author mei.hongliang
 * @since 2022/2/24 14:47
 */
public interface LoginService {
    AjaxResult login(LoginParam loginParam);
}
