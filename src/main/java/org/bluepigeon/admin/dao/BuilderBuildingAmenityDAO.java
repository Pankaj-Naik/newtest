package org.bluepigeon.admin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.bluepigeon.admin.exception.ResponseMessage;
import org.bluepigeon.admin.model.BuilderBuildingAmenity;
import org.bluepigeon.admin.util.HibernateUtil;

public class BuilderBuildingAmenityDAO {

	public ResponseMessage save(BuilderBuildingAmenity builderBuildingAmenity) {
		ResponseMessage response = new ResponseMessage();
		HibernateUtil hibernateUtil = new HibernateUtil();
		if (builderBuildingAmenity.getName() == null || builderBuildingAmenity.getName().trim().length() == 0) {
			response.setStatus(0);
			response.setMessage("Please enter building amenity name");
		} else {
			String hql = "from BuilderBuildingAmenity where name = :name";
			Session session = hibernateUtil.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("name", builderBuildingAmenity.getName());
			List<BuilderBuildingAmenity> result = query.list();
			session.close();
			if (result.size() > 0) {
				response.setStatus(0);
				response.setMessage("Building amenity name already exists");
			} else {
				Session newsession = hibernateUtil.openSession();
				newsession.beginTransaction();
				newsession.save(builderBuildingAmenity);
				newsession.getTransaction().commit();
				newsession.close();
				response.setStatus(1);
				response.setMessage("Success");
			}
		}
		return response;
	}

	public ResponseMessage update(BuilderBuildingAmenity builderBuildingAmenity) {
		ResponseMessage response = new ResponseMessage();
		HibernateUtil hibernateUtil = new HibernateUtil();
		String hql = "from BuilderBuildingAmenity where name = :name and id != :id";
		Session session = hibernateUtil.openSession();
		Query query = session.createQuery(hql);
		query.setParameter("name", builderBuildingAmenity.getName());
		query.setParameter("id", builderBuildingAmenity.getId());
		// System.out.println("Country status ::"+country.getStatus());
		// query.setParameter("status", country.getStatus());
		System.out.println("id :: "+builderBuildingAmenity.getId()+" Name :: "+builderBuildingAmenity.getName());
		List<BuilderBuildingAmenity> result = query.list();
		session.close();
		if (result.size() > 0) {
			response.setStatus(0);
			response.setMessage("Building amenity name already exists");
		} else {
			Session newsession = hibernateUtil.openSession();
			newsession.beginTransaction();
			newsession.update(builderBuildingAmenity);
			newsession.getTransaction().commit();
			newsession.close();
			response.setStatus(1);
			response.setMessage("Success");
		}
		return response;
	}

	public ResponseMessage delete(BuilderBuildingAmenity builderBuildingAmenity) {
		ResponseMessage response = new ResponseMessage();
		HibernateUtil hibernateUtil = new org.bluepigeon.admin.util.HibernateUtil();
		String hql = "delete from BuilderBuildingAmenity where id = :id";
		Session session = hibernateUtil.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("id", builderBuildingAmenity.getId());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		response.setStatus(1);
		response.setMessage("Success");

		return response;
	}

	public List<BuilderBuildingAmenity> getBuilderBuildingAmenityList() {
		String hql = "from BuilderBuildingAmenity";
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.openSession();
		Query query = session.createQuery(hql);
		List<BuilderBuildingAmenity> result = query.list();
		// System.out.println("Result : "+result.size());
		for (int i = 0; i < result.size(); i++) {
			BuilderBuildingAmenity builderBuildingAmenity = result.get(i);
			System.out.println(builderBuildingAmenity.getName());
		}
		session.close();
		return result;
	}

	public List<BuilderBuildingAmenity> getBuilderBuildingAmenityById(int id) {
		String hql = "from BuilderBuildingAmenity where id = :id";
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.openSession();
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<BuilderBuildingAmenity> result = query.list();
		session.close();
		return result;
	}

}
