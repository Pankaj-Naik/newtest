<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page import="org.bluepigeon.admin.dao.LocalityNamesImp"%>
<%@page import="org.bluepigeon.admin.model.Locality"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="org.bluepigeon.admin.dao.CityNamesImp"%>
<%@page import="org.bluepigeon.admin.model.City"%>
<%@page import="org.bluepigeon.admin.model.Locality"%>
<%@page import="org.bluepigeon.admin.service.CityNamesService"%>
<%@page import="org.bluepigeon.admin.dao.LocalityNamesImp"%>
<%@page import="java.util.List"%>
<%
int city_id = 0;
int city_size = 0; 
int locality_size = 0;
List<Locality> locality_list = null;
if (request.getParameterMap().containsKey("city_id")) {
    city_id = Integer.parseInt(request.getParameter("city_id"));
}
List<City> city_list = new CityNamesService().getAllCityNames();	
city_size = city_list.size(); 
if (city_id > 0) {
	locality_list = new LocalityNamesImp().getLocalityNames(city_id);
	locality_size = locality_list.size(); 
}
%>
<%@include file="../head.jsp"%>
<%@include file="../leftnav.jsp"%>

<li class=""><a href="country.jsp"> <i
		class="menu-icon fa fa-caret-right"></i> Country
</a>
<li class=""><a href="state.jsp"> <i
		class="menu-icon fa fa-caret-right"></i> State
</a> <b class="arrow"></b></li>
<li class=""><a href="city.jsp"> <i
		class="menu-icon fa fa-caret-right"></i> City
</a> <b class="arrow"></b></li>
<li class="active"><a href="locality.jsp"> <i
		class="menu-icon fa fa-caret-right"></i> Locality
</a> <b class="arrow"></b></li>


<b class="arrow"></b>
</li>
</ul>
</li>

<li class=""><a href="#" class="dropdown-toggle"> <i
		class="menu-icon fa fa-pencil-square-o"></i> <span class="menu-text">
			Create Projects </span> <b class="arrow fa fa-angle-down"></b>
</a> <b class="arrow"></b>

	<ul class="submenu">
		<li class=""><a href=""> <i
				class="menu-icon fa fa-caret-right"></i> Form Elements
		</a> <b class="arrow"></b></li>

		<li class=""><a href="form-elements-2.html"> <i
				class="menu-icon fa fa-caret-right"></i> Form Elements 2
		</a> <b class="arrow"></b></li>

		<li class=""><a href="form-wizard.html"> <i
				class="menu-icon fa fa-caret-right"></i> Wizard &amp; Validation
		</a> <b class="arrow"></b></li>

		<li class=""><a href="wysiwyg.html"> <i
				class="menu-icon fa fa-caret-right"></i> Wysiwyg &amp; Markdown
		</a> <b class="arrow"></b></li>

		<li class=""><a href="dropzone.html"> <i
				class="menu-icon fa fa-caret-right"></i> Dropzone File Upload
		</a> <b class="arrow"></b></li>
	</ul></li>

<li class=""><a href="widgets.html"> <i
		class="menu-icon fa fa-list-alt"></i> <span class="menu-text">
			Widgets </span>
</a> <b class="arrow"></b></li>

<li class=""><a href="calendar.html"> <i
		class="menu-icon fa fa-calendar"></i> <span class="menu-text">
			Calendar <span class="badge badge-transparent tooltip-error"
			title="2 Important Events"> <i
				class="ace-icon fa fa-exclamation-triangle red bigger-130"></i>
		</span>
	</span>
</a> <b class="arrow"></b></li>

<li class=""><a href="gallery.html"> <i
		class="menu-icon fa fa-picture-o"></i> <span class="menu-text">
			Gallery </span>
</a> <b class="arrow"></b></li>

<li class=""><a href="#" class="dropdown-toggle"> <i
		class="menu-icon fa fa-tag"></i> <span class="menu-text"> More
			Pages </span> <b class="arrow fa fa-angle-down"></b>
