package repository.sql.domain;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tenants", schema = "public")
public class TenantSql extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private Set<UserSql> users;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanySql company;    
    
  
	public TenantSql() {
		// TODO Auto-generated constructor stub
	}


	public TenantSql(Long id, String name, Date createDate, String createUser, Date updateDate, String updateUser,
			boolean active, CompanySql companies) {
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


	public Set<UserSql> getUsers() {
		return users;
	}


	public void setUsers(Set<UserSql> users) {
		this.users = users;
	}


	public CompanySql getCompany() {
		return company;
	}


	public void setCompany(CompanySql company) {
		this.company = company;
	}


	
    
    
}
