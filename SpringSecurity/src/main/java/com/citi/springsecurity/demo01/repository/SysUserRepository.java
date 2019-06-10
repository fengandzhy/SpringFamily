package com.citi.springsecurity.demo01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.springsecurity.demo01.bean.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
	
	SysUser findByUsername(String username);	
}
