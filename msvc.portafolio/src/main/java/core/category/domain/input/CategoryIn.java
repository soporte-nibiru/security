package core.category.domain.input;

import jakarta.validation.constraints.*;

public class CategoryIn {

	@NotEmpty(message = "Name is required.")
	@Size(min = 5, max = 120, message = "Name must be between 5 and 15 characters long.")
    private String name;
	
	@Size(max = 220, message = "Url must be maximum 220 characters long.")
	private String url;
	
	private Long view;
	
	private String image;
	
	/*@NotEmpty(message = "User is required.")
	private String user;*/
	
	@NotEmpty(message = "Status is required.")
	private String status;
	
	public CategoryIn() {
		// TODO Auto-generated constructor stub
	}	

	public CategoryIn(String name, String url, Long view, String image, String status) {
		super();
		this.name = name;
		this.url = url;
		this.view = view;
		this.image = image;
		//this.user = user;
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

	/*public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
