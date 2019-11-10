package control.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import control.NhanVienControl;
import dao.NhanVienDAO;
import dao.impl.NhanVienDAOImpl;
import entities.NhanVien;
import entities.TaiKhoan;

public class NhanVienControlImpl extends UnicastRemoteObject implements NhanVienControl {

	private static final long serialVersionUID = 1L;
	private NhanVienDAO nhanVienDAO;

	public NhanVienControlImpl() throws RemoteException {
		nhanVienDAO = new NhanVienDAOImpl();
	}

	@Override
	public NhanVien themNhanVien(NhanVien nv) throws RemoteException {
		return nhanVienDAO.themNhanVien(nv);
	}

	@Override
	public NhanVien suaNhanVien(NhanVien nv) throws RemoteException {

		return nhanVienDAO.suaNhanVien(nv);
	}

	@Override
	public NhanVien xoaNhanVien(NhanVien nv) throws RemoteException {

		return nhanVienDAO.xoaNhanVien(nv);
	}

	@Override
	public NhanVien layNhanVienTheoMa(String maNV) throws RemoteException {
		return nhanVienDAO.layNhanVienTheoMa(maNV) == null ? null : nhanVienDAO.layNhanVienTheoMa(maNV);
	}

	@Override
	public NhanVien layNhanVienTheoTaiKhoan(TaiKhoan taiKhoan) throws RemoteException {

		return nhanVienDAO.layNhanVienTheoTaiKhoan(taiKhoan);
	}

	@Override
	public List<NhanVien> layDanhSachNhanVien() throws RemoteException {
		return nhanVienDAO.layDanhSachNhanVien();
	}

	@Override
	public List<NhanVien> layDanhSachNhanVienTheoPhongBan(String maPB) throws RemoteException {

		return nhanVienDAO.layDanhSachNhanVienTheoPhongBan(maPB);
	}

	@Override
	public String phatSinhMaNhanVien() throws RemoteException {
		List<NhanVien> list = layDanhSachNhanVien();
		if (list.size() != 0) {
			NhanVien nhanVien = list.get(list.size() - 1);
			String layChiSo = nhanVien.getMaNV().substring(4);
			int index = Integer.parseInt(layChiSo) + 1;
			return "NV00" + index;
		}
		return "NV001";

	}
}
