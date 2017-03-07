package org.bluepigeon.admin.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "builder")
public class Builder implements java.io.Serializable {

	private Integer id;
	private String name;
	private String headOffice;
	private String email;
	private String mobileNo;
	private String aboutBuilder;
	private Set<BuilderCompanyNames> builderCompanyNames = new HashSet<BuilderCompanyNames>();
	public Builder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Builder(Integer id, String name, String headOffice, String email, String mobileNo, String aboutBuilder,
			Set<BuilderCompanyNames> builderCompanyNames) {
		super();
		this.id = id;
		this.name = name;
		this.headOffice = headOffice;
		this.email = email;
		this.mobileNo = mobileNo;
		this.aboutBuilder = aboutBuilder;
		this.builderCompanyNames = builderCompanyNames;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name", length = 200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "head_office", length = 200)
	public String getHeadOffice() {
		return headOffice;
	}
	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}
	@Column(name = "email", length = 200)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	@Column(name = "mobile", length = 200)
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Column(name = "about_builder", length = 200)
	public String getAboutBuilder() {
		return aboutBuilder;
	}
	public void setAboutBuilder(String aboutBuilder) {
		this.aboutBuilder = aboutBuilder;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "builder")
	public Set<BuilderCompanyNames> getBuilderCompanyNames() {
		return builderCompanyNames;
	}
	public void setBuilderCompanyNames(Set<BuilderCompanyNames> builderCompanyNames) {
		this.builderCompanyNames = builderCompanyNames;
	}
	
	
}
