package org.bluepigeon.admin.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bluepigeon.admin.dao.BuilderBuildingAmenityDAO;
import org.bluepigeon.admin.dao.BuilderBuildingAmenityStagesDAO;
import org.bluepigeon.admin.dao.BuilderBuildingStatusDAO;
import org.bluepigeon.admin.dao.BuilderCompanyDAO;
import org.bluepigeon.admin.dao.BuilderFlatStatusDAO;
import org.bluepigeon.admin.dao.BuilderGroupDAO;
import org.bluepigeon.admin.dao.BuilderOverallProjectStagesAndSubStagesDAO;
import org.bluepigeon.admin.dao.BuilderPaymentStagesAndSubStagesDAO;
import org.bluepigeon.admin.dao.BuilderProjectApprovalTypeDAO;
import org.bluepigeon.admin.dao.BuilderProjectLevelDAO;
import org.bluepigeon.admin.dao.BuilderProjectPropertyConfigurationDAO;
import org.bluepigeon.admin.dao.BuilderProjectStatusDAO;
import org.bluepigeon.admin.dao.BuilderProjectTypeDAO;
import org.bluepigeon.admin.dao.BuilderPropertyTypeDAO;
import org.bluepigeon.admin.dao.BuilderSellerTypeDAO;
import org.bluepigeon.admin.dao.BuilderTaxTypeDAO;
import org.bluepigeon.admin.exception.ResponseMessage;
import org.bluepigeon.admin.model.BuilderBuildingAmenity;
import org.bluepigeon.admin.model.BuilderBuildingAmenityStages;
import org.bluepigeon.admin.model.BuilderBuildingStatus;
import org.bluepigeon.admin.model.BuilderCompany;
import org.bluepigeon.admin.model.BuilderFlatStatus;
import org.bluepigeon.admin.model.BuilderGroup;
import org.bluepigeon.admin.model.BuilderOverallProjectStagesAndSubStages;
import org.bluepigeon.admin.model.BuilderPaymentStagesAndSubStages;
import org.bluepigeon.admin.model.BuilderProjectApprovalType;
import org.bluepigeon.admin.model.BuilderProjectLevel;
import org.bluepigeon.admin.model.BuilderProjectPropertyConfiguration;
import org.bluepigeon.admin.model.BuilderProjectStatus;
import org.bluepigeon.admin.model.BuilderProjectType;
import org.bluepigeon.admin.model.BuilderPropertyType;
import org.bluepigeon.admin.model.BuilderSellerType;
import org.bluepigeon.admin.model.BuilderTaxType;

@Path("create")
public class CreateProjectController {

	
	@POST
	@Path("/builder/building/amenity/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderBuildingAmenity(@FormParam("name") String name, @FormParam("status") byte status) {
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();

		builderBuildingAmenity.setName(name);
		builderBuildingAmenity.setStatus(status);
		BuilderBuildingAmenityDAO builderBuildingAmenityDAO = new BuilderBuildingAmenityDAO();
		return builderBuildingAmenityDAO.save(builderBuildingAmenity);
	}

	@POST
	@Path("/builder/building/amenity/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderBuildingAmenity(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("status") byte status) {
		
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();
		builderBuildingAmenity.setId(id);
		builderBuildingAmenity.setName(name);
		builderBuildingAmenity.setStatus(status);
		BuilderBuildingAmenityDAO builderBuildingAmenityDAO = new BuilderBuildingAmenityDAO();
		return builderBuildingAmenityDAO.update(builderBuildingAmenity);
	}
	
	@DELETE
	@Path("/builder/building/amenity/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderBuildingAmenity(@FormParam("amenityid") int amenityid) {
		
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();
		builderBuildingAmenity.setId(amenityid);
		System.out.println("Hi from Bulder amenity delete id :: "+amenityid);
		BuilderBuildingAmenityDAO builderBuildingAmenityDAO  = new BuilderBuildingAmenityDAO();
		return builderBuildingAmenityDAO.delete(builderBuildingAmenity);
	}
	
