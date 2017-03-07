package org.bluepigeon.admin.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="builder_company_names")
public class BuilderCompanyNames implements java.io.Serializable {
    private Integer id;
    private Builder builder;
    private String name;
    private String contact;
    private String email;
	public BuilderCompanyNames() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuilderCompanyNames(Integer id, Builder builder, String name, String contact, String email) {
		super();
		this.id = id;
		this.builder = builder;
		this.name = name;
		this.contact = contact;
		this.email = email;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "builder_id")
	public Builder getBuilder() {
		return builder;
	}
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	@Column(name = "name", length = 200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "contact", length = 200)
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Column(name = "email", length = 200)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
