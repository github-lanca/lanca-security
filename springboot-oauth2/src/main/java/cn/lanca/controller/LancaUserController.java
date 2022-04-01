package cn.lanca.controller;

import cn.lanca.common.vo.base.R;
import cn.lanca.service.ILoginService;
import cn.lanca.vo.LancaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/4/1 16:41  <br>
 */
@RestController
public class LancaUserController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public R login(@RequestBody LancaUser lancaUser){
        return loginService.login(lancaUser);
    }
}
