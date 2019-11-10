package dao;

import java.util.List;

import org.bson.types.ObjectId;

import entities.ChiTietChamCong;
import entities.NhanVien;

public interface ChiTietChamCongDAO {
	public ChiTietChamCong themChiTietChamCong(ChiTietChamCong ctcc);

	public ChiTietChamCong suaChiTietChamCong(ChiTietChamCong ctcc);

	public ChiTietChamCong layChiTietChamCong(ObjectId maNCC, ObjectId maNV);

	public boolean xoaChiTietChamCong(ObjectId maNV);

	public int tinhNgayDaChamCong(NhanVien nv);

	public List<ChiTietChamCong> layDanhSachChiTietChamCong();

	public List<ChiTietChamCong> layDanhSachChiTietChamCongTheoIdNV(ObjectId id);

}
