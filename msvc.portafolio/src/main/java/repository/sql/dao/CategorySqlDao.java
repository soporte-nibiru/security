package repository.sql.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import repository.sql.domain.CategorySql;

@Repository
public interface CategorySqlDao extends JpaRepository<CategorySql, Integer> {

	Optional<CategorySql> findById(Long id);
	Optional<CategorySql> findByName(String name);
	List<CategorySql> findAllCategoryOrderBy(Sort sort);
	Page<CategorySql> findByNameLike(String name, Pageable pageable);
	

	 
	
}
