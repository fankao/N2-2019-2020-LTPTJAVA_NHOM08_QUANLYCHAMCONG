package control.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import control.ChiTietChamCongControl;
import dao.ChiTietChamCongDAO;
import dao.impl.ChiTietChamCongDAOImpl;
import entities.ChiTietChamCong;
import entities.NhanVien;

public class ChiTietChamCongControlImpl extends UnicastRemoteObject implements ChiTietChamCongControl {
	private static final long serialVersionUID = 1L;
	private ChiTietChamCongDAO chiTietChamCongDAO;

	public ChiTietChamCongControlImpl() throws RemoteException {
		chiTietChamCongDAO = new ChiTietChamCongDAOImpl();
	}

	@Override
	public ChiTietChamCong themChiTietChamCong(ChiTietChamCong ctcc) throws RemoteException {

		return chiTietChamCongDAO.themChiTietChamCong(ctcc);
	}

	@Override
	public ChiTietChamCong suaChiTietChamCong(ChiTietChamCong ctcc) throws RemoteException {
		return chiTietChamCongDAO.suaChiTietChamCong(ctcc);
	}

	@Override
	public int tinhNgayDaChamCongTheoThang(NhanVien nv, int thang) throws RemoteException {
		int songaychamcong = 0;
		List<ChiTietChamCong> chiTietChamCongs = layDSCTNhanVienChamTheoThang(nv.getId(), thang);
		for (ChiTietChamCong chiTietChamCong : chiTietChamCongs) {
			if (chiTietChamCong.isDaChamCong() && chiTietChamCong.getNcc().getNgayCham().getMonthValue() == thang) {
				songaychamcong++;
			}
		}
		return songaychamcong;
	}

	@Override
	public List<ChiTietChamCong> layDanhSachChiTietChamCongTheoIdNV(ObjectId id) throws RemoteException {

		return chiTietChamCongDAO.layDanhSachChiTietChamCongTheoIdNV(id);

	}

	@Override
	public List<ChiTietChamCong> layDSCTNhanVienChamTheoThang(ObjectId id, int thang) throws RemoteException {
		List<ChiTietChamCong> chiTietChamCongs = layDanhSachChiTietChamCongTheoIdNV(id);
		List<ChiTietChamCong> ctccsThang = new ArrayList<ChiTietChamCong>();
		if (chiTietChamCongs != null) {
			for (ChiTietChamCong x : chiTietChamCongs) {
				if (x.getNcc().getNgayCham().getMonthValue() == thang
						&& x.getNcc().getNgayCham().getYear() == LocalDate.now().getYear()) {
					ctccsThang.add(x);
				}
			}
		}
		return ctccsThang;

	}

	@Override
	public List<ChiTietChamCong> layDSCTNhanVienChamTheoNgay(String maPB, LocalDate date) throws RemoteException {
		List<ChiTietChamCong> chiTietChamCongs = chiTietChamCongDAO.layDanhSachChiTietChamCong();
		List<ChiTietChamCong> ctccsThang = new ArrayList<ChiTietChamCong>();
		if (chiTietChamCongs != null) {
			for (ChiTietChamCong x : chiTietChamCongs) {
				if (x.getNhanVien().getPhongBan().getMaPB().equals(maPB) && x.getNcc().getNgayCham().isEqual(date)) {
					ctccsThang.add(x);
				}
			}
		}
		return ctccsThang;
	}

	@Override
	public int tinhNgayNghiTheoThang(NhanVien nv, int thang) throws RemoteException {
		int songaynghi = 0;
		List<ChiTietChamCong> chiTietChamCongs = layDSCTNhanVienChamTheoThang(nv.getId(), thang);
		for (ChiTietChamCong chiTietChamCong : chiTietChamCongs) {
			if (chiTietChamCong.isDaChamCong() == false
					&& chiTietChamCong.getNcc().getNgayCham().getMonthValue() == thang) {
				songaynghi++;
			}
		}
		return songaynghi;
	}

	public static void main(String[] args) throws RemoteException {
		ChiTietChamCongControlImpl chamCongControlImpl = new ChiTietChamCongControlImpl();
		System.out.println(
				chamCongControlImpl.layDSCTNhanVienChamTheoThang(new ObjectId("5dc66395703d3d174cb51fa8"), 11));
	}

}
