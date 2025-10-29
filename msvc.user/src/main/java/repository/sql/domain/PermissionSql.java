package repository.sql.domain;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions", schema = "public")
public class PermissionSql extends BaseEntity{

    private String name;

	public PermissionSql(Long id, String name, Date createDate, String createUser, Date updateDate, String updateUser,
			boolean active) {
		super();
		id = id;
		this.name = name;
		createDate = createDate;
		createUser = createUser;
		updateDate = updateDate;
		updateUser = updateUser;
		active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