</a> <b class="arrow"></b>

	<ul class="submenu">
		<li class=""><a href="profile.html"> <i
				class="menu-icon fa fa-caret-right"></i> User Profile
		</a> <b class="arrow"></b></li>

		<li class=""><a href="inbox.html"> <i
				class="menu-icon fa fa-caret-right"></i> Inbox
		</a> <b class="arrow"></b></li>

		<li class=""><a href="pricing.html"> <i
				class="menu-icon fa fa-caret-right"></i> Pricing Tables
		</a> <b class="arrow"></b></li>

		<li class=""><a href="invoice.html"> <i
				class="menu-icon fa fa-caret-right"></i> Invoice
		</a> <b class="arrow"></b></li>

		<li class=""><a href="timeline.html"> <i
				class="menu-icon fa fa-caret-right"></i> Timeline
		</a> <b class="arrow"></b></li>

		<li class=""><a href="search.html"> <i
				class="menu-icon fa fa-caret-right"></i> Search Results
		</a> <b class="arrow"></b></li>

		<li class=""><a href="email.html"> <i
				class="menu-icon fa fa-caret-right"></i> Email Templates
		</a> <b class="arrow"></b></li>

		<li class=""><a href="login.html"> <i
				class="menu-icon fa fa-caret-right"></i> Login &amp; Register
		</a> <b class="arrow"></b></li>
	</ul></li>

<li class=""><a href="#" class="dropdown-toggle"> <i
		class="menu-icon fa fa-file-o"></i> <span class="menu-text">
			Other Pages <span class="badge badge-primary">5</span>
	</span> <b class="arrow fa fa-angle-down"></b>
</a> <b class="arrow"></b>

	<ul class="submenu">
		<li class=""><a href="faq.html"> <i
				class="menu-icon fa fa-caret-right"></i> FAQ
		</a> <b class="arrow"></b></li>

		<li class=""><a href="error-404.html"> <i
				class="menu-icon fa fa-caret-right"></i> Error 404
		</a> <b class="arrow"></b></li>

		<li class=""><a href="error-500.html"> <i
				class="menu-icon fa fa-caret-right"></i> Error 500
		</a> <b class="arrow"></b></li>

		<li class=""><a href="grid.html"> <i
				class="menu-icon fa fa-caret-right"></i> Grid
		</a> <b class="arrow"></b></li>

		<li class=""><a href="blank.html"> <i
				class="menu-icon fa fa-caret-right"></i> Blank Page
		</a> <b class="arrow"></b></li>
	</ul></li>
</ul>
<!-- /.nav-list -->
<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
	<i id="sidebar-toggle-icon"
		class="ace-icon fa fa-angle-double-left ace-save-state"
		data-icon1="ace-icon fa fa-angle-double-left"
		data-icon2="ace-icon fa fa-angle-double-right"></i>
</div>
</div>

<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs ace-save-state" id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>

				<li><a href="#">Tables</a></li>
				<li class="active">Locality</li>
			</ul>
			<!-- /.breadcrumb -->

			<div class="nav-search" id="nav-search">
				<form class="form-search">
					<span class="input-icon"> <input type="text"
						placeholder="Search ..." class="nav-search-input"
						id="nav-search-input" autocomplete="off" /> <i
						class="ace-icon fa fa-search nav-search-icon"></i>
					</span>
				</form>
			</div>
			<!-- /.nav-search -->
		</div>

		<div class="page-content">
			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="ace-icon fa fa-cog bigger-130"></i>
				</div>

				<div class="ace-settings-box clearfix" id="ace-settings-box">
					<div class="pull-left width-50">
						<div class="ace-settings-item">
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="no-skin" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; Choose Skin</span>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-navbar" autocomplete="off" /> <label
								class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-sidebar" autocomplete="off" /> <label
								class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-breadcrumbs" autocomplete="off" /> <label
								class="lbl" for="ace-settings-breadcrumbs"> Fixed
								Breadcrumbs</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-rtl" autocomplete="off" /> <label class="lbl"
								for="ace-settings-rtl"> Right To Left (rtl)</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-add-container" autocomplete="off" /> <label
								class="lbl" for="ace-settings-add-container"> Inside <b>.container</b>
							</label>
						</div>
					</div>
					<!-- /.pull-left -->

					<div class="pull-left width-50">
						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-hover" autocomplete="off" /> <label
								class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-compact" autocomplete="off" /> <label
								class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-highlight" autocomplete="off" /> <label
								class="lbl" for="ace-settings-highlight"> Alt. Active
								Item</label>
						</div>
					</div>
					<!-- /.pull-left -->
				</div>
				<!-- /.ace-settings-box -->
			</div>
			<!-- /.ace-settings-container -->

			<div class="page-header">
				<h1>
					Locality <small> <i
						class="ace-icon fa fa-angle-double-right"></i> Dynamic tables and
						grids using jqGrid plugin
					</small>
				</h1>
			</div>
			<!-- /.page-header -->

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<!-- 	<div class="alert alert-info">
									<button class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>

									<i class="ace-icon fa fa-hand-o-right"></i>
									Please note that demo server is not configured to save the changes, therefore you may see an error message.
								</div>-->

					<table id="grid-table"></table>

					<div id="grid-pager"></div>

					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
