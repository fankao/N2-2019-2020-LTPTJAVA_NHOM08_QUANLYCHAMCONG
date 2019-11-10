package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bson.types.ObjectId;

@Entity
@Table(name = "ngaychamcong")
public class NgayChamCong implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;
	private LocalDate ngayCham;

	public NgayChamCong() {
		super();
	}

	public NgayChamCong(LocalDate ngayCham) {
		super();
		this.ngayCham = ngayCham;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public LocalDate getNgayCham() {
		return ngayCham;
	}

	public void setNgayCham(LocalDate ngayCham) {
		this.ngayCham = ngayCham;
	}

}
