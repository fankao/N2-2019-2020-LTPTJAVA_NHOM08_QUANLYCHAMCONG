package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ChiTietChamCongPK.class)
@Table(name = "chitietchamcong")
public class ChiTietChamCong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "ngaychamcong")
	private NgayChamCong ngaychamcong;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nhanvien", updatable = true)
	private NhanVien nhanvien;

	private boolean daChamCong;

	public ChiTietChamCong() {
		super();
	}

	public ChiTietChamCong(NgayChamCong ngaychamcong, NhanVien nhanvien, boolean daChamCong) {
		super();
		this.nhanvien = nhanvien;
		this.ngaychamcong = ngaychamcong;
		this.daChamCong = daChamCong;
	}

	public ChiTietChamCong(boolean daChamCong) {
		super();
		this.daChamCong = daChamCong;
	}

	public NhanVien getNhanVien() {
		return nhanvien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanvien = nhanVien;
	}

	public NgayChamCong getNcc() {
		return ngaychamcong;
	}

	public void setNcc(NgayChamCong ncc) {
		this.ngaychamcong = ncc;
	}

	public boolean isDaChamCong() {
		return daChamCong;
	}

	public void setDaChamCong(boolean daChamCong) {
		this.daChamCong = daChamCong;
	}

	@Override
	public String toString() {
		return "ChiTietChamCong [ngaychamcong=" + ngaychamcong + ", nhanvien=" + nhanvien + ", daChamCong=" + daChamCong
				+ "]";
	}

}
