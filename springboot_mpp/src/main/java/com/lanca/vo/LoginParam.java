package com.lanca.vo;

import lombok.Data;

/**
 * 登录参数
 *
 * @author mei.hongliang
 * @since 2022/2/24 15:27
 */
@Data
public class LoginParam {

    private String username;
    private String password;
    // token放head里面的
//    private String token;

    // 巴拉巴拉其他参数
}
