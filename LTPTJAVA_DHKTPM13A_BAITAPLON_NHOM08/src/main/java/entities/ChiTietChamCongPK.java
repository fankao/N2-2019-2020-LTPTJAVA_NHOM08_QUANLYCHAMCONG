package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.bson.types.ObjectId;

@Embeddable
public class ChiTietChamCongPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private ObjectId ngaychamcong;
	private ObjectId nhanvien;

	public ChiTietChamCongPK() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietChamCongPK(ObjectId ngaychamcong, ObjectId nhanvien) {
		super();
		this.ngaychamcong = ngaychamcong;
		this.nhanvien = nhanvien;
	}

	public ObjectId getNgaychamcong() {
		return ngaychamcong;
	}

	public void setNgaychamcong(ObjectId ngaychamcong) {
		this.ngaychamcong = ngaychamcong;
	}

	public ObjectId getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(ObjectId nhanvien) {
		this.nhanvien = nhanvien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ngaychamcong == null) ? 0 : ngaychamcong.hashCode());
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
		ChiTietChamCongPK other = (ChiTietChamCongPK) obj;
		if (ngaychamcong == null) {
			if (other.ngaychamcong != null)
				return false;
		} else if (!ngaychamcong.equals(other.ngaychamcong))
			return false;
		if (nhanvien == null) {
			if (other.nhanvien != null)
				return false;
		} else if (!nhanvien.equals(other.nhanvien))
			return false;
		return true;
	}
}
