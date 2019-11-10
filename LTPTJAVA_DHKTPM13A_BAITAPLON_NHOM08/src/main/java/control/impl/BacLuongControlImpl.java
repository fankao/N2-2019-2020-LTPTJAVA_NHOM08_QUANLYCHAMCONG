package control.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import control.BacLuongConTrol;
import dao.BacLuongDAO;
import dao.impl.BacLuongDAOImpl;
import entities.BacLuong;

public class BacLuongControlImpl extends UnicastRemoteObject implements BacLuongConTrol {
	private static final long serialVersionUID = 1L;
	private BacLuongDAO bacluongDAO;

	public BacLuongControlImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		bacluongDAO = new BacLuongDAOImpl();
	}

	@Override
	public BacLuong layBacLuongTheoMa(String ma) throws RemoteException {
		// TODO Auto-generated method stub
		return bacluongDAO.layBacLuongTheoMa(ma);
	}

	@Override
	public List<BacLuong> layDanhSachBacLuong() throws RemoteException {
		// TODO Auto-generated method stub
		return bacluongDAO.layDanhSachBacLuong();
	}

}
