package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.bson.types.ObjectId;

import entities.NhanVien_BacLuong;

public interface NhanVien_BacLuongControl extends Remote {
	public NhanVien_BacLuong themChiTietLuong(NhanVien_BacLuong ct) throws RemoteException;

	public NhanVien_BacLuong suaChiTietLuong(NhanVien_BacLuong ct) throws RemoteException;

	public List<NhanVien_BacLuong> layChiTietLuong() throws RemoteException;

	public NhanVien_BacLuong layChiTietLuongTheoIdNV(ObjectId id) throws RemoteException;

}
