package repository.sql.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users", schema = "public")
public class UserSql extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2106912863619655101L;

	@Column(name = "full_name", length = 100)
	private String fullName;

	@Column(name = "password", length = 255)
	private String password;

	@Column(nullable = true)
	private String image;

	@Email
	@NotBlank
	@Column(unique = true, length = 100, nullable = false)
	private String email;

	@Column(name = "email_confirmed", nullable = false)
	private boolean emailConfirmed;

	@Column(nullable = true)
	private String phone;

	@Column(name = "phone_confirmed", nullable = true)
	private boolean phoneConfirmed;

	@Column(nullable = true)
	private String occupation;

	@Column(name = "is_administrator", nullable = false)
	private boolean isAdministrator;

	@Column(name = "expire_password")
	@Temporal(TemporalType.DATE)
	private Date expirePassword;

	@Column(name = "verification_token")
	private String verificationToken;

	@Column(name = "is_expire_password", nullable = false)
	private boolean isExpirePassword;

	@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") }, uniqueConstraints = {
					@UniqueConstraint(columnNames = { "user_id", "role_id" }) })
	private Set<RoleSql> roles;

	@ManyToOne
	@JoinColumn(name = "tenant_id", nullable = false)
	private TenantSql tenant;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private CompanySql company;

	public UserSql() {

	}

	public UserSql(Long id, String fullName, String password, String image, String email, boolean emailConfirmed,
			String phone, boolean phoneConfirmed, String occupation, Date createDate, String createUser,
			Date updateDate, String updateUser, boolean active, boolean isAdministrator, boolean isExpirePassword,
			Date expirePassword, String verificationToken, Set<RoleSql> role, CompanySql company) {

		id = id;
		this.fullName = fullName;
		this.password = password;
		this.image = image;
		this.email = email;
		this.emailConfirmed = emailConfirmed;
		this.phone = phone;
		this.phoneConfirmed = phoneConfirmed;
		this.occupation = occupation;
		createDate = createDate;
		createUser = createUser;
		updateDate = updateDate;
		updateUser = updateUser;
		active = active;
		this.isAdministrator = isAdministrator;
		this.isExpirePassword = isExpirePassword;
		this.expirePassword = expirePassword;
		this.verificationToken = verificationToken;
		this.roles = role;
		this.company = company;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}

	public void setPhoneConfirmed(boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public boolean isAdministrator() {
		return isAdministrator;
	}

	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public Date getExpirePassword() {
		return expirePassword;
	}

	public void setExpirePassword(Date expirePassword) {
		this.expirePassword = expirePassword;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}

	

	public Set<RoleSql> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleSql> roles) {
		this.roles = roles;
	}

	public CompanySql getCompany() {
		return company;
	}

	public void setCompany(CompanySql company) {
		this.company = company;
	}

	public TenantSql getTenant() {
		return tenant;
	}

	public void setTenant(TenantSql tenant) {
		this.tenant = tenant;
	}

	public boolean isExpirePassword() {
		return isExpirePassword;
	}

	public void setExpirePassword(boolean isExpirePassword) {
		this.isExpirePassword = isExpirePassword;
	}

}
