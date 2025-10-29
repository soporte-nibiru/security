package core.user.domain.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserIn {
	@NotEmpty(message = "Full Name is required.")
	@Size(min = 5, max = 120, message = "Name must be between 5 and 120 characters long.")
	private String fullName;
	private String password;
	private String image;
	private String email;
	private String numberDocument;
	private String typeDocument;
	
	public UserIn() {
			// TODO Auto-generated constructor stub
	}

	public UserIn(String fullName, String password, String image, String email, String numberDocument,
			String typeDocument) {
		super();
		this.fullName = fullName;
		this.password = password;
		this.image = image;
		this.email = email;
		this.numberDocument = numberDocument;
		this.typeDocument = typeDocument;
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

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}
	
	
}
