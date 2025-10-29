package application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import controller.CategoryServiceController;
import core.category.domain.input.CategoryIn;
import core.category.domain.input.FilterPagination;
import core.category.domain.output.CategoryOut;
import core.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
@Validated
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class CategoryController {

	@Autowired
	private CategoryServiceController controller;

	@Operation(summary = "Search category by id")
	@GetMapping("{id}")
	public ResponseEntity<?> BuscarPorCodigo(@PathVariable(name = "id") Long id) {
		try {
			CategoryOut categoryOutput = controller.findById(id);
			return new ResponseEntity<>(categoryOutput, HttpStatus.OK);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
		}
	}

	@Operation(summary = "Save category item")
	@PostMapping
	public ResponseEntity<?> Save(@Valid @RequestBody CategoryIn request) {

		CategoryOut categoryOutput = controller.create(request);
		return new ResponseEntity<>(categoryOutput, HttpStatus.CREATED);
	}

	@Operation(summary = "Update an category", description = "Update an existing category. The response is updated category object with id, name, status.")
	@PutMapping
	public ResponseEntity<?> Update(@Valid @RequestBody CategoryIn request) {

		return new ResponseEntity<>(new CategoryOut(), HttpStatus.OK);
	}

	@Operation(summary = "Filter all category by name")
	@RequestMapping(value = "/filterpage", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> filterPage(@RequestBody FilterPagination filter) {

		Pageable pageRequest = PageRequest.of(filter.getPage(), filter.getSize());

		Page<CategoryOut> list = controller.findAllFilter(pageRequest, filter);

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}
