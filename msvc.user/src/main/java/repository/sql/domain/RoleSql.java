package repository.sql.domain;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "roles", schema = "public")
public class RoleSql extends BaseEntity {


	private String name;
		
	@ManyToMany
    @JoinTable(
        name = "role_permissions",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<PermissionSql> permissions;

	public RoleSql(Long id, String name, Date createDate, String createUser, Date updateDate, String updateUser,
			boolean active, Set<PermissionSql> permissions) {
		
		id = id;
		this.name = name;
		createDate = createDate;
		createUser = createUser;
		updateDate = updateDate;
		updateUser = updateUser;
		active = active;
		this.permissions = permissions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Set<PermissionSql> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PermissionSql> permissions) {
		this.permissions = permissions;
	}
	
	
}
