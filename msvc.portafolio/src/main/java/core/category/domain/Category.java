package core.category.domain;

import java.util.Date;

public class Category {

	private String name;
	
	private String url;
	
	private Long view;
	
	private String image;
	
	private Date createDate;
	
	private String createUser;

	private Date updateDate;
	
	private String updateUser;
	
	private String status;	

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, String url, Long view, String image, Date createDate, String createUser,
			Date updateDate, String updateUser, String status) {
		super();
		this.name = name;
		this.url = url;
		this.view = view;
		this.image = image;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
