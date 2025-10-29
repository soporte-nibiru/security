package repository.sql.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_date", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "update_date")
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	@Column(name = "update_user")
	private String updateUser;
	
	@Column(name = "is_active", nullable = false)
	private boolean active;


	@PrePersist
	protected void onCreate() {

		// Convertir LocalDateTime a Date
		LocalDateTime localDateTime = LocalDateTime.now();
		Date fecha = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		createDate = fecha;
		active=true;
	}

	@PreUpdate
	protected void onUpdate() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Date fecha = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		updateDate = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}



	
}
