package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.both_key_return;

import entities.NhanVien;
import entities.TaiKhoan;

public interface NhanVienControl extends Remote {
	public NhanVien themNhanVien(NhanVien nv) throws RemoteException;

	public NhanVien suaNhanVien(NhanVien nv) throws RemoteException;

	public NhanVien xoaNhanVien(NhanVien nv) throws RemoteException;

	public NhanVien layNhanVienTheoMa(String maNV) throws RemoteException;

	public NhanVien layNhanVienTheoTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;

	public List<NhanVien> layDanhSachNhanVien() throws RemoteException;

	public String phatSinhMaNhanVien() throws RemoteException;

	public List<NhanVien> layDanhSachNhanVienTheoPhongBan(String maPB) throws RemoteException;

}