	@GET
	@Path("/builder/building/amenity/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BuilderBuildingAmenity> getBuilderBuildingAmenity(@QueryParam("amenity_id") int amenity_id) {
		BuilderBuildingAmenityDAO stateImp = new BuilderBuildingAmenityDAO();
		return stateImp.getBuilderBuildingAmenityById(amenity_id);
	}
	
	@POST
	@Path("/builder/building/amenity/stages/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderBuildingAmenityStages(@FormParam("amenity_id") int amenityId,@FormParam("name") String name, @FormParam("status") byte status) {
		
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();
		builderBuildingAmenity.setId(amenityId);
		
		BuilderBuildingAmenityStages builderBuildingAmenityStages = new BuilderBuildingAmenityStages();

		builderBuildingAmenityStages.setName(name);
		builderBuildingAmenityStages.setStatus(status);
		builderBuildingAmenityStages.setBuilderBuildingAmenity(builderBuildingAmenity);
		BuilderBuildingAmenityStagesDAO builderBuildingAmenityStagesDAO = new BuilderBuildingAmenityStagesDAO();
		return builderBuildingAmenityStagesDAO.save(builderBuildingAmenityStages);
	}

	@POST
	@Path("/builder/building/amenity/stages/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderBuildingAmenityStages(@FormParam("amenity_id") int amenityId,@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("status") byte status) {
		
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();
		builderBuildingAmenity.setId(amenityId);
		
		BuilderBuildingAmenityStages builderBuildingAmenityStages = new BuilderBuildingAmenityStages();
		builderBuildingAmenityStages.setId(id);
		builderBuildingAmenityStages.setName(name);
		builderBuildingAmenityStages.setStatus(status);
		builderBuildingAmenityStages.setBuilderBuildingAmenity(builderBuildingAmenity);
		BuilderBuildingAmenityStagesDAO builderBuildingAmenityStagesDAO = new BuilderBuildingAmenityStagesDAO();
		return builderBuildingAmenityStagesDAO.update(builderBuildingAmenityStages);
	}
	
	@DELETE
	@Path("/builder/building/amenity/stages/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderBuildingAmenityStages(@FormParam("amenity_substage_id") int amenityid) {
		
		BuilderBuildingAmenityStages builderBuildingAmenity = new BuilderBuildingAmenityStages();
		builderBuildingAmenity.setId(amenityid);
		BuilderBuildingAmenityStagesDAO builderBuildingAmenityDAO  = new BuilderBuildingAmenityStagesDAO();
		return builderBuildingAmenityDAO.delete(builderBuildingAmenity);
	}
	
	@GET
	@Path("/builder/building/amenity/stages/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BuilderBuildingAmenityStages> getBuilderBuildingAmenityStages(@QueryParam("amenity_id") int amenity_id) {
		BuilderBuildingAmenityStagesDAO builderBuildingAmenityStagesDAO = new BuilderBuildingAmenityStagesDAO();
		return builderBuildingAmenityStagesDAO.getStateByAmenityId(amenity_id);
	}
	
	@POST
	@Path("/builder/building/amenity/stages/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderBuildingAmenityStages(@FormParam("amenity_id") int amenityId,@FormParam("name") String name, @FormParam("status") byte status) {
		
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();
		builderBuildingAmenity.setId(amenityId);
		
		BuilderBuildingAmenityStages builderBuildingAmenityStages = new BuilderBuildingAmenityStages();

		builderBuildingAmenityStages.setName(name);
		builderBuildingAmenityStages.setStatus(status);
		builderBuildingAmenityStages.setBuilderBuildingAmenity(builderBuildingAmenity);
		BuilderBuildingAmenityStagesDAO builderBuildingAmenityStagesDAO = new BuilderBuildingAmenityStagesDAO();
		return builderBuildingAmenityStagesDAO.save(builderBuildingAmenityStages);
	}

