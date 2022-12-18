package com.java.api.security;

import com.java.api.business.ICustomerManager;
import com.java.api.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class JwtUserDetails implements UserDetails {
    public Long id;
    private String mailadress;
    private Long password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(Long id, String mailadress, Long password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.mailadress = mailadress;
        this.password = password;
        this.authorities = authorities;
    }
    public static JwtUserDetails create(Customer user){
        List<GrantedAuthority> authoritiesList=new ArrayList<>();
        authoritiesList.add(new SimpleGrantedAuthority("user"));
        return new JwtUserDetails(user.getId(), user.getMailadress(), user.getPassword(),authoritiesList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
