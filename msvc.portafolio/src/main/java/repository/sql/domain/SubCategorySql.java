package repository.sql.domain;

import java.util.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sub_category")
public class SubCategorySql extends BaseEntity{

	@Column(name = "name",length=120, unique=true)
	private String name;
	
	private String status;

	public SubCategorySql() {
		// TODO Auto-generated constructor stub
	}

	public SubCategorySql(Integer id, String name, Date createDate, String createUser, Date updateDate,
			String updateUser, String status) {
		super();
		id = id;
		this.name = name;
		createDate = createDate;
		createUser = createUser;
		updateDate = updateDate;
		updateUser = updateUser;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