	@POST
	@Path("/builder/building/amenity/stages/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderBuildingAmenityStages(@FormParam("amenityid") int amenityId,@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("status") byte status) {
		
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();
		builderBuildingAmenity.setId(amenityId);
		
		BuilderBuildingAmenityStages builderBuildingAmenityStages = new BuilderBuildingAmenityStages();
		builderBuildingAmenityStages.setId(id);
		builderBuildingAmenityStages.setName(name);
		builderBuildingAmenityStages.setStatus(status);
		BuilderBuildingAmenityStagesDAO builderBuildingAmenityStagesDAO = new BuilderBuildingAmenityStagesDAO();
		return builderBuildingAmenityStagesDAO.update(builderBuildingAmenityStages);
	}
	
	@DELETE
	@Path("/builder/building/amenity/stages/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderBuildingAmenityStages(@FormParam("amenityid") int amenityid) {
		
		BuilderBuildingAmenity builderBuildingAmenity = new BuilderBuildingAmenity();
		builderBuildingAmenity.setId(amenityid);
		System.out.println("Hi, delete from amenity :: "+amenityid);
		BuilderBuildingAmenityDAO builderBuildingAmenityDAO  = new BuilderBuildingAmenityDAO();
		return builderBuildingAmenityDAO.delete(builderBuildingAmenity);
	}
	
	
	@POST
	@Path("/building/status/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBulidingStatus(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderBuildingStatus buildingAmenetiesType = new BuilderBuildingStatus();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderBuildingStatusDAO stateImp = new BuilderBuildingStatusDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/building/status/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuildingStatus(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		BuilderBuildingStatus state = new BuilderBuildingStatus();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderBuildingStatusDAO stateImp = new BuilderBuildingStatusDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/building/status/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuildingStatus(@FormParam("id") int id) {
		
		BuilderBuildingStatus country = new BuilderBuildingStatus();
		country.setId(id);
		
		BuilderBuildingStatusDAO countryService = new BuilderBuildingStatusDAO();
		return countryService.delete(country);
	}
	
	
	@POST
	@Path("/builder/company/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderCompany(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderCompany buildingAmenetiesType = new BuilderCompany();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderCompanyDAO stateImp = new BuilderCompanyDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/company/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderCompany(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		BuilderCompany state = new BuilderCompany();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderCompanyDAO stateImp = new BuilderCompanyDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/company/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderCompany(@FormParam("id") int id) {
		
		BuilderCompany country = new BuilderCompany();
		country.setId(id);
		
		BuilderCompanyDAO countryService = new BuilderCompanyDAO();
		return countryService.delete(country);
	}
	

	
	