</div>
<!-- /.main-content -->

<div class="footer">
	<div class="footer-inner">
		<div class="footer-content">
			<span class="bigger-120"> <span class="blue bolder">Blue</span>
				Pigeon &copy; 2017-2018
			</span> &nbsp; &nbsp; <span class="action-buttons"> <a href="#">
					<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
			</a> <a href="#"> <i
					class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
			</a> <a href="#"> <i
					class="ace-icon fa fa-rss-square orange bigger-150"></i>
			</a>
			</span>
		</div>
	</div>
</div>

<a href="#" id="btn-scroll-up"
	class="btn-scroll-up btn btn-sm btn-inverse"> <i
	class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
</div>
<!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="${baseUrl}/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${baseUrl}/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${blueUrl}/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
<script src="${baseUrl}/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="${baseUrl}/js/bootstrap-datepicker.min.js"></script>
<script src="${baseUrl}/js/jquery.jqGrid.min.js"></script>
<script src="${baseUrl}/js/grid.locale-en.js"></script>

<!-- ace scripts -->
<script src="${baseUrl}/js/ace-elements.min.js"></script>
<script src="${baseUrl}/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
			var grid_data = 
			[ 
			 <%	
			     System.out.print("Size country.... :"+locality_size);
			    if(locality_size>0){
				for(int i=0; i < locality_size; i++){ 
				 out.print("{id:\""+locality_list.get(i).getId()+"\",name:\""+locality_list.get(i).getName()+"\"");
				 if(city_list.size()>0){
					 for(int j=0;j<city_size;j++){
						 out.print(",city:"+city_list.get(j).getName());
					 }
				 }
				 if(locality_list.get(i).getStatus()==true){
					 out.print(",stock:"+"\"Yes\"},");
				 }
				 else{
					 out.print(",stock:"+"\"No\"},");
				}
				}
			    }
				%>
				
			];
			
			
			jQuery(function($) {
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
				
				
				var parent_column = $(grid_selector).closest('[class*="col-"]');
				//resize to fit page size
				$(window).on('resize.jqGrid', function () {
					$(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
			    })
				
				//resize on sidebar collapse/expand
				$(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
					if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
						//setTimeout is for webkit only to give time for DOM changes and then redraw!!!
						setTimeout(function() {
							$(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
						}, 20);
					}
			    })
				
				//if your grid is inside another element, for example a tab pane, you should use its parent's width:
				/**
				$(window).on('resize.jqGrid', function () {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				})
				//and also set width when tab pane becomes visible
				$('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				  if($(e.target).attr('href') == '#mygrid') {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				  }
				})
				*/
				
				
			
			
			
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
			
					//subgrid options
				//	subGrid : true,
					//subGridModel: [{ name : ['No','Item Name','Qty'], width : [55,200,80] }],
					//datatype: "xml",
				//	subGridOptions : {
				//		plusicon : "ace-icon fa fa-plus center bigger-110 blue",
				//		minusicon  : "ace-icon fa fa-minus center bigger-110 blue",
					//	openicon : "ace-icon fa fa-chevron-right center orange"
					//}//,
					//for this example we are using local data
					
					
			
			
					data: grid_data,
					datatype: "local",
					height: 250,
					colNames:[' ','ID','city','Name','latitude','longitude', 'State'],
					colModel:[
						{name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
							formatter:'actions', 
							formatoptions:{ 
								keys:true,
								//delbutton: false,//disable delete button
								
								delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
								//editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
							}
						},
						{name:'id',index:'id', width:60, sorttype:"int", editable: true},
						{name:'city',index:'city', width:70,editable: true,edittype:"select",editoptions:{<%if(city_size>0)for(int i=0;i<city_size;i++){
							out.print("\""+city_list.get(i).getId()+"\":\""+city_list.get(i).getName()+"\";");
						};%>}},
						{name:'name',index:'name', width:70,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'latitude',index:'latitude', width:70,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'longitude',index:'longitude', width:70,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'stock',index:'stock', width:100, editable: true,edittype:"checkbox",editoptions: {value:"Yes:No"},unformat: aceSwitch},
					], 
			
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector,
					altRows: true,
					//toppager: true,
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			
					loadComplete : function() {
						
						var table = this;
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
					editurl: '${baseUrl}/webapi/general/locality/save',
					caption: "Locality ",
					//,autowidth: true,
			
			
					/**
					,
					grouping:true, 
					groupingView : { 
						 groupField : ['name'],
						 groupDataSorted : true,
						 plusicon : 'fa fa-chevron-down bigger-110',
						 minusicon : 'fa fa-chevron-up bigger-110'
					},
					caption: "Grouping"
					*/
			
				});
			//	window.location.href = "${baseUrl}/general/country.jsp";
				$(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
				
				
			
				//enable search/filter toolbar
				//jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
				//jQuery(grid_selector).filterToolbar({});
			
			
				//switch element when editing inline
				function aceSwitch( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=checkbox]')
							.addClass('ace ace-switch ace-switch-5')
							.after('<span class="lbl"></span>');
					}, 0);
				}
				//enable datepicker
				/*function pickDate( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
					}, 0);
				}*/
			
			
				//navButtons
				jQuery(grid_selector).jqGrid('navGrid',pager_selector,
					{ 	//navbar options
						edit: true,
						editicon : 'ace-icon fa fa-pencil blue',
						add: true,
						addicon : 'ace-icon fa fa-plus-circle purple',
						//del: true,
						//delicon : 'ace-icon fa fa-trash-o red',
						search: true,
						searchicon : 'ace-icon fa fa-search orange',
						refresh: true,
						refreshicon : 'ace-icon fa fa-refresh green',
						view: true,
						viewicon : 'ace-icon fa fa-search-plus grey',
					},
					{
						//edit record form
						//closeAfterEdit: true,
						//width: 700,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
						//	form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
						//	style_edit_form(form);
						}
					},
					{
						//new record form
						//width: 700,
						closeAfterAdd: true,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
							.wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
					},
					{
						//delete record form
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							if(form.data('styled')) return false;
							
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_delete_form(form);
							
							form.data('styled', true);
						},
						onClick : function(e) {
							//alert(1);
						}
					},
					{
						//search form
						recreateForm: true,
						afterShowSearch: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
							style_search_form(form);
						},
						afterRedraw: function(){
							style_search_filters($(this));
						}
						,
						multipleSearch: true,
						/**
						multipleGroup:true,
						showQuery: true
						*/
					},
					{
						//view record form
						recreateForm: true,
						beforeShowForm: function(e){
							var form = $(e[0]);
							
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						}
					}
				)
			
			
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					//form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
					
					form.find('input[name=stock]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
							   //don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
							  //.addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
			
							
					//update buttons classes
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
					buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')
					
					buttons = form.next().find('.navButton a');
					buttons.find('.ui-icon').hide();
					buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
					buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');		
				}
			
				function style_delete_form(form) {
				/*	var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
					buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')*/
				}
				
				function style_search_filters(form) {
					form.find('.delete-rule').val('X');
					form.find('.add-rule').addClass('btn btn-xs btn-primary');
					form.find('.add-group').addClass('btn btn-xs btn-success');
					form.find('.delete-group').addClass('btn btn-xs btn-danger');
				}
				function style_search_form(form) {
					var dialog = form.closest('.ui-jqdialog');
					var buttons = dialog.find('.EditTable')
					buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
					buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
					buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
				}
				
				function beforeDeleteCallback(e) {
					/*var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_delete_form(form);
					
					form.data('styled', true);*/
				}
				
				function beforeEditCallback(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			
			
			
				//it causes some flicker when reloading or navigating grid
				//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
				//or go back to default browser checkbox styles for the grid
				function styleCheckbox(table) {
				/**
					$(table).find('input:checkbox').addClass('ace')
					.wrap('<label />')
					.after('<span class="lbl align-top" />')
			
			
					$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
					.find('input.cbox[type=checkbox]').addClass('ace')
					.wrap('<label />').after('<span class="lbl align-top" />');
				*/
				}
				
			
				//unlike navButtons icons, action icons in rows seem to be hard-coded
				//you can change them like this in here if you want
				function updateActionIcons(table) {
					/*
					var replacement = 
					{
						'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue',
						'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red',
						'ui-icon-disk' : 'ace-icon fa fa-check green',
						'ui-icon-cancel' : 'ace-icon fa fa-times red'
					};
					$(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
					*/
				}
				
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
						'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
						'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
						'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
			
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
			
		
				//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			
				$(document).one('ajaxloadstart.page', function(e) {
					$.jgrid.gridDestroy(grid_selector);
					$('.ui-jqdialog').remove();
				});
			});
		</script>
</body>
</html>
