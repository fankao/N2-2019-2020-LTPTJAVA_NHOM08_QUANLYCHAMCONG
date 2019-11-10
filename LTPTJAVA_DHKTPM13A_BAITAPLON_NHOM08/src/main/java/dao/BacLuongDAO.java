package dao;

import java.util.List;

import entities.BacLuong;

public interface BacLuongDAO {

	public BacLuong layBacLuongTheoMa(String maBL);

	public List<BacLuong> layDanhSachBacLuong();
}