	@POST
	@Path("/flat/status/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderFlatStatus(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderFlatStatus buildingAmenetiesType = new BuilderFlatStatus();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderFlatStatusDAO stateImp = new BuilderFlatStatusDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/flat/status/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderFlatStatus(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		BuilderFlatStatus state = new BuilderFlatStatus();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderFlatStatusDAO stateImp = new BuilderFlatStatusDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/flat/status/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderFlatStatus(@FormParam("id") int id) {
		
		BuilderFlatStatus country = new BuilderFlatStatus();
		country.setId(id);
		
		BuilderFlatStatusDAO countryService = new BuilderFlatStatusDAO();
		return countryService.delete(country);
	}

	
	@POST
	@Path("/builder/group/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderGroup(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderGroup buildingAmenetiesType = new BuilderGroup();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderGroupDAO stateImp = new BuilderGroupDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/group/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderGroup(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		BuilderGroup state = new BuilderGroup();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderGroupDAO stateImp = new BuilderGroupDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/group/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderGroup(@FormParam("id") int id) {
		
		BuilderGroup country = new BuilderGroup();
		country.setId(id);
		
		BuilderGroupDAO countryService = new BuilderGroupDAO();
		return countryService.delete(country);
	}
	@POST
	@Path("/builder/project/satges/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderOverallProjectStagesAndSubStages(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderOverallProjectStagesAndSubStages buildingAmenetiesType = new BuilderOverallProjectStagesAndSubStages();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderOverallProjectStagesAndSubStagesDAO stateImp = new BuilderOverallProjectStagesAndSubStagesDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/project/satges/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderOverallProjectStagesAndSubStages(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderOverallProjectStagesAndSubStages state = new BuilderOverallProjectStagesAndSubStages();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderOverallProjectStagesAndSubStagesDAO stateImp = new BuilderOverallProjectStagesAndSubStagesDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/project/satges/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderOverallProjectStagesAndSubStages(@FormParam("id") int id) {
		
		BuilderOverallProjectStagesAndSubStages country = new BuilderOverallProjectStagesAndSubStages();
		country.setId(id);
		
		BuilderOverallProjectStagesAndSubStagesDAO countryService = new BuilderOverallProjectStagesAndSubStagesDAO();
		return countryService.delete(country);
	}
	
	
	@POST
	@Path("/builder/payment/satges/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderPaymentStagesAndSubStages(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderPaymentStagesAndSubStages buildingAmenetiesType = new BuilderPaymentStagesAndSubStages();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderPaymentStagesAndSubStagesDAO stateImp = new BuilderPaymentStagesAndSubStagesDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/payment/satges/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderPaymentStagesAndSubStages(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderPaymentStagesAndSubStages state = new BuilderPaymentStagesAndSubStages();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderPaymentStagesAndSubStagesDAO stateImp = new BuilderPaymentStagesAndSubStagesDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/payment/satges/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderPaymentStagesAndSubStages(@FormParam("id") int id) {
		
		BuilderPaymentStagesAndSubStages country = new BuilderPaymentStagesAndSubStages();
		country.setId(id);
		
		BuilderPaymentStagesAndSubStagesDAO countryService = new BuilderPaymentStagesAndSubStagesDAO();
		return countryService.delete(country);
	}
	
	
	@POST
	@Path("/builder/project/approval/type/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderProjectApprovalType(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderProjectApprovalType buildingAmenetiesType = new BuilderProjectApprovalType();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderProjectApprovalTypeDAO stateImp = new BuilderProjectApprovalTypeDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/project/approval/type/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderProjectApprovalType(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderProjectApprovalType state = new BuilderProjectApprovalType();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderProjectApprovalTypeDAO stateImp = new BuilderProjectApprovalTypeDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/project/approval/type/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderProjectApprovalType(@FormParam("id") int id) {
		
		BuilderProjectApprovalType country = new BuilderProjectApprovalType();
		country.setId(id);
		
		BuilderProjectApprovalTypeDAO countryService = new BuilderProjectApprovalTypeDAO();
		return countryService.delete(country);
	}
	
	@POST
	@Path("/builder/project/level/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderProjectLevel(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderProjectLevel buildingAmenetiesType = new BuilderProjectLevel();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderProjectLevelDAO stateImp = new BuilderProjectLevelDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/project/level/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderProjectLevel(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderProjectLevel state = new BuilderProjectLevel();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderProjectLevelDAO stateImp = new BuilderProjectLevelDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/project/level/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderProjectLevel(@FormParam("id") int id) {
		
		BuilderProjectLevel country = new BuilderProjectLevel();
		country.setId(id);
		
		BuilderProjectLevelDAO countryService = new BuilderProjectLevelDAO();
		return countryService.delete(country);
	}
	
	@POST
	@Path("/builder/project/propertyconfig/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderProjectPropertyConfiguration(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderProjectPropertyConfiguration buildingAmenetiesType = new BuilderProjectPropertyConfiguration();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderProjectPropertyConfigurationDAO stateImp = new BuilderProjectPropertyConfigurationDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/project/propertyconfig/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderProjectPropertyConfiguration(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderProjectPropertyConfiguration state = new BuilderProjectPropertyConfiguration();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderProjectPropertyConfigurationDAO stateImp = new BuilderProjectPropertyConfigurationDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/project/propertyconfig/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderProjectPropertyConfiguration(@FormParam("id") int id) {
		
		BuilderProjectPropertyConfiguration country = new BuilderProjectPropertyConfiguration();
		country.setId(id);
		
		BuilderProjectPropertyConfigurationDAO countryService = new BuilderProjectPropertyConfigurationDAO();
		return countryService.delete(country);
	}
	
