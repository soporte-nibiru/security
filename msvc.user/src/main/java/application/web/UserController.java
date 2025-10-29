package application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controller.UserServiceController;
import core.exception.NotFoundException;
import core.user.domain.input.UserIn;
import core.user.domain.output.UserOut;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class UserController {

	@Autowired
	private UserServiceController controller;
	

	@Operation(summary = "Save user item")
	@PostMapping
	public ResponseEntity<?> Save(@Valid @RequestBody UserIn request) {
		try {
	
			UserOut user = controller.create(request);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
		}
	}
}
