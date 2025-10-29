package repository.sql.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import repository.sql.domain.CompanySql;

public interface CompanySqlDao extends JpaRepository<CompanySql, Long> {

	Optional<CompanySql> findById(Long id);
	Optional<CompanySql> findByName(String name);
	Optional<CompanySql> findByNumberDocument(String numberDocument);
	Page<CompanySql> findByNameLike(String name, Pageable pageable);
}
