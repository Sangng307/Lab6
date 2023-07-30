package edu.poly.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
	
	public static EntityManager getEntityManager() {
		 return Persistence.createEntityManagerFactory("Lab6").createEntityManager();
	}
}
