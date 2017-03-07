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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "builder_building_amenity")
public class BuilderBuildingAmenity implements java.io.Serializable {

	private Integer id;
	private String name;
	private byte status;
	private Set<BuilderBuildingAmenityStages> builderBuildingAmenityStages = new HashSet<BuilderBuildingAmenityStages>(
			0);

	public BuilderBuildingAmenity() {
		// TODO Auto-generated constructor stub
	}

	public BuilderBuildingAmenity(Integer id, String name, byte status,
			Set<BuilderBuildingAmenityStages> builderBuildingAmenityStages) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.builderBuildingAmenityStages = builderBuildingAmenityStages;
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
	@Column(name = "status")
	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "builderBuildingAmenity")
	public Set<BuilderBuildingAmenityStages> getBuilderBuildingAmenityStages() {
		return builderBuildingAmenityStages;
	}

	public void setBuilderBuildingAmenityStages(Set<BuilderBuildingAmenityStages> builderBuildingAmenityStages) {
		this.builderBuildingAmenityStages = builderBuildingAmenityStages;
	}

}
