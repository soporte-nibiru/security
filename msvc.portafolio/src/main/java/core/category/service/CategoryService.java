package core.category.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import core.category.domain.Category;
import core.category.domain.input.FilterPagination;
import repository.sql.CategorySqlRepository;
import repository.sql.domain.CategorySql;

public class CategoryService {

	private CategorySqlRepository repository;

	public CategoryService(CategorySqlRepository repository) {

		this.repository = repository;
	}

	public Category findById(Long id) {

		return repository.findById(id);
	}

	public Category save(Category category) {

		

		CategorySql categorySql = new CategorySql();
		categorySql.setName(category.getName());
		categorySql.setUrl(category.getUrl());
		categorySql.setView(category.getView());
		categorySql.setCreateUser(category.getCreateUser());
		categorySql.setUpdateUser(category.getCreateUser());
		categorySql.setStatus(category.getStatus());
		return repository.save(categorySql);
	}

	public Page<Category> findAllFilter(Pageable pageable, FilterPagination filter) {

		return repository.findAllFilter(pageable, filter);
	}
}
