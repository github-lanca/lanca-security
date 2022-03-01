package cn.lanca.security.exception;

import cn.lanca.vo.AjaxResult;
import com.alibaba.fastjson.JSONObject;
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
        AjaxResult error = AjaxResult.error("当前请求操作无权限 /"+authException.getMessage());
        error.put("URI",request.getRequestURI());
        out.write(JSONObject.toJSONString(error));
        out.flush();
        out.close();
    }
}