	@POST
	@Path("/builder/project/status/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderProjectStatus(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderProjectStatus buildingAmenetiesType = new BuilderProjectStatus();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderProjectStatusDAO stateImp = new BuilderProjectStatusDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/project/status/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderProjectStatus(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderProjectStatus state = new BuilderProjectStatus();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderProjectStatusDAO stateImp = new BuilderProjectStatusDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/project/status/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderProjectStatus(@FormParam("id") int id) {
		
		BuilderProjectStatus country = new BuilderProjectStatus();
		country.setId(id);
		
		BuilderProjectStatusDAO countryService = new BuilderProjectStatusDAO();
		return countryService.delete(country);
	}
	
	@POST
	@Path("/builder/project/type/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderProjectType(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderProjectType buildingAmenetiesType = new BuilderProjectType();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderProjectTypeDAO stateImp = new BuilderProjectTypeDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/project/type/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderProjectType(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderProjectType state = new BuilderProjectType();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderProjectTypeDAO stateImp = new BuilderProjectTypeDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/project/type/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderProjectType(@FormParam("id") int id) {
		
		BuilderProjectType country = new BuilderProjectType();
		country.setId(id);
		
		BuilderProjectTypeDAO countryService = new BuilderProjectTypeDAO();
		return countryService.delete(country);
	}
	@POST
	@Path("/builder/property/type/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderPropertyType(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderPropertyType buildingAmenetiesType = new BuilderPropertyType();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderPropertyTypeDAO stateImp = new BuilderPropertyTypeDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/property/type/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderPropertyType(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderPropertyType state = new BuilderPropertyType();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderPropertyTypeDAO stateImp = new BuilderPropertyTypeDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/property/type/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderPropertyType(@FormParam("id") int id) {
		
		BuilderPropertyType country = new BuilderPropertyType();
		country.setId(id);
		
		BuilderPropertyTypeDAO countryService = new BuilderPropertyTypeDAO();
		return countryService.delete(country);
	}
	@POST
	@Path("/builder/seller/type/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderSellerType(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderSellerType buildingAmenetiesType = new BuilderSellerType();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderSellerTypeDAO stateImp = new BuilderSellerTypeDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/seller/type/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderSellerType(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderSellerType state = new BuilderSellerType();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderSellerTypeDAO stateImp = new BuilderSellerTypeDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/seller/type/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderSellerType(@FormParam("id") int id) {
		
		BuilderSellerType country = new BuilderSellerType();
		country.setId(id);
		
		BuilderSellerTypeDAO countryService = new BuilderSellerTypeDAO();
		return countryService.delete(country);
	}
	@POST
	@Path("/builder/tax/type/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilderTaxType(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderTaxType buildingAmenetiesType = new BuilderTaxType();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderTaxTypeDAO stateImp = new BuilderTaxTypeDAO();
		return stateImp.save(buildingAmenetiesType);
	}

	@POST
	@Path("/builder/tax/type/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateBuilderTaxType(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("stock") String sstatus) {
		byte status=0;
		  if(sstatus.equals("Yes"))
			  status=1;
		  BuilderTaxType state = new BuilderTaxType();
		state.setId(id);
		state.setName(name);
		state.setStatus(status);
		BuilderTaxTypeDAO stateImp = new BuilderTaxTypeDAO();
		return stateImp.update(state);
	}
	
	@DELETE
	@Path("/builder/tax/type/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteBuilderTaxType(@FormParam("id") int id) {
		
		BuilderTaxType country = new BuilderTaxType();
		country.setId(id);
		
		BuilderTaxTypeDAO countryService = new BuilderTaxTypeDAO();
		return countryService.delete(country);
	}
	
	
	@POST
	@Path("/builder/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addBuilder(@FormParam("name") String name, @FormParam("stock") String sstatus) {
		BuilderTaxType buildingAmenetiesType = new BuilderTaxType();
		byte status=0;
		  if(sstatus.equals("Yes"))
    	status=1;
		buildingAmenetiesType.setName(name);
		buildingAmenetiesType.setStatus(status);
		BuilderTaxTypeDAO stateImp = new BuilderTaxTypeDAO();
		return stateImp.save(buildingAmenetiesType);
	}


   
}
