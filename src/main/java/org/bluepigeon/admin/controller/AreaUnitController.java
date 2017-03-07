package org.bluepigeon.admin.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bluepigeon.admin.model.AreaUnit;
import org.bluepigeon.admin.service.AreaUnitService;

@Path("/areaunit")
public class AreaUnitController {
	
	@GET
	@Path("/selectunit")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AreaUnit> getAreaUnit()
	{
		AreaUnitService araeUnitService = new AreaUnitService();
		return araeUnitService.getAreaUnit();
	}
	

}
