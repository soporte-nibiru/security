package repository.sql.adapter;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import core.category.domain.Category;
import core.category.domain.input.FilterPagination;
import core.exception.NotFoundException;
import repository.sql.CategorySqlRepository;
import repository.sql.dao.CategorySqlDao;
import repository.sql.domain.CategorySql;

public class CategorySqlAdapter implements CategorySqlRepository{

	private CategorySqlDao categoryDao;
	private ModelMapper modelMapper;	
	
	
	public CategorySqlAdapter(CategorySqlDao categoryDao, ModelMapper modelMapper) {
		this.categoryDao = categoryDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		Optional<CategorySql> category = categoryDao.findById(id);
		return category
				.map(categorySql ->  modelMapper.map(categorySql, Category.class))
				.orElseThrow(() -> new NotFoundException(404, "Category not found"));
	}

	@Override
	public Category save(CategorySql category) {
		// TODO Auto-generated method stub				
		Optional<CategorySql> categoryOptional = categoryDao.findByName(category.getName());		
		if (categoryOptional.isPresent()) {
			return modelMapper.map(categoryOptional.orElseThrow(() -> new NotFoundException(302,"category found")), Category.class);
		}	
		return modelMapper.map(categoryDao.save(category), Category.class);
	}

	@Override
	public Category update(CategorySql category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findByExistId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(CategorySql category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> findByLikeName(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Category> findAllFilter(Pageable pageable, FilterPagination filter) {
		// TODO Auto-generated method stub
		if (!filter.getSearch().equals("")) {
			Page<CategorySql> search = categoryDao.findByNameLike("%" + filter.getSearch() + "%", pageable);
			return search.map(entity -> modelMapper.map(entity, Category.class));
		} else {
			Page<CategorySql> all = categoryDao.findAll(pageable);
			return all.map(entity -> modelMapper.map(entity, Category.class));
		}
	}

}
