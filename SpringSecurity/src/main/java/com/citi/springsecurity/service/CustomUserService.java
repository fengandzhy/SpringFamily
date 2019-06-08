package com.citi.springsecurity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.citi.springsecurity.bean.SysRole;
import com.citi.springsecurity.bean.SysUser;
import com.citi.springsecurity.repository.SysUserRepository;

@Service("userDetailsService")
public class CustomUserService implements UserDetailsService{

	@Autowired
    SysUserRepository userRepository;
    
	@Override
	@Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		SysUser user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        
        Set<SysRole> userRoles = user.getRoles();
        System.out.println(userRoles);
        
        for(SysRole role:userRoles) {
        	authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
