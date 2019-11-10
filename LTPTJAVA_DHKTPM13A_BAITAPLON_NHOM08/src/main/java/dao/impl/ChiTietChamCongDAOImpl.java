package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.bson.types.ObjectId;
import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;

import dao.ChiTietChamCongDAO;
import entities.ChiTietChamCong;
import entities.ChiTietChamCongPK;
import entities.NgayChamCong;
import entities.NhanVien;

public class ChiTietChamCongDAOImpl implements ChiTietChamCongDAO {
	private EntityManager em;

	public ChiTietChamCongDAOImpl() {
		em = DBEntityManager.getInstance().getEntityManager();
	}

	@Override
	public ChiTietChamCong themChiTietChamCong(ChiTietChamCong ctcc) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ctcc);
			tr.commit();
			return ctcc;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();

		}
		return null;
	}

	@Override
	public ChiTietChamCong suaChiTietChamCong(ChiTietChamCong ctcc) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ctcc);
			tr.commit();
			return ctcc;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();

		}
		return null;
	}

	@Override
	public int tinhNgayDaChamCong(NhanVien nv) {

		return 0;
	}

	@Override
	public List<ChiTietChamCong> layDanhSachChiTietChamCongTheoIdNV(ObjectId id) {
		String mql = "{'_id.nhanvien':ObjectId('" + id + "')}";
		Query query = em.createNativeQuery(mql, ChiTietChamCong.class);
		List<ChiTietChamCong> chamCongs = query.getResultList();
		return chamCongs.size() == 0 ? null : chamCongs;

	}

	@Override
	public ChiTietChamCong layChiTietChamCong(ObjectId maNCC, ObjectId maNV) {
		return em.find(ChiTietChamCong.class, new ChiTietChamCongPK(maNCC, maNV));
	}

	@Override
	public List<ChiTietChamCong> layDanhSachChiTietChamCong() {
		String mql = "{}";
		Query query = em.createNativeQuery(mql, ChiTietChamCong.class);
		List<ChiTietChamCong> chamCongs = query.getResultList();
		return chamCongs.size() == 0 ? null : chamCongs;
	}

	@Override
	public boolean xoaChiTietChamCong(ObjectId maNV) {
		String mql2 = "db.chitietchamcong.deleteMany({'_id.nhanvien':ObjectId('" + maNV + "')})";
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			Query query2 = em.createNativeQuery(mql2, ChiTietChamCong.class);
			query2.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();

		}
		return false;
	}

}
