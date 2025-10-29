package repository.sql.dao;


import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import repository.sql.domain.UserSql;


@Repository
public interface UserSqlDao extends JpaRepository<UserSql, Long> {

	Optional<UserSql> findById(Long id);
	Optional<UserSql> findByFullName(String name);
	Optional<UserSql> findByEmail(String email);
	Page<UserSql> findByFullNameLike(String name, Pageable pageable);
}
