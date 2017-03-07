<%@page import="org.bluepigeon.admin.model.BuilderBuildingAmenity"%>
<%@page import="org.bluepigeon.admin.model.BuilderBuildingAmenityStages"%>
<%@page import="org.bluepigeon.admin.dao.BuilderBuildingAmenityDAO"%>
<%@page import="org.bluepigeon.admin.dao.BuilderBuildingAmenityStagesDAO"%>
<%@page import="java.util.List"%>
<%
	int country_size = 0;
	int state_size = 0;
	BuilderBuildingAmenityDAO builderBuildingAmenityDAO = new BuilderBuildingAmenityDAO();
	List<BuilderBuildingAmenity> listBuilderBuildingAmenity = builderBuildingAmenityDAO.getBuilderBuildingAmenityList();
	country_size = listBuilderBuildingAmenity.size(); 
	
	int amenity_stage_id = Integer.parseInt(request.getParameter("amenity_stage_id"));
	List<BuilderBuildingAmenityStages> city_detail = null;
	BuilderBuildingAmenityStages city = null;
	if (amenity_stage_id > 0) {
		city_detail = new BuilderBuildingAmenityStagesDAO().getBuilderBuildingAmenityStagesById(amenity_stage_id);
		if(city_detail.size() > 0)
		city = city_detail.get(0);
		
	}
%>				<input type="hidden" name="city_id" id="ucity_id" value="<% out.print(city.getId()); %>"/>
				<div class="row" style=padding:20px">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Select Country</label>
                       		<select name="country_id" id="ucountry_id" class="form-control">
								<option value=""> Select Country </option>
								<% for(int i=0; i < country_size ; i++){ %>
								<option value="<% out.print(listBuilderBuildingAmenity.get(i).getId());%>" <% if(listBuilderBuildingAmenity.get(i).getId() == city.getBuilderBuildingAmenity().getId()){ %>selected<%}  %>><% out.print(listBuilderBuildingAmenity.get(i).getName());%></option>
								<% } %>
							</select>
                  		</div>
              		</div>
              	</div>
         
              	<div class="row">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Building Amenity Stage Name</label>
                       		<input type="text" name="name" id="uname" value="<% out.print(city.getName()); %>" class="form-control" placeholder="Enter Building Amenity Stage Name"/>
                  		</div>
              		</div>
              	</div>
              	<div class="row">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Status</label>
                       		<select name="status" id="ustatus" class="form-control">
								<option value="1" <% if(city.getStatus() == 1) { %>selected<% } %>> Active </option>
								<option value="0" <% if(city.getStatus() == 0) { %>selected<% } %>> Inactive </option>
							</select>
                  		</div>
              		</div>
              	</div>
              	<div class="row">
              		<div class="col-xs-12">
             			<button type="submit" class="btn btn-primary" onclick="updateCity();">SAVE</button>
             		</div>
              	</div>
<script type="text/javascript">
// $("#country_id").change(function(){
// 	$.get("${baseUrl}/webapi/general/state/list",{ country_id: $("#country_id").val() }, function(data){
// 		var html = '<option value="">Select State</optio>';
// 		$(data).each(function(index){
// 			html = html + '<option value="'+data[index].id+'">'+data[index].name+'</optio>';
// 		});
// 		$("#ustate_id").html(html);
// 	},'json');
// });
</script>