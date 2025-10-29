package controller;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import core.category.domain.Category;
import core.category.domain.input.CategoryIn;
import core.category.domain.input.FilterPagination;
import core.category.domain.output.CategoryOut;
import core.category.service.CategoryService;

public class CategoryServiceController {

	private CategoryService service;
	private ModelMapper modelMapper;
	
	public CategoryServiceController(CategoryService service, ModelMapper modelMapper) {

		this.service = service;
		this.modelMapper = modelMapper;
	}
	
	public CategoryOut findById(Long id){
		
		Category category = service.findById(id);
		return modelMapper.map(category, CategoryOut.class);
	}
	
	public CategoryOut create(CategoryIn request) 
	{
		Category category = modelMapper.map(request, Category.class);
		return modelMapper.map(service.save(category), CategoryOut.class);
	}

	public Page<CategoryOut> findAllFilter(Pageable pageableIn, FilterPagination filter) {
		
		Page<Category> pageable = service.findAllFilter(pageableIn, filter);		
		return pageable.map(objectEntity -> modelMapper.map(objectEntity, CategoryOut.class));
	}
}
