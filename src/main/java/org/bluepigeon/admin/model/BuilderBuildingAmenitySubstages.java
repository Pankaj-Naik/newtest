package org.bluepigeon.admin.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "builder_building_amenity_substages",uniqueConstraints = @UniqueConstraint(columnNames = {"stage_id"}))
public class BuilderBuildingAmenitySubstages {
	private Integer id;
	private String name;
	private byte status;
	private BuilderBuildingAmenityStages builderBuildingAmenityStages;

	public BuilderBuildingAmenitySubstages() {
		// TODO Auto-generated constructor stub
	}

	public BuilderBuildingAmenitySubstages(Integer id, String name, byte status,
			BuilderBuildingAmenityStages builderBuildingAmenityStages) {
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "stage_id")
	public BuilderBuildingAmenityStages getBuilderBuildingAmenityStages() {
		return builderBuildingAmenityStages;
	}

	public void setBuilderBuildingAmenityStages(BuilderBuildingAmenityStages builderBuildingAmenityStages) {
		this.builderBuildingAmenityStages = builderBuildingAmenityStages;
	}

}
