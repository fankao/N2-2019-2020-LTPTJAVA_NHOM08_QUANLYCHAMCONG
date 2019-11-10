package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.PhongBan;

public interface PhongBanControl extends Remote {
	public PhongBan layTTPhongBanTheoMa(String ma) throws RemoteException;

	public List<PhongBan> laydsPhongBan() throws RemoteException;
}
