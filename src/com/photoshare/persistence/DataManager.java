package com.photoshare.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.photoshare.auth.user.User;

public class DataManager {
	private static EntityManager entityManager;

	private static final class DateManagerHolder {
		public static final DataManager MANAGER = new DataManager();
	}

	public void init() {
		entityManager = Persistence.createEntityManagerFactory("")
				.createEntityManager();
	}

	public static boolean authenticate(User user) {
		// Query query = entityManager
		// .createQuery("select * from TUser where username = ? and userpassword = ?");
		// query.setParameter(0, user.getUserName());
		// query.setParameter(1, user.getCredential().getPassword());
		// @SuppressWarnings("unchecked")
		// List<TUser> queryUser = query.getResultList();
		// if (queryUser.isEmpty())
		// return false;
		// return true;

		if (user.getUserName().equals("user")) {
			return true;
		}
		return false;

	}

}
