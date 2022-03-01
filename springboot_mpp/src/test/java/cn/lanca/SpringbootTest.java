package cn.lanca;

import cn.lanca.security.mapper.UserMapper;
import cn.lanca.security.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SpringbootTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void test(){
        SysUser sysUser = userMapper.selectById(1);
        System.out.println(sysUser);
    }

    @Test
    void test1(){
        System.out.println(passwordEncoder.encode("1234"));
    }
}
