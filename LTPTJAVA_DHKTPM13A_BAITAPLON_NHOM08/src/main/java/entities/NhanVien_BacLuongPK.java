package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.bson.types.ObjectId;

@Embeddable
public class NhanVien_BacLuongPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private ObjectId nhanvien;
	private String bacluong;

	public NhanVien_BacLuongPK() {

	}

	public NhanVien_BacLuongPK(ObjectId nhanvien, String bacluong) {
		super();
		this.nhanvien = nhanvien;
		this.bacluong = bacluong;
	}

	public ObjectId getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(ObjectId nhanvien) {
		this.nhanvien = nhanvien;
	}

	public String getBacluong() {
		return bacluong;
	}

	public void setBacluong(String bacluong) {
		this.bacluong = bacluong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bacluong == null) ? 0 : bacluong.hashCode());
		result = prime * result + ((nhanvien == null) ? 0 : nhanvien.hashCode());
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
		NhanVien_BacLuongPK other = (NhanVien_BacLuongPK) obj;
		if (bacluong == null) {
			if (other.bacluong != null)
				return false;
		} else if (!bacluong.equals(other.bacluong))
			return false;
		if (nhanvien == null) {
			if (other.nhanvien != null)
				return false;
		} else if (!nhanvien.equals(other.nhanvien))
			return false;
		return true;
	}

}
