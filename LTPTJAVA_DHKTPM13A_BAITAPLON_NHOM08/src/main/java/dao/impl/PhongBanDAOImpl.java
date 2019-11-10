package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PhongBanDAO;
import entities.PhongBan;

public class PhongBanDAOImpl implements PhongBanDAO {
	private EntityManager em;

	public PhongBanDAOImpl() {
		// TODO Auto-generated constructor stub
		em = DBEntityManager.getInstance().getEntityManager();
	}

	@Override
	public PhongBan layTTPhongBanTheoMa(String ma) {
		// TODO Auto-generated method stub
		return em.find(PhongBan.class, ma);

	}

	@Override
	public List<PhongBan> laydsPhongBan() {
		String mql = "{}";
		Query query = em.createNativeQuery(mql, PhongBan.class);
		List<PhongBan> pbs = query.getResultList();

		return pbs;
	}

}
