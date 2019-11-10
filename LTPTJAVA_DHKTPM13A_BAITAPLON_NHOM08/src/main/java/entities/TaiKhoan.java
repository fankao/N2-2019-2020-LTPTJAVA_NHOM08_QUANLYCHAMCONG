package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tenDangNhap;
	
	private String matKhau;
	private int quyen;

	public TaiKhoan() {

	}

	public TaiKhoan(String tenDangNhap, String matKhau, int quyen) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}

	public TaiKhoan(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matKhau == null) ? 0 : matKhau.hashCode());
		result = prime * result + quyen;
		result = prime * result + ((tenDangNhap == null) ? 0 : tenDangNhap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		if (matKhau == null) {
			if (other.matKhau != null)
				return false;
		} else if (!matKhau.equals(other.matKhau))
			return false;
		if (quyen != other.quyen)
			return false;
		if (tenDangNhap == null) {
			if (other.tenDangNhap != null)
				return false;
		} else if (!tenDangNhap.equals(other.tenDangNhap))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", quyen=" + quyen + "]";
	}

}
