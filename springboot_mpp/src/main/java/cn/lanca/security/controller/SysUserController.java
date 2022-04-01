package cn.lanca.security.controller;

import cn.lanca.annotation.KthLog;
import cn.lanca.security.SysUser;
import cn.lanca.security.service.ISysUserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/2 10:07  <br>
 */
@RestController
public class SysUserController {

    @Autowired
    private ISysUserService2 sysUserService;


    @PutMapping("sys_user/test/{id}")
    @KthLog("这是注解打日志描述内容")
    public void test(@PathVariable("id") Integer id) {
        List<SysUser> list = sysUserService.lambdaQuery().list();
        list.forEach(System.out::println);

    }

    public static void main(String[] args) {
        String aa = "";
        System.out.println(StringUtils.isEmpty(aa));
    }


}
