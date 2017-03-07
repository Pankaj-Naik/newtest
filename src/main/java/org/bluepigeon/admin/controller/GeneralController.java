package org.bluepigeon.admin.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bluepigeon.admin.dao.CityNamesImp;
import org.bluepigeon.admin.dao.CountryDAOImp;
import org.bluepigeon.admin.dao.LocalityNamesImp;
import org.bluepigeon.admin.dao.StateImp;
import org.bluepigeon.admin.data.CityData;
import org.bluepigeon.admin.data.LocalityData;
import org.bluepigeon.admin.data.StateData;
import org.bluepigeon.admin.exception.ResponseMessage;
import org.bluepigeon.admin.model.City;
import org.bluepigeon.admin.model.Country;
import org.bluepigeon.admin.model.Locality;
import org.bluepigeon.admin.model.State;
import org.bluepigeon.admin.service.CityNamesService;

@Path("general")
public class GeneralController {

	@POST
	@Path("/country/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage save(@FormParam("name") String name, @FormParam("stock") String sstatus,
			@FormParam("sortOrder") int sortOrder) {

		byte status=0;
		  if(sstatus.equals("Yes"))
      	status=1;
		Country country = new Country();
		country.setName(name);
		country.setStatus(status);
		country.setSortOrder(sortOrder);
		CountryDAOImp countryService = new CountryDAOImp();
		return countryService.save(country);
	}
	

	@POST
	@Path("/country/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateCountry(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("sortOrder") int sortOrder, @FormParam("stock") String sstatus) {
		
		System.out.println("String status : "+sstatus);
		byte status=0;
		  if(sstatus.equals("Yes"))
        	status=1;
		Country country = new Country();
		country.setId(id);
		country.setName(name);
		country.setSortOrder(sortOrder);
		country.setStatus(status);
		
		System.out.println(" update Status :: "+country.getStatus());
		CountryDAOImp countryService = new CountryDAOImp();
		return countryService.update(country);
	}
	
	@DELETE
	@Path("/country/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteCountry(@FormParam("id") int id) {
		
		Country country = new Country();
		country.setId(id);
		
		CountryDAOImp countryService = new CountryDAOImp();
		return countryService.delete(country);
	}

	@POST
	@Path("/state/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addState(@FormParam("name") String name, @FormParam("country_id") int countryId,
			@FormParam("status") byte status, @FormParam("sortOrder") int sortOrder) {
		
		Country country = new Country();
		country.setId(countryId);
		State state = new State();
		state.setName(name);
		state.setCountry(country);
		state.setSortOrder(sortOrder);
		state.setStatus(status);
		StateImp stateImp = new StateImp();
		return stateImp.save(state);
	}

	@POST
	@Path("/state/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateState(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("countryId") int countryId, @FormParam("sortOrder") int sortOrder,
			@FormParam("status") byte status) {
		Country country = new Country();
		country.setId(countryId);
		State state = new State();
		state.setId(id);
		state.setName(name);
		state.setCountry(country);
		state.setSortOrder(sortOrder);
		state.setStatus(status);
		StateImp stateImp = new StateImp();
		return stateImp.update(state);
	}
	
	@GET
	@Path("/state/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<State> addState(@QueryParam("country_id") int country_id) {
		StateImp stateImp = new StateImp();
		return stateImp.getStateByCountryId(country_id);
	}

	@POST
	@Path("/city/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addCity(@FormParam("name") String name, @FormParam("state_id") int stateId,@FormParam("status") byte status) {
		State state = new State();
		state.setId(stateId);
		City city = new City();
		city.setName(name);
		city.setState(state);
		city.setStatus(status);
		CityNamesService cityNamesService = new CityNamesService();
		return cityNamesService.addCity(city);
	}

	@POST
	@Path("/city/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateCity(@FormParam("id") int id, @FormParam("name") String name, @FormParam("state_id") int stateId,
			@FormParam("status") byte status) {
		State state = new State();
		state.setId(stateId);
		City city = new City();
		city.setId(id);
		city.setName(name);
		city.setState(state);
		city.setStatus(status);
		CityNamesService cityNamesService = new CityNamesService();
		return cityNamesService.updateCity(city);
	}

	@POST
	@Path("/locality/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addLocality(@FormParam("name") String name, @FormParam("cityId") int cityId,
			@FormParam("sortOrder") byte sortOrder, @FormParam("status") boolean status,
			@FormParam("latitude") String latitude, @FormParam("longitude") String longitude) {
		City city = new City();
		city.setId(cityId);
		Locality locality = new Locality();
		locality.setName(name);
		locality.setCity(city);
		locality.setSortOrder(sortOrder);
		locality.setStatus(status);
		locality.setLongitude(longitude);
		locality.setLatitude(latitude);
		LocalityNamesImp localityNamesImp = new LocalityNamesImp();
		return localityNamesImp.save(locality);
	}

	@POST
	@Path("/locality/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateLocality(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("cityId") int cityId, @FormParam("sortOrder") byte sortOrder,
			@FormParam("status") boolean status, @FormParam("latitude") String latitude,
			@FormParam("longitude") String longitude) {
		City city = new City();
		city.setId(cityId);
		Locality locality = new Locality();
		locality.setId(id);
		locality.setName(name);
		locality.setCity(city);
		locality.setSortOrder(sortOrder);
		locality.setStatus(status);
		locality.setLongitude(longitude);
		locality.setLatitude(latitude);
		LocalityNamesImp localityNamesImp = new LocalityNamesImp();
		return localityNamesImp.update(locality);
	}

	@GET
	@Path("/cities")
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> getAllCity() {
		CityNamesService cityNamesService = new CityNamesService();
		return cityNamesService.getAllCityNames();
	}

	@GET
	@Path("/city/{state_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CityData> getCityByState(@PathParam("state_id") int state_id) {

		return new CityNamesImp().getCityByStateId(state_id);
	}

	@GET
	@Path("/state/{country_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StateData> getStateByCountry(@PathParam("country_id") int country_id) {

		return new StateImp().getStateByCountry(country_id);
	}
	
	
	@GET
	@Path("/locality/{city_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LocalityData> getLocalityByCity(@PathParam("city_id") int city_id) {
		return new LocalityNamesImp().getLocalityName(city_id);
	}
}
