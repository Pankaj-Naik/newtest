//package org.bluepigeon.admin.model;
//
//import static javax.persistence.GenerationType.IDENTITY;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "builder_flat_amenities_stages_and_sub_stages")
//public class BuilderFlatAmenitiesStagesAndSubStages implements java.io.Serializable {
//
//	private Integer id;
//	private String name;
//	private byte status;
//	public BuilderFlatAmenitiesStagesAndSubStages() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public BuilderFlatAmenitiesStagesAndSubStages(Integer id, String name, byte status) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.status = status;
//	}
//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Column(name = "id", unique = true, nullable = false)
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	@Column(name = "name", length = 200)
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	@Column(name = "status")
//	public byte getStatus() {
//		return status;
//	}
//	public void setStatus(byte status) {
//		this.status = status;
//	}
//	
//	
//}
