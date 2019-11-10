package dao;

import java.util.List;

import org.bson.types.ObjectId;

import entities.NhanVien_BacLuong;

public interface NhanVien_BacLuongDAO {
	public NhanVien_BacLuong themChiTietLuong(NhanVien_BacLuong ct);

	public NhanVien_BacLuong suaChiTietLuong(NhanVien_BacLuong ct);

	public List<NhanVien_BacLuong> layChiTietBacLuong();
	public NhanVien_BacLuong layChiTietBacLuongTheoIdNV(ObjectId id);
}
