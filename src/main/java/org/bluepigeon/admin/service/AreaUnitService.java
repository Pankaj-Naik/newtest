package org.bluepigeon.admin.service;

import java.util.List;

import org.bluepigeon.admin.dao.AreaUnitDAOImpl;
import org.bluepigeon.admin.model.AreaUnit;

public class AreaUnitService {

	public List<AreaUnit> getAreaUnit()
	{
		AreaUnitDAOImpl areaUnitDAOImpl = new AreaUnitDAOImpl();
		return areaUnitDAOImpl.getAreaUnit();
	}
}
