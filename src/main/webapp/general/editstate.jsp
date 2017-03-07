<%@page import="org.bluepigeon.admin.dao.StateImp"%>
<%@page import="org.bluepigeon.admin.dao.CountryDAOImp"%>
<%@page import="org.bluepigeon.admin.model.Country"%>
<%@page import="org.bluepigeon.admin.model.State"%>

<%@page import="java.util.List"%>
<%
	int country_size = 0;
	int state_size = 0;
	List<Country> country_list = null;
	CountryDAOImp countryService = new CountryDAOImp();
	List<Country> listCountry = countryService.getCountryList();
	country_size = listCountry.size(); 
	List<State> state_list = null;
	StateImp stateList = new StateImp();
	int state_id = Integer.parseInt(request.getParameter("state_id"));
	List<State> state_detail = null;
	State state = null;
	if (state_id > 0) {
		state_detail = new StateImp().getStateById(state_id);
		if(state_detail.size() > 0)
		state = state_detail.get(0);
		state_list = stateList.getStateByCountryId(state.getCountry().getId());
		state_size = state_list.size();
	}
%>				<input type="hidden" name="city_id" id="ucity_id" value="<% out.print(state.getId()); %>"/>
				<div class="row" style=padding:20px">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Select Country</label>
                       		<select name="country_id" id="ucountry_id" class="form-control">
								<option value=""> Select Country </option>
								<% for(int i=0; i < country_size ; i++){ %>
								<option value="<% out.print(listCountry.get(i).getId());%>" <% if(listCountry.get(i).getId() == state.getCountry().getId()){ %>selected<%}  %>><% out.print(listCountry.get(i).getName());%></option>
								<% } %>
							</select>
                  		</div>
              		</div>
              	</div>
              
              	<div class="row">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">City Name</label>
                       		<input type="text" name="name" id="uname" value="<% out.print(state.getName()); %>" class="form-control" placeholder="Enter State Name"/>
                  		</div>
              		</div>
              	</div>
              	<div class="row">
              		<div class="col-xs-12">
                  		<div class="form-group">
                       		<label for="password" class="control-label">Status</label>
                       		<select name="status" id="ustatus" class="form-control">
								<option value="1" <% if(state.getStatus() == 1) { %>selected<% } %>> Active </option>
								<option value="0" <% if(state.getStatus() == 0) { %>selected<% } %>> Inactive </option>
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
$("#country_id").change(function(){
	$.get("${baseUrl}/webapi/general/state/list",{ country_id: $("#country_id").val() }, function(data){
		var html = '<option value="">Select State</optio>';
		$(data).each(function(index){
			html = html + '<option value="'+data[index].id+'">'+data[index].name+'</optio>';
		});
		$("#ustate_id").html(html);
	},'json');
});
</script>