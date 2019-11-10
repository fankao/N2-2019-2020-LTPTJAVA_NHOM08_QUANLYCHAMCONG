package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bson.types.ObjectId;

@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;
	@Column(nullable = false, unique = true)
	private String maNV;

	@Column(nullable = false)
	private String hoVaTen;
	private LocalDate ngaySinh;
	private String soCMND;
	private String email;
	private double luongCoBan;
	private String soDienThoai;
	private boolean gioiTinh;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "phongban")
	private PhongBan phongBan;

	@Embedded
	@Column(nullable = true)
	private TaiKhoan taiKhoan;

	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String hoVaTen, LocalDate ngaySinh, String soCMND, String email, double luongCoBan,
			String soDienThoai, boolean gioiTinh) {
		super();
		this.maNV = maNV;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
		this.email = email;
		this.luongCoBan = luongCoBan;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", maNV=" + maNV + ", hoVaTen=" + hoVaTen + ", ngaySinh=" + ngaySinh + ", soCMND="
				+ soCMND + ", email=" + email + ", luongCoBan=" + luongCoBan + ", soDienThoai=" + soDienThoai
				+ ", gioiTinh=" + gioiTinh + ", phongBan=" + phongBan + ", taiKhoan=" + taiKhoan + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}

}
