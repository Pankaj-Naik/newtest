//package org.bluepigeon.admin.dao;
//
//import java.util.List;
//
//import org.bluepigeon.admin.exception.ResponseMessage;
//import org.bluepigeon.admin.model.BuilderBuildingAmenetiesType;
//import org.bluepigeon.admin.util.HibernateUtil;
//import org.hibernate.Query;
//import org.hibernate.Session;
//
//public class BuilderBuildingAmenetiesTypeDAO {
//	public ResponseMessage save(BuilderBuildingAmenetiesType buildingAmeneties) {
//		ResponseMessage response = new ResponseMessage();
//		HibernateUtil hibernateUtil = new HibernateUtil();
//		if (buildingAmeneties.getName() == null || buildingAmeneties.getName().trim().length() == 0) {
//			response.setStatus(0);
//			response.setMessage("Please enter Building Ameneties Stages/sub stages name");
//		} else {
//			String hql = "from BuilderBuildingAmenetiesType where name = :name";
//			Session session = hibernateUtil.openSession();
//			Query query = session.createQuery(hql);
//			query.setParameter("name", buildingAmeneties.getName());
//			List<BuilderBuildingAmenetiesType> result = query.list();
//			session.close();
//			if (result.size() > 0) {
//				response.setStatus(0);
//				response.setMessage("Building Ameneties Stages/sub stages name already exists");
//			} else {
//				Session newsession = hibernateUtil.openSession();
//				newsession.beginTransaction();
//				newsession.save(buildingAmeneties);
//				newsession.getTransaction().commit();
//				newsession.close();
//				response.setStatus(1);
//				response.setMessage("Success");
//			}
//		}
//		return response;
//	}
//
//	public ResponseMessage update(BuilderBuildingAmenetiesType buildingAmeneties) {
//		ResponseMessage response = new ResponseMessage();
//		HibernateUtil hibernateUtil = new HibernateUtil();
//		String hql = "from BuilderBuildingAmenetiesType where name = :name and id != :id";
//		Session session = hibernateUtil.openSession();
//		Query query = session.createQuery(hql);
//		query.setParameter("name", buildingAmeneties.getName());
//		query.setParameter("id", buildingAmeneties.getId());
//		// System.out.println("Country status ::"+country.getStatus());
//		// query.setParameter("status", country.getStatus());
//		List<BuilderBuildingAmenetiesType> result = query.list();
//		session.close();
//		if (result.size() > 0) {
//			response.setStatus(0);
//			response.setMessage("Building Ameneties Stages/sub stages name already exists");
//		} else {
//			Session newsession = hibernateUtil.openSession();
//			newsession.beginTransaction();
//			newsession.update(buildingAmeneties);
//			newsession.getTransaction().commit();
//			newsession.close();
//			response.setStatus(1);
//			response.setMessage("Success");
//		}
//		return response;
//	}
//
//	public ResponseMessage delete(BuilderBuildingAmenetiesType buildingAmeneties) {
//		ResponseMessage response = new ResponseMessage();
//		HibernateUtil hibernateUtil = new HibernateUtil();
//		String hql = "delete from BuilderBuildingAmenetiesType where id = :id";
//		Session session = hibernateUtil.openSession();
//		session.beginTransaction();
//		Query query = session.createQuery(hql);
//		query.setParameter("id", buildingAmeneties.getId());
//		query.executeUpdate();
//		session.getTransaction().commit();
//		session.close();
//		response.setStatus(1);
//		response.setMessage("Success");
//
//		return response;
//	}
//
//	public List<BuilderBuildingAmenetiesType> getCountryList() {
//		String hql = "from BuilderBuildingAmenetiesType";
//		HibernateUtil hibernateUtil = new HibernateUtil();
//		Session session = hibernateUtil.openSession();
//		Query query = session.createQuery(hql);
//		List<BuilderBuildingAmenetiesType> result = query.list();
//		session.close();
//		return result;
//	}
//
//	public List<BuilderBuildingAmenetiesType> getCountryById(int id) {
//		String hql = "from BuilderBuildingAmenetiesStagesAndSubStages where id = :id";
//		HibernateUtil hibernateUtil = new HibernateUtil();
//		Session session = hibernateUtil.openSession();
//		Query query = session.createQuery(hql);
//		query.setParameter("id", id);
//		List<BuilderBuildingAmenetiesType> result = query.list();
//		session.close();
//		return result;
//	}
//
//}
