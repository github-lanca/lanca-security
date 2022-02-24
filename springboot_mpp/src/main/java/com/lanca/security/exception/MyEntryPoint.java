package com.lanca.security.exception;

import com.alibaba.fastjson.JSONObject;
import com.lanca.vo.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异常输出处理
 *
 * @author mei.hongliang
 * @since 2022/2/24 14:41
 */
@Component
public class MyEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 直接提示前端认证错误
        AjaxResult error = AjaxResult.error("URI=" + request.getRequestURI() + "无权限,MyEntryPoint: 认证错误");
        out.write(JSONObject.toJSONString(error));
        out.flush();
        out.close();
    }
}
