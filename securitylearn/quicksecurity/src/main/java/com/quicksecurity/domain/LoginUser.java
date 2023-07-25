package com.quicksecurity.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails, Serializable {
    private static final long serialVersionUID = -4669473712734298569L;
    private User user;
    private List<String> permissions;  //只需要调用这个序列化就可以，因为它也可以在下面通过以下代码转化成GrantedAuthority对象

    public LoginUser(User user, List<String> permission) {
        this.user = user;
        this.permissions = permission;
    }

    //存储SpringSecurity所需要的权限信息的集合
    @JSONField(serialize = false) //在登陆的时候会把loginuser存入到redis当中，这时候不对这个成员变量进行序列化，因为这个类是spring提供的，redis为安全考虑在序列化时会出出现错误，所以要避免存入redis中，在运行时出现异常
    private List<GrantedAuthority> authorities;

    @Override
    public  Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities!=null){
            return authorities;
        }
        //把permissions中字符串类型的权限信息转换成GrantedAuthority对象存入authorities中
        authorities = permissions.stream().
                map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
