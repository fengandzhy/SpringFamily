package com.citi.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.citi.springsecurity.bean.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
	
	SysUser findByUsername(String username);	
}
