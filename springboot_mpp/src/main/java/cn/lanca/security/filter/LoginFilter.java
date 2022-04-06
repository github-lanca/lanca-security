package cn.lanca.security.filter;

import cn.lanca.security.service.impl.UserServiceImpl;
import cn.lanca.security.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * jwt携带token验证是否有权限的过滤器
 *
 * @author mei.hongliang
 * @since 2022/2/24 14:14
 */
@Component
public class LoginFilter extends OncePerRequestFilter {

    @Autowired
    private UserServiceImpl userService;


    /**
     * 后续我们再访问其它接口时需要将token放到请求头中。
     * 这里我们需要自定义一个认证过滤器，来对token进行校验
     *
     * @param request  request
     * @param response response
     * @param chain    chain
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // 从请求头中获取token字符串并解析（JwtManager之前文章有详解，这里不多说了）
        Claims claims = null;
        try {
            claims = JwtUtil.parse(request.getHeader("Authorization"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("当前登录用户无权限");
        }
        // token属于之前登录用户，就直接放入上下文中
        if (claims != null) {
            // 从`JWT`中提取出之前存储好的用户名
            String username = claims.getSubject();
            // 查询出用户对象
            UserDetails user = userService.loadUserByUsername(username);
            if (!Objects.isNull(user)) {
                // 手动组装一个认证对象
                logger.info("user有值/username=" + username);
                // principal 最重要的
                // credentials 资格证书
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
                // 将认证对象放到上下文中
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }

}
