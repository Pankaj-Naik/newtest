<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.bluepigeon.admin.dao.CountryDAOImp"%>
<%@page import="org.bluepigeon.admin.model.Country"%>
<%@page import="java.util.List"%>
<%@include file="../head.jsp"%>
<%@include file="../leftnav.jsp"%>
<%
	CountryDAOImp countryService = new CountryDAOImp();
	List<Country> listCountry = countryService.getCountryList();
	System.out.print("size : " + listCountry.size());
%>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs ace-save-state" id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>

				<li><a href="#">Tables</a></li>
				<li class="active">Country</li>
			</ul>
		</div>
		<div class="page-content">
			<div class="page-header">
				<h1>
					Country 
				</h1>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="grid-table"></table>
					<div id="grid-pager"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>
<script src="${baseUrl}/js/jquery.jqGrid.min.js"></script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
	var grid_data = [
<%int country_size = listCountry.size();
			if (country_size > 0) {
				for (int i = 0; i < country_size; i++) {
					out.print("{id:\"" + listCountry.get(i).getId() + "\",name:\"" + listCountry.get(i).getName() + "\"");
					if (listCountry.get(i).getStatus() == 1) {
						out.print(",stock:" + "\"Yes\"},");
					} else {
						out.print(",stock:" + "\"No\"},");
					}
				}
			}%>
	];

	jQuery(function($) {
		var grid_selector = "#grid-table";
		var pager_selector = "#grid-pager";

		var parent_column = $(grid_selector).closest('[class*="col-"]');
		$(window).on('resize.jqGrid', function() {
			$(grid_selector).jqGrid('setGridWidth', parent_column.width());
		})
		$(document).on(
				'settings.ace.jqGrid',
				function(ev, event_name, collapsed) {
					if (event_name === 'sidebar_collapsed'
							|| event_name === 'main_container_fixed') {
						//setTimeout is for webkit only to give time for DOM changes and then redraw!!!
						setTimeout(function() {
							$(grid_selector).jqGrid('setGridWidth',
									parent_column.width());
						}, 20);
					}
				})

		jQuery(grid_selector).jqGrid({
			data : grid_data,
			datatype : "local",
			height : 250,
			colNames : [ ' ', 'ID', 'Name', 'Is Active' ],
			colModel : [ {
				name : 'myac',
				index : '',
				width : 80,
				fixed : true,
				sortable : false,
				resize : false,
				formatter : 'actions',
				formatoptions : {
					keys : true,
					delOptions : {
						recreateForm : true,
						beforeShowForm : beforeDeleteCallback
					},
				}
			}, {
				name : 'id',
				index : 'id',
				width : 60,
				sorttype : "int",
				editable : true
			}, {
				name : 'name',
				index : 'name',
				width : 150,
				editable : true,
				editoptions : {
					size : "20",
					maxlength : "30"
				}
			}, {
				name : 'stock',
				index : 'stock',
				width : 70,
				editable : true,
				edittype : "checkbox",
				editoptions : {
					value : "Yes:No"
				},
				unformat : aceSwitch
			}, ],

			viewrecords : true,
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			pager : pager_selector,
			altRows : true,
			//toppager: true,

			multiselect : true,
			//multikey: "ctrlKey",
			multiboxonly : true,

			loadComplete : function() {

				var table = this;
				setTimeout(function() {
					styleCheckbox(table);

					updateActionIcons(table);
					updatePagerIcons(table);
					enableTooltips(table);
				}, 0);
			},
			editurl : '${baseUrl}/webapi/general/country/save',
			caption : "Country with inline editing",
		});
		
		$(window).triggerHandler('resize.jqGrid');
		function aceSwitch(cellvalue, options, cell) {
			setTimeout(function() {
				$(cell).find('input[type=checkbox]').addClass(
						'ace ace-switch ace-switch-5').after(
						'<span class="lbl"></span>');
			}, 0);
		}
		jQuery(grid_selector).jqGrid(
				'navGrid',
				pager_selector,
				{ //navbar options
					edit : true,
					editicon : 'ace-icon fa fa-pencil blue',
					add : true,
					addicon : 'ace-icon fa fa-plus-circle purple',
					search : true,
					searchicon : 'ace-icon fa fa-search orange',
					refresh : true,
					refreshicon : 'ace-icon fa fa-refresh green',
					view : true,
					viewicon : 'ace-icon fa fa-search-plus grey',
				},
				{
					recreateForm : true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find(
								'.ui-jqdialog-titlebar').wrapInner(
								'<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					closeAfterAdd : true,
					recreateForm : true,
					viewPagerButtons : false,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find(
								'.ui-jqdialog-titlebar').wrapInner(
								'<div class="widget-header" />')
						style_edit_form(form);
					}
				},
				{
					//delete record form
					recreateForm : true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						if (form.data('styled'))
							return false;

						form.closest('.ui-jqdialog').find(
								'.ui-jqdialog-titlebar').wrapInner(
								'<div class="widget-header" />')
						style_delete_form(form);

						form.data('styled', true);
					},
					onClick : function(e) {
						//alert(1);
					}
				},
				{
					//search form
					recreateForm : true,
					afterShowSearch : function(e) {
						var form = $(e[0]);
						form.closest('.ui-jqdialog').find('.ui-jqdialog-title')
								.wrap('<div class="widget-header" />')
						style_search_form(form);
					},
					afterRedraw : function() {
						style_search_filters($(this));
					},
					multipleSearch : true,
				},
				{
					recreateForm : true,
					beforeShowForm : function(e) {
						var form = $(e[0]);

						form.closest('.ui-jqdialog').find('.ui-jqdialog-title')
								.wrap('<div class="widget-header" />')
					}
				})

		function style_edit_form(form) {
			form.find('input[name=stock]').addClass(
					'ace ace-switch ace-switch-5').after(
					'<span class="lbl"></span>');
			var buttons = form.next().find('.EditButton .fm-button');
			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();//ui-icon, s-icon
			buttons.eq(0).addClass('btn-primary').prepend(
					'<i class="ace-icon fa fa-check"></i>');
			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

			buttons = form.next().find('.navButton a');
			buttons.find('.ui-icon').hide();
			buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
			buttons.eq(1)
					.append('<i class="ace-icon fa fa-chevron-right"></i>');
		}

		function style_delete_form(form) {
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
			buttons.find('.EditButton a[id*="_reset"]').addClass(
					'btn btn-sm btn-info').find('.ui-icon').attr('class',
					'ace-icon fa fa-retweet');
			buttons.find('.EditButton a[id*="_query"]').addClass(
					'btn btn-sm btn-inverse').find('.ui-icon').attr('class',
					'ace-icon fa fa-comment-o');
			buttons.find('.EditButton a[id*="_search"]').addClass(
					'btn btn-sm btn-purple').find('.ui-icon').attr('class',
					'ace-icon fa fa-search');
		}

		function beforeDeleteCallback(e) {
		}

		function beforeEditCallback(e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
					.wrapInner('<div class="widget-header" />')
			style_edit_form(form);
		}

		function styleCheckbox(table) {
		}

		function updateActionIcons(table) {
		}

		function updatePagerIcons(table) {
			var replacement = {
				'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
				'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
				'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
				'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
			};
			$(
					'.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
					.each(
							function() {
								var icon = $(this);
								var $class = $.trim(icon.attr('class').replace(
										'ui-icon', ''));

								if ($class in replacement)
									icon.attr('class', 'ui-icon '
											+ replacement[$class]);
							})
		}

		function enableTooltips(table) {
			$('.navtable .ui-pg-button').tooltip({
				container : 'body'
			});
			$(table).find('.ui-pg-div').tooltip({
				container : 'body'
			});
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
