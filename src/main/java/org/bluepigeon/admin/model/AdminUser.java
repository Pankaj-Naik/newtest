package org.bluepigeon.admin.model;

// Generated Jun 15, 2015 2:47:47 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AdminUser generated by hbm2java
 */
@Entity
@Table(name = "admin_user")
public class AdminUser implements java.io.Serializable {

	private Integer id;
	private AdminUserRole adminUserRole;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private int status;

	public AdminUser() {
	}

	public AdminUser(AdminUserRole adminUserRole, String name, String email,
			String password, String mobile, int status) {
		this.adminUserRole = adminUserRole;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public AdminUserRole getAdminUserRole() {
		return this.adminUserRole;
	}

	public void setAdminUserRole(AdminUserRole adminUserRole) {
		this.adminUserRole = adminUserRole;
	}

	@Column(name = "name", nullable = false, length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false, length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mobile", nullable = false, length = 10)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
