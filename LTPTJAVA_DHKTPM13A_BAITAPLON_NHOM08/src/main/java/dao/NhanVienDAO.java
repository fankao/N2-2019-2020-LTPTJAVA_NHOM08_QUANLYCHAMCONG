package dao;

import java.util.List;

import entities.NhanVien;
import entities.TaiKhoan;

public interface NhanVienDAO {
	public NhanVien themNhanVien(NhanVien nv);

	public NhanVien suaNhanVien(NhanVien nv);

	public NhanVien xoaNhanVien(NhanVien nv);

	public NhanVien layNhanVienTheoMa(String maNV);

	public NhanVien layNhanVienTheoTaiKhoan(TaiKhoan taiKhoan);

	public List<NhanVien> layDanhSachNhanVien();

	public List<NhanVien> layDanhSachNhanVienTheoPhongBan(String maPB);
}
