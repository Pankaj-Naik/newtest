
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.bluepigeon.admin.model.BuilderBuildingAmenity"%>
<%@page import="org.bluepigeon.admin.model.BuilderBuildingAmenityStages"%>
<%@page import="org.bluepigeon.admin.dao.BuilderBuildingAmenityDAO"%>
<%@page import="org.bluepigeon.admin.dao.BuilderBuildingAmenityStagesDAO"%>
<%@page import="java.util.List"%>
<%@include file="../head.jsp"%>
<%@include file="../leftnav.jsp"%>
<%

int amenity_id=0;
int amenity_size=0;
List<BuilderBuildingAmenityStages> amenity_stages_list = null;
List<BuilderBuildingAmenity> amenity_list = null;
int amenity_stages_size=0;
if (request.getParameterMap().containsKey("amenity_id")) {
	amenity_id = Integer.parseInt(request.getParameter("amenity_id"));
	
	if (amenity_id > 0) {
		amenity_stages_list = new BuilderBuildingAmenityStagesDAO().getStateByAmenityId(amenity_id);
		amenity_stages_size = amenity_stages_list.size(); 
	}
}

amenity_list = new BuilderBuildingAmenityDAO().getBuilderBuildingAmenityList();
amenity_size = amenity_list.size();
%>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs ace-save-state" id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>

				<li><a href="#">Create Projects</a></li>
				<li class="active">Building Amenity Stages</li>
			</ul>
		</div>
		<div class="page-content">
			<div class="page-header">
				<h1>
					Building Amenity Stages 
					<a href="#addBuildingAmenityStages" class="btn btn-primary btn-sm pull-right" role="button" data-toggle="modal"><i class="fa fa-plus"></i> New Building Amenity Stage</a>
				</h1>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<form method="post" action="#" class="form-horizontal" id="submitForm" novalidate="novalidate">	
					<div id="myTabContent" class="tab-content">
                        <!--Contacts tab starts-->
                        <div class="tab-pane fade active in" id="contacts" aria-labelledby="contacts-tab">
                            <div class="contacts-list">
                            	<div class="col-sm-6">
		                            <div class="form-group">
						                <label class="col-sm-6 control-label">Select Building Amenity</label>
						                <div class="col-sm-6">
							                <select name="serachamenityid" id="serachamenityid" class="form-control">
							                    <option value="">Select Building Amenity</option>
							                    <% for(int i=0; i < amenity_size ; i++){ %>
												<option value="<% out.print(amenity_list.get(i).getId());%>" <% if(amenity_id == amenity_list.get(i).getId()) { %>selected<% } %>><% out.print(amenity_list.get(i).getName());%></option>
												<% } %>
							                </select>
						                </div>
					                </div>
				                </div>		           
                                <table class="table table-striped table-bordered" id="buildingamenitystagetable">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Status</th>
                                            <th class="alignRight">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<%
                                        for(int i=0; i < amenity_stages_size; i++){
                                        %>
                                        <tr>
                                            <td><% out.print(amenity_stages_list.get(i).getName()); %></td>
                                            <td><% if(amenity_stages_list.get(i).getStatus() == 1) { out.print("<span class='label label-success'>Active</span>"); } else { out.print("<span class='label label-warning'>Inactive</span>"); } %></td>
                                            <td class="alignRight">
                                            	<a href="javascript:editBuildingAmenityStages(<% out.print(amenity_stages_list.get(i).getId()); %>);" class="btn btn-success btn-xs icon-btn"><i class="fa fa-pencil"></i></a>
                                            </td>
                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
               </form>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="addBuildingAmenityStages" class="modal fade" style="">
    <div id="cancel-overlay" class="modal-dialog" style="opacity:1 ;width:400px ">
      	<div class="modal-content">
          	<div class="modal-header">
              	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true" style="color:#fff">×</span><span class="sr-only">Close</span></button>
              	<h4 class="modal-title" id="myModalLabel">Add New Building Amenity Satge</h4>
          	</div>
          	<div class="modal-body" style="background-color:#f5f5f5;">
              	<div class="row" style=padding:20px">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Select Building Amenity</label>
                       		<select name="amenity_id" id="amenity_id" class="form-control">
								<option value=""> Select Building Amenity </option>
								<% for(int i=0; i < amenity_size ; i++){ %>
								<option value="<% out.print(amenity_list.get(i).getId());%>"><% out.print(amenity_list.get(i).getName());%></option>
								<% } %>
							</select>
                  		</div>
              		</div>
              	</div>
              	<div class="row">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Building amenity stage Name</label>
                       		<input type="text" name="name" id="name" class="form-control" placeholder="Enter Building Amenity Stage Name"/>
                  		</div>
              		</div>
              	</div>
              	<div class="row">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Status</label>
                       		<select name="status" id="status" class="form-control">
								<option value="1"> Active </option>
								<option value="0"> Inactive </option>
							</select>
                  		</div>
              		</div>
              	</div>
              	<div class="row">
              		<div class="col-xs-12">
             			<button type="submit" class="btn btn-primary" onclick="addBuildingAmenityStage();">SAVE</button>
             		</div>
              	</div>
          	</div>
      	</div>
  	</div>
</div>
<div id="editBuildingAmenityStage" class="modal fade" style="">
    <div id="cancel-overlay" class="modal-dialog" style="opacity:1 ;width:400px ">
      	<div class="modal-content">
          	<div class="modal-header">
              	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true" style="color:#fff">×</span><span class="sr-only">Close</span></button>
              	<h4 class="modal-title" id="myModalLabel">Update Building Amenity Stage</h4>
          	</div>
          	<div class="modal-body" style="background-color:#f5f5f5;" id="modalarea">
          	</div>
      	</div>
  	</div>
</div>
<%@include file="../footer.jsp"%>
	</body>
</html>
<script>
$(document).ready(function(){
    $('#buildingamenitystagetable').DataTable({
        "aaSorting": []
    });
});
function addBuildingAmenityStage() {
	$.post("${baseUrl}/webapi/create/builder/building/amenity/stages/save/",{ amenity_id: $("#amenity_id").val(), name: $("#name").val(), status: $("#status").val()}, function(data){
		alert(data.message);
		window.location.reload();
	},'json');
}
$("#serachamenityid").change(function(){
	$.get("${baseUrl}/webapi/general/state/list",{ country_id: $("#country_id").val() }, function(data){
		var html = '<option value="">Select State</option>';
		$(data).each(function(index){
			html = html + '<option value="'+data[index].id+'">'+data[index].name+'</option>';
		});
		$("#state_id").html(html);
	},'json');
});

$("#searchcountryId").change(function(){
	$.get("${baseUrl}/webapi/general/state/list",{ country_id: $("#searchcountryId").val() }, function(data){
		var html = '<option value="">Select State</option>';
		$(data).each(function(index){
			html = html + '<option value="'+data[index].id+'">'+data[index].name+'</optio>';
		});
		$("#searchstateId").html(html);
	},'json');
});

$("#searchstateId").change(function(){
	window.location.href = "${baseUrl}/general/city.jsp?state_id="+$("#searchstateId").val();
});

function editBuildingAmenityStages(amenitystageid) {
	$.get("${baseUrl}/general/editbuildingamenitystage.jsp?amenity_stage_id="+amenitystageid,{ }, function(data){
		$("#modalarea").html(data);
		$("#editBuildingAmenityStage").modal('show');
	},'html');
}

function updateCity() {
	$.post("${baseUrl}/webapi/general/city/update/",{ id: $("#ucity_id").val(), state_id: $("#ustate_id").val(), name: $("#uname").val(), status: $("#ustatus").val(), sortorder: 1}, function(data){
		alert(data.message);
		window.location.reload();
	},'json');
}


</script>