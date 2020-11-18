package cn.lanca.test.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author hongliang.mei
 * @since 2020/11/18 17:33
 */
@Data
public class User implements UserDetails {
    private String userName;
    private String passWord;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Roles> roles = Arrays.asList(
                new Roles("0012", "tenant", "租户"),
                new Roles("0013", "user", "用户"),
                new Roles("0014", "admin", "管理员")
        );
        for (Roles role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    /**
     * 用户是不是没过期
     *
     * @return 是
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是不是没有锁定🔒
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 认证没有过期？
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 用户是否可用，可以使用
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return false;
    }
}
