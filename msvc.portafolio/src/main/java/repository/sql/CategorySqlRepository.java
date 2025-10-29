package repository.sql;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import core.category.domain.Category;
import core.category.domain.input.FilterPagination;
import repository.sql.domain.CategorySql;


public interface CategorySqlRepository {
	public List<Category> findAll();
    public Category findById(Long id);
	public Category save(CategorySql category);
	public Category update(CategorySql category);
	public boolean findByExistId(Long id);
	public void delete(CategorySql category);
	public List<Category> findByLikeName(String query);
	Page<Category> findAllFilter(Pageable pageable, FilterPagination filter);
}
