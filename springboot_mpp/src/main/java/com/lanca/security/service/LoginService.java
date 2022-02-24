package com.lanca.security.service;

import com.lanca.vo.AjaxResult;
import com.lanca.vo.LoginParam;

/**
 * @author mei.hongliang
 * @since 2022/2/24 14:47
 */
public interface LoginService {
    //其他业务接口
    AjaxResult xxx();
    AjaxResult login(LoginParam loginParam);
}
