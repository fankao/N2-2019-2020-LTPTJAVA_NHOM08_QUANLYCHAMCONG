package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(NhanVien_BacLuongPK.class)
@Table(name = "nhanvien_bacluong")
public class NhanVien_BacLuong implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanvien;
	@Id
	@ManyToOne
	@JoinColumn(name = "maBL")
	private BacLuong bacluong;
	public NhanVien_BacLuong() {
	}
	public NhanVien_BacLuong(NhanVien nhanVien, BacLuong bacLuong) {
		super();
		this.nhanvien = nhanVien;
		this.bacluong = bacLuong;
	}
	public NhanVien getNhanVien() {
		return nhanvien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanvien = nhanVien;
	}
	public BacLuong getBacLuong() {
		return bacluong;
	}
	public void setBacLuong(BacLuong bacLuong) {
		this.bacluong = bacLuong;
	}
	
}
