package com.cts.HotelManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "admin")
public class Admin {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, nullable=false)
	private String adminId;
	
	@Column(nullable = false)
	private String password;
	
	public Admin() {}

	public Admin(String adminId, String password) {
		this.adminId = adminId;
		this.password = password;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
