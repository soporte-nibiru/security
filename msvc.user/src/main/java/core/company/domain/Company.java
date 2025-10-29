package core.company.domain;

import java.util.Set;

import core.tenant.domain.Tenant;
import repository.sql.domain.TenantSql;

public class Company {
	
	private String numberDocument;
	
	private String name;
	
	private String status;
	
	private Set<TenantSql> tenants;

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String numberDocument, String name, String status, Set<TenantSql> tenant) {
		super();
		this.numberDocument = numberDocument;
		this.name = name;
		this.status = status;
		this.tenants = tenant;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
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

	public Set<TenantSql> getTenant() {
		return tenants;
	}

	public void setTenant(Set<TenantSql> tenant) {
		this.tenants = tenant;
	}

	 
}
