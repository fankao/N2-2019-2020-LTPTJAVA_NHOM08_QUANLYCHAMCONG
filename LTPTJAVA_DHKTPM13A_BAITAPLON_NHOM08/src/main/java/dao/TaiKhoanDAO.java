package dao;

import entities.TaiKhoan;

public interface TaiKhoanDAO {
	public TaiKhoan themTaiKhoan(TaiKhoan taiKhoan);

	public TaiKhoan suaTaiKhoan(TaiKhoan taiKhoan);

	public TaiKhoan xoaTaiKhoan(TaiKhoan taiKhoan);

	public TaiKhoan layTaiKhoan(String tenDangNhap, String matKhau);
}
