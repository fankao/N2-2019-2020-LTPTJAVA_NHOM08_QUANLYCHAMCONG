package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import control.BacLuongConTrol;
import control.ChiTietChamCongControl;
import control.NhanVienControl;
import control.NhanVien_BacLuongControl;
import control.PhongBanControl;
import control.impl.BacLuongControlImpl;
import control.impl.ChiTietChamCongControlImpl;
import control.impl.NhanVienControlImpl;
import control.impl.NhanVien_BacLuongControlImpl;
import control.impl.PhongBanControlImpl;

public class Server {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "mypolicy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			LocateRegistry.createRegistry(1099);
			// Khoi tao control
			NhanVienControl nhanVienControl = new NhanVienControlImpl();
			ChiTietChamCongControl chiTietChamCongControl = new ChiTietChamCongControlImpl();
			PhongBanControl phongbanControl = new PhongBanControlImpl();
			BacLuongConTrol bacluongControl = new BacLuongControlImpl();
			NhanVien_BacLuongControl luongControl = new NhanVien_BacLuongControlImpl();

			// bin to server

			Context context = new InitialContext();

			context.bind("rmi://localhost:1099/nhanvien", nhanVienControl);
			context.bind("rmi://localhost:1099/chitietchamcong", chiTietChamCongControl);
			context.bind("rmi://localhost:1099/phongban", phongbanControl);
			context.bind("rmi://localhost:1099/bacluong", bacluongControl);
			context.bind("rmi://localhost:1099/chitietluong", luongControl);

			/*
			 * context.bind("rmi://172.16.0.225:1099/nhanvien", nhanVienControl);
			 * context.bind("rmi://172.16.0.225:1099/chitietchamcong",
			 * chiTietChamCongControl); context.bind("rmi://172.16.0.225:1099/phongban",
			 * phongbanControl); context.bind("rmi://172.16.0.225:1099/bacluong",
			 * bacluongControl); context.bind("rmi://172.16.0.225:1099/chitietluong",
			 * luongControl);
			 */
			System.out.println("Server is ready!");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
