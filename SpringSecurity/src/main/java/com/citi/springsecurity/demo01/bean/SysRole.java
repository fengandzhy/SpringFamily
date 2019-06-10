package com.citi.springsecurity.demo01.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4131793339387895820L;
	
	private Integer id;

    private String name;
    
    private Set<SysUser> users;

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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy = "roles")
	public Set<SysUser> getUsers() {
		return users;
	}
	
	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}
    
	@Override
	public int hashCode() {
		final int prime =31;
		int result =super.hashCode();
		result = prime*result + ((id==null)? 0:id.hashCode());
		result = prime*result + ((name==null)? 0:name.hashCode());
		//result = prime*result + ((users==null)? 0:users.hashCode());
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
		SysRole other = (SysRole) obj;
		
		if(id == null){
			if(other.id!=null){
				return false;
			}
		}else if(!id.equals(other.id)){
			return false;
		}		
		if(name == null){
			if(other.name!=null){
				return false;
			}
		}else if(!name.equals(other.name)){
			return false;
		}		
		if(users == null){
			if(other.users!=null){
				return false;
			}
		}else if(!users.equals(other.users)){
			return false;
		}		
		return true;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
