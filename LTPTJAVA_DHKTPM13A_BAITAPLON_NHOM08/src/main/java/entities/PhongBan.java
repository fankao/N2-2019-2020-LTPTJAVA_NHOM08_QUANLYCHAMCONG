package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phongban")
public class PhongBan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String maPB;
	private String tenPB;

	public PhongBan() {
		// TODO Auto-generated constructor stub
	}


	public PhongBan(String maPB, String tenPB) {
		super();
		this.maPB = maPB;
		this.tenPB = tenPB;
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public String getTenPB() {
		return tenPB;
	}

	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}

	@Override
	public String toString() {

		// TODO Auto-generated method stub
		return this.tenPB;
	}
}
