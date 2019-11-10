package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;

import dao.TaiKhoanDAO;
import entities.TaiKhoan;

public class TaiKhoanDAOImpl extends UnicastRemoteObject implements TaiKhoanDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	protected TaiKhoanDAOImpl() throws RemoteException {
		em = DBEntityManager.getInstance().getEntityManager();
	}

	@Override
	public TaiKhoan themTaiKhoan(TaiKhoan taiKhoan) {
		return null;
	}

	@Override
	public TaiKhoan suaTaiKhoan(TaiKhoan taiKhoan) {
		
		return null;
	}

	@Override
	public TaiKhoan xoaTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoan layTaiKhoan(String tenDangNhap, String matKhau) {
		// TODO Auto-generated method stub
		return null;
	}

}
