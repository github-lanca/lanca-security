package cn.lanca.service.impl;

import cn.lanca.common.vo.base.R;
import cn.lanca.mapper.LancaUserMapper;
import cn.lanca.service.ILoginService;
import cn.lanca.vo.LancaUser;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/4/1 16:44  <br>
 */
@Service
public class LoginServiceImpl implements ILoginService, UserDetailsService {
    @Autowired
    private LancaUserMapper userMapper;


    @Override
    public R login(LancaUser lancaUser) {
        return null;
    }

    /**
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Wrapper<LancaUser> wrapper = new QueryWrapper<>(new LancaUser(username));
        LancaUser lancaUser = userMapper.selectOne(wrapper);
        return null;
    }
}
