package dao;

import java.util.List;

import entities.PhongBan;

public interface PhongBanDAO {
	public PhongBan layTTPhongBanTheoMa(String ma) ;
	public List<PhongBan> laydsPhongBan();
	
}
