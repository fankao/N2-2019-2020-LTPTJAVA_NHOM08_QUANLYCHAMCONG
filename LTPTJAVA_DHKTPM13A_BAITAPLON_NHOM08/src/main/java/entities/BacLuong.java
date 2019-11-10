package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bacluong")
public class BacLuong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String maBL;
	private double heSo;

	public BacLuong() {
	}

	public BacLuong(String maBL, double heSo) {
		super();
		this.maBL = maBL;
		this.heSo = heSo;
	}

	public String getMaBL() {
		return maBL;
	}

	public void setMaBL(String maBL) {
		this.maBL = maBL;
	}

	public double getHeSo() {
		return heSo;
	}

	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getHeSo() + "";
	}

}
