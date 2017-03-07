package org.bluepigeon.admin.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "builder_building_amenity_stages",uniqueConstraints = @UniqueConstraint(columnNames = {"amenity_id"}))
public class BuilderBuildingAmenityStages implements java.io.Serializable {
	private Integer id;
	private String name;
	private byte status;
	private BuilderBuildingAmenity builderBuildingAmenity;
	private Set<BuilderBuildingAmenitySubstages> buildingAmenitySubstages = new HashSet<BuilderBuildingAmenitySubstages>(
			0);

	public BuilderBuildingAmenityStages() {
		// TODO Auto-generated constructor stub
	}

	public BuilderBuildingAmenityStages(Integer id, String name, byte status,
			BuilderBuildingAmenity builderBuildingAmenity,
			Set<BuilderBuildingAmenitySubstages> buildingAmenitySubstages) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.builderBuildingAmenity = builderBuildingAmenity;
		this.buildingAmenitySubstages = buildingAmenitySubstages;
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "amenity_id")
	public BuilderBuildingAmenity getBuilderBuildingAmenity() {
		return builderBuildingAmenity;
	}

	public void setBuilderBuildingAmenity(BuilderBuildingAmenity builderBuildingAmenity) {
		this.builderBuildingAmenity = builderBuildingAmenity;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "builderBuildingAmenityStages")
	public Set<BuilderBuildingAmenitySubstages> getBuildingAmenitySubstages() {
		return buildingAmenitySubstages;
	}

	public void setBuildingAmenitySubstages(Set<BuilderBuildingAmenitySubstages> buildingAmenitySubstages) {
		this.buildingAmenitySubstages = buildingAmenitySubstages;
	}

}
