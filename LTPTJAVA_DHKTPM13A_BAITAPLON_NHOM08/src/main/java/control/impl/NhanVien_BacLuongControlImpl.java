package control.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.bson.types.ObjectId;

import control.NhanVien_BacLuongControl;
import dao.NhanVien_BacLuongDAO;
import dao.impl.NhanVien_BacLuongDAOImpl;
import entities.NhanVien_BacLuong;

public class NhanVien_BacLuongControlImpl extends UnicastRemoteObject implements NhanVien_BacLuongControl {
	private static final long serialVersionUID = 1L;
	private NhanVien_BacLuongDAO bacLuongDAO;

	public NhanVien_BacLuongControlImpl() throws RemoteException {
		bacLuongDAO = new NhanVien_BacLuongDAOImpl();
	}

	@Override
	public NhanVien_BacLuong themChiTietLuong(NhanVien_BacLuong ct) throws RemoteException {
		// TODO Auto-generated method stub
		return bacLuongDAO.themChiTietLuong(ct);
	}

	@Override
	public NhanVien_BacLuong suaChiTietLuong(NhanVien_BacLuong ct) throws RemoteException {
		// TODO Auto-generated method stub
		return bacLuongDAO.suaChiTietLuong(ct);
	}

	@Override
	public List<NhanVien_BacLuong> layChiTietLuong() throws RemoteException {
		// TODO Auto-generated method stub
		return bacLuongDAO.layChiTietBacLuong();
	}

	@Override
	public NhanVien_BacLuong layChiTietLuongTheoIdNV(ObjectId id) {

		return bacLuongDAO.layChiTietBacLuongTheoIdNV(id);
	}

}
