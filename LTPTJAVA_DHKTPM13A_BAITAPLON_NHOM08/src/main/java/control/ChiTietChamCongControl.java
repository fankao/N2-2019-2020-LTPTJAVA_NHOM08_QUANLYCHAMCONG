package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;

import entities.ChiTietChamCong;
import entities.NhanVien;

public interface ChiTietChamCongControl extends Remote {
	public ChiTietChamCong themChiTietChamCong(ChiTietChamCong ctcc) throws RemoteException;

	public ChiTietChamCong suaChiTietChamCong(ChiTietChamCong ctcc) throws RemoteException;

	public boolean xoaChiTietChamCong(ObjectId maNV) throws RemoteException;

	public int tinhNgayDaChamCongTheoThang(NhanVien nv, int thang) throws RemoteException;

	public int tinhNgayNghiTheoThang(NhanVien nv, int thang) throws RemoteException;

	public List<ChiTietChamCong> layDanhSachChiTietChamCongTheoIdNV(ObjectId id) throws RemoteException;

	public List<ChiTietChamCong> layDSCTNhanVienChamTheoThang(ObjectId id, int thang) throws RemoteException;

	public List<ChiTietChamCong> layDSCTNhanVienChamTheoNgay(String maPB, LocalDate date) throws RemoteException;

}
