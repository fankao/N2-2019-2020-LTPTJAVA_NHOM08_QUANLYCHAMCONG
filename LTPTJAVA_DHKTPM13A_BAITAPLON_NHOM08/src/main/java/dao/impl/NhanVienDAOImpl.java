package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.NhanVienDAO;
import entities.NhanVien;
import entities.TaiKhoan;

public class NhanVienDAOImpl implements NhanVienDAO {
	private EntityManager em;

	public NhanVienDAOImpl() {
		em = DBEntityManager.getInstance().getEntityManager();
	}

	public NhanVien themNhanVien(NhanVien nv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(nv);
			tr.commit();
			return nv;
		} catch (Exception e) {
			// e.printStackTrace();
			tr.rollback();
			return null;
		}

	}

	public NhanVien suaNhanVien(NhanVien nv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(nv);
			tr.commit();
			return nv;
		} catch (Exception e) {
			// e.printStackTrace();
			tr.rollback();
			return null;
		}

	}

	public NhanVien xoaNhanVien(NhanVien nv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(NhanVien.class, nv.getId()));
			tr.commit();
			return nv;
		} catch (Exception e) {
			tr.rollback();
			return null;
		}

	}

	public NhanVien layNhanVienTheoMa(String maNV) {
		String mql = "{'maNV':'manv'}";
		mql = mql.replace("manv", maNV);
		Query query = em.createNativeQuery(mql, NhanVien.class);
		List<NhanVien> list = query.getResultList();
		return list.size() != 0 ? list.get(0) : null;
	}

	public NhanVien layNhanVienTheoTaiKhoan(TaiKhoan taiKhoan) {
		String mql = "{'taiKhoan.tenDangNhap':'dn','taiKhoan.matKhau':'mk'}";
		mql = mql.replace("dn", taiKhoan.getTenDangNhap());
		mql = mql.replace("mk", taiKhoan.getMatKhau());
		Query query = em.createNativeQuery(mql, NhanVien.class);
		List<NhanVien> list = query.getResultList();
		return list.size() != 0 ? list.get(0) : null;

	}

	public List<NhanVien> layDanhSachNhanVien() {
		String mql = "{}";
		Query query = em.createNativeQuery(mql, NhanVien.class);
		List<NhanVien> list = query.getResultList();
		return list.size() != 0 ? list : null;
	}

	@Override
	public List<NhanVien> layDanhSachNhanVienTheoPhongBan(String maPB) {
		String mql = "{'phongban':'maPB'}";
		mql = mql.replace("maPB", maPB);
		Query query = em.createNativeQuery(mql, NhanVien.class);
		List<NhanVien> list = query.getResultList();
		return list.size() != 0 ? list : null;
	}

}