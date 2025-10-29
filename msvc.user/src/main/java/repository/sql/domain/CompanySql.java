package repository.sql.domain;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "companies", schema = "public")
public class CompanySql extends BaseEntity {
	
	@Column(name = "number_document",unique = true, length = 15,nullable = false)
	private String numberDocument;
	
	private String name;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private Set<UserSql> users;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<TenantSql> tenants;
    

	
    public CompanySql() {
		// TODO Auto-generated constructor stub
	}

	public CompanySql(Long id, String name, String numberDocument, Date createDate, String createUser, Date updateDate, String updateUser,
			boolean active, Set<UserSql> users, Set<TenantSql> tenants) {
		id = id;
		this.name = name;
		this.numberDocument = numberDocument;
		createDate = createDate;
		createUser = createUser;
		updateDate = updateDate;
		updateUser = updateUser;
		active = active;
		this.users = users;
		this.tenants = tenants;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	
	public Set<UserSql> getUsers() {
		return users;
	}

	public void setUsers(Set<UserSql> users) {
		this.users = users;
	}

	public Set<TenantSql> getTenants() {
		return tenants;
	}

	public void setTenants(Set<TenantSql> tenants) {
		this.tenants = tenants;
	}

	
	
	
}
