package core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class NotFoundException extends RuntimeException {

	private Integer code;

	public NotFoundException(Integer code, String message) {
		super(message);
		this.code = code;
	}
}