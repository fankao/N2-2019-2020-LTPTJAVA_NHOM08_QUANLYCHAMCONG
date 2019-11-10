package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.BacLuong;

public interface BacLuongConTrol extends Remote {
	public BacLuong layBacLuongTheoMa(String ma) throws RemoteException;

	public List<BacLuong> layDanhSachBacLuong() throws RemoteException;
}
