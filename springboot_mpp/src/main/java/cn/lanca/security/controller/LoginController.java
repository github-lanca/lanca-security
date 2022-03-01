package cn.lanca.security.controller;

import cn.lanca.security.util.LoginUserUtil;
import cn.lanca.vo.AjaxResult;
import cn.lanca.vo.LoginParam;
import cn.lanca.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginParam loginParam) {
        return loginService.login(loginParam);
    }

    /**
     * 退出
     *
     * @return String
     */
    @GetMapping("/loggggout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "退出成功";
    }

    /**
     * 退出
     *
     * @return String
     */
    @GetMapping("/currentUser")
    public AjaxResult currentUser() {

        //
        System.out.println("------------------------------------");

        AjaxResult success = AjaxResult.success("这是请求返回的当前对象");
        success.put("data",LoginUserUtil.getLoginUser());
        return success;
    }
}
