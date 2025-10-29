package repository.sql.domain;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategorySql extends BaseEntity{

	
	@Column(name = "name",length=120, unique=true)
	private String name;
	
	@Column(name = "url",length=220, nullable = true)
	private String url;
	
	@Column(name = "view", nullable = true)
	private Long view;
	
	@Column(name = "image", length=220, nullable = true)
	private String image;
	
	private String status;

	public CategorySql() {
		// TODO Auto-generated constructor stub
	}

	public CategorySql(Long id, String name, String url, Long view, String image, Date createDate, String createUser,
			Date updateDate, String updateUser, String status) {
		super();
		id = id;
		this.name = name;
		this.url = url;
		this.view = view;
		this.image = image;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getView() {
		return view;
	}

	public void setView(Long view) {
		this.view = view;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
