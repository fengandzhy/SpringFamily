package com.citi.springsecurity.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -885361988572396301L;
	
	private Integer id;

    private String username;

    private String password;
    
    private Set<SysRole> roles;

    @Id
    @GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany
	@JoinTable(name = "sys_user_role", inverseJoinColumns = @JoinColumn(name = "user_id"), joinColumns = @JoinColumn(name = "role_id")) 
	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
	
	@Override
	public int hashCode() {
		final int prime =31;
		int result =super.hashCode();
		result = prime*result + ((id==null)? 0:id.hashCode());
		result = prime*result + ((username==null)? 0:username.hashCode());
		result = prime*result + ((password==null)? 0:password.hashCode());
		result = prime*result + ((roles==null)? 0:roles.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(null == obj)
			return false;
		if(getClass()!= obj.getClass())
			return false;
		SysUser other = (SysUser) obj;
		
		if(id == null){
			if(other.id!=null){
				return false;
			}
		}else if(!id.equals(other.id)){
			return false;
		}		
		if(username == null){
			if(other.username!=null){
				return false;
			}
		}else if(!username.equals(other.username)){
			return false;
		}		
		if(password == null){
			if(other.password!=null){
				return false;
			}
		}else if(!password.equals(other.password)){
			return false;
		}
		
		if(roles == null){
			if(other.roles!=null){
				return false;
			}
		}else if(!roles.equals(other.roles)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}	
}
