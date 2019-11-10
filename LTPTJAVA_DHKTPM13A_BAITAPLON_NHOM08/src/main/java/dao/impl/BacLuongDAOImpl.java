package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.BacLuongDAO;
import entities.BacLuong;

public class BacLuongDAOImpl implements BacLuongDAO {
	private EntityManager em;

	public BacLuongDAOImpl() {
		// TODO Auto-generated constructor stub
		em = DBEntityManager.getInstance().getEntityManager();
	}

	@Override
	public BacLuong layBacLuongTheoMa(String maBL) {
		// TODO Auto-generated method stub
		return em.find(BacLuong.class, maBL);
	}

	@Override
	public List<BacLuong> layDanhSachBacLuong() {
		String mql = "{}";
		Query query = em.createNativeQuery(mql,BacLuong.class);
		List<BacLuong> bacLuongs = query.getResultList();
		return bacLuongs;
	}

}
