package edu.poly.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.poly.model.Report;
//import edu.poly.model.Report;
import edu.poly.model.User;
import edu.poly.model.Video;
import edu.poly.utils.JpaUtils;

public class Videodao {

	public List<Video> findVideoFavoriteByUserID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "Select f.video from Favorite f where f.user.id = :username";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter("username", id);
		return query.getResultList();
	}

	public List<Video> findVideoFavoriteByKeyword(String keyword) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT DISTINCT o.video FROM Favorite o WHERE o.video.title like :keyword";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter("keyword", "%" + keyword + "%");
		return query.getResultList();
	}

	public List<User> findUserFavoriteByVideoID(String videoid) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT o.user from Favorite o WHERE o.video.id = :videoid";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("videoid", videoid);
		return query.getResultList();
	}

	public List<Video> findVideoEmpty(Boolean favorite) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
		if (favorite) {
			jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
		}
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		return query.getResultList();
	}

	public List<Report> countLikeVideo() {
		String jpql = "SELECT new Report(f.video.title, count(f), max(f.likeDate), min(f.likeDate)) FROM Favorite f GROUP BY f.video.title";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		return query.getResultList();
	}

	public List<Video> findInRange(String min, String max) throws ParseException {
		EntityManager em = JpaUtils.getEntityManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(min);
		Date d2 = sdf.parse(max);
		TypedQuery<Video> query = em.createNamedQuery("Video.findInRange", Video.class);
		query.setParameter("min", d1);
		query.setParameter("max", d2);
		return query.getResultList();
	}
	public List<Video> findInMonths(List<Integer> months) throws ParseException {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findByMonth", Video.class);
		query.setParameter("months", months);
		return query.getResultList();
	}
	
	
	public List<Video> random10Video() {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Report.random10", Video.class);
		return query.getResultList();
	}
	
	public List<Video> findByKeyWord(String keyword) {
		EntityManager em = JpaUtils.getEntityManager();
		
		TypedQuery<Video> query = em.createNamedQuery("Video.findByKeyword", Video.class);
		query.setParameter("keyword","%" + keyword + "%");
		return query.getResultList();
	}
	
	public List<Video> findVideoFavoriteByUserIDNamed(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findByUser", Video.class);
		query.setParameter("username", id);
		return query.getResultList();
	}

//	public List<Report> favoriteByYear(int year) {
//		EntityManager em = JpaUtils.getEntityManager();
//		StoredProcedureQuery query = em.createStoredProcedureQuery("Report.FavoriteByYear");
//		query.setParameter("year", year);
//		return query.getResultList();
//	}
}
