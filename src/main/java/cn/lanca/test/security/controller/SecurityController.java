package cn.lanca.test.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongliang.mei
 * @since 2020/11/18 23:31
 */
@RestController("/a")
public class SecurityController {

    @GetMapping("/json")
    public String getJson() {
        return "test";
    }
}
