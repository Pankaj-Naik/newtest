<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@include file="../head.jsp"%>
<%@include file="../leftnav.jsp"%>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Tables</a>
							</li>
							<li class="active">Add Builder</li>
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								Settings
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Add new builder
								</small>
							</h1>
						</div><!-- /.page-header -->
                         <div>
                         <button id="addbuilder" class="btn btn-info">
												Add Builder
												<i class="ace-icon fa fa-plus  align-top bigger-125 icon-on-right"></i>
											</button>
                         </div>
						
				</div>
			
</div>
</div>
<%@include file="../footer.jsp"%>
			

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
		$("#addbuilder").click(function(){
			
			window.location.href="${baseUrl}/settings/newBuilder.jsp";
		});
			
			
			
			
			
		</script>
	</body>
</html>
