package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBEntityManager {
	private static DBEntityManager instance = null;
	private EntityManager em;

	public DBEntityManager() {
		em = Persistence.createEntityManagerFactory("LTPTJAVA_DHKTPM13A_BAITAPLON_NHOM08").createEntityManager();
	}

	public static DBEntityManager getInstance() {
		if (instance == null) {
			instance = new DBEntityManager();
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return em;
	}
}
