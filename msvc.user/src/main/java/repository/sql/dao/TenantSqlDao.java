package repository.sql.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import repository.sql.domain.TenantSql;

public interface TenantSqlDao extends JpaRepository<TenantSql, Long> {
	Optional<TenantSql> findById(Long id);
	Optional<TenantSql> findByName(String name);
	Page<TenantSql> findByNameLike(String name, Pageable pageable);
}
