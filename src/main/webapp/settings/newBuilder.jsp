<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@include file="../head.jsp"%>
<%@include file="../leftnav.jsp"%>
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">Forms</a></li>
						<li class="active">New Builder</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>New Builder</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Builder Name </label>

									<div class="col-sm-9">
										<input type="text" id="bname" placeholder="Builder Name"
											class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1" for="form-field-11">Head Office</label>
									<div class="col-sm-4">
										<textarea id="hoffice"
											class="autosize-transition form-control"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> Phone Number </label>

									<div class="col-sm-9">
										<input type="text" id="hphno"
											placeholder="Phone Numbers" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> Email </label>

									<div class="col-sm-9">
										<input type="text" id="hemail" placeholder="Email ids"
											class="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Company Name </label>

									<div class="col-sm-9">
										<input type="text" id="cname-1"
											placeholder="Company Name" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Contact </label>

									<div class="col-sm-9">
										<input type="text" id="contact-1"
											placeholder="Contact number" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1">Email </label>

									<div class="col-sm-9">
										<input type="text" id="cemail-1" placeholder="Email"
											class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div id="addCompanyName"></div>

								<div class="clearfix form-actions">

									<div class="col-md-offset-3 col-md-9">
										 <input type="button" id="addBuilder" value="Add Company" onclick="javascript:addBuilderCompanyName()"
											class="btn btn-info ">
											
										&nbsp; &nbsp; &nbsp;
										<button id="saveBuilder" class="btn btn-info" type="button">
											<i class="ace-icon fa fa-check bigger-110"></i> Submit
										</button>

										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i> Reset
										</button>
									</div>
								</div>



							</form>

						<%@include file="../footer.jsp"%>
						<!-- inline scripts related to this page -->
						<script type="text/javascript">
			
				
			function ValidateEmail(email) {
		        var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		        return expr.test(email);
		    };
			
		    var batch_count =1;
		    function addBuilderCompanyName()
			{
		    	alert("Hello...");
		    	batch_count++;
		    	alert("Count :"+batch_count);
		    	var batch='<div class="form-group">';
		    	batch+='<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Company Name </label>';
		    	batch+='<div class="col-sm-9">';
		    	batch+='<input type="text" id="cname-'+batch_count+'" placeholder="Company Name" class="col-xs-10 col-sm-5" />';
		    	batch+='</div>';
		    	batch+='</div>';
		    	batch+='<div class="form-group">';
		    	batch+='<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Contact </label>';
		    	batch+='<div class="col-sm-9">';
		    	batch+='<input type="text" id="contact-'+batch_count+'" placeholder="Contact number" class="col-xs-10 col-sm-5" />';
		    	batch+='</div>';
		    	batch+='</div>';
		    	batch+='<div class="form-group">';
		    	batch+='<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Email </label>';
		    	batch+='<div class="col-sm-9">';
		    	batch+='<input type="text" id="cemail-'+batch_count+'" placeholder="Email" class="col-xs-10 col-sm-5" />';
		    	batch+='</div></div>';
		    	
		    	$("#addCompanyName").append(batch);
		    	
		    	}	
		    $("#saveBuilder").click(function(){
		    	saveNewBuilder();
		    })
		    function saveNewBuilder(){
		    	
		    var cname=[];
		    var cno=[];
		    var cemail=[];
		    	for(int i=0;i<batch_count;i++){
		    		cname[i]=$("#cname-"+batch_count).val();
		    		cno[i]=$("#contact-"+batch_count).val();
		    		cemail[i]=$("#cemail-"+batch_count).val();
		    	}
		    	alert("Hi from save");
		    }
		    </script>
</body>
</html>
