package core.user.domain.output;

public class UserOut {

	private String fullName;
	private String image;
	private String email;
	
	public UserOut() {
		// TODO Auto-generated constructor stub
	}

	public UserOut(String fullName, String image, String email) {
		super();
		this.fullName = fullName;
		this.image = image;
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	
	
}
