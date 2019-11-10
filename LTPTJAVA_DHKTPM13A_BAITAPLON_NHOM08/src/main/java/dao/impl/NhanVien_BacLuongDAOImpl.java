package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.bson.types.ObjectId;

import dao.NhanVien_BacLuongDAO;
import entities.NhanVien_BacLuong;

public class NhanVien_BacLuongDAOImpl implements NhanVien_BacLuongDAO {
	private EntityManager em;

	public NhanVien_BacLuongDAOImpl() {
		em = DBEntityManager.getInstance().getEntityManager();
	}

	@Override
	public NhanVien_BacLuong themChiTietLuong(NhanVien_BacLuong ct) {

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ct);
			tr.commit();
			return ct;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public NhanVien_BacLuong suaChiTietLuong(NhanVien_BacLuong ct) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ct);
			tr.commit();
			return ct;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<NhanVien_BacLuong> layChiTietBacLuong() {
		String mql = "{}";
		Query query = em.createNativeQuery(mql, NhanVien_BacLuong.class);
		List<NhanVien_BacLuong> list = query.getResultList();
		return list.size() == 0 ? null : list;
	}

	@Override
	public NhanVien_BacLuong layChiTietBacLuongTheoIdNV(ObjectId maNV) {
		String mql = "{'_id.maNV':ObjectId('" + maNV + "')}";
		try {
			Query query = em.createNativeQuery(mql, NhanVien_BacLuong.class);
			List<NhanVien_BacLuong> list = query.getResultList();
			NhanVien_BacLuong nvbl = list.size() == 0 ? null : list.get(list.size() - 1);
			return nvbl;
		} catch (Exception e) {
			return null;
		}

	}

}
