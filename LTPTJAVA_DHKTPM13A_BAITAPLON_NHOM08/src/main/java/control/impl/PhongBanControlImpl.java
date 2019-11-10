package control.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import control.PhongBanControl;
import dao.PhongBanDAO;
import dao.impl.PhongBanDAOImpl;
import entities.PhongBan;

public class PhongBanControlImpl extends UnicastRemoteObject implements PhongBanControl{
	private PhongBanDAO phongbanDAO;
	
	public PhongBanControlImpl() throws RemoteException{
		phongbanDAO = new PhongBanDAOImpl();
	}
	@Override
	public PhongBan layTTPhongBanTheoMa(String ma) throws RemoteException {
		// TODO Auto-generated method stub
		return phongbanDAO.layTTPhongBanTheoMa(ma);
	}

	@Override
	public List<PhongBan> laydsPhongBan() throws RemoteException {
		// TODO Auto-generated method stub
		return phongbanDAO.laydsPhongBan();
	}
	
}
