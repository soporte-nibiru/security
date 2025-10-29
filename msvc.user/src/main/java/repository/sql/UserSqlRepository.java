package repository.sql;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import core.user.domain.User;
import core.user.domain.input.FilterPagination;
import repository.sql.domain.UserSql;

public interface UserSqlRepository {
	public List<UserSql> findAll();
    public User findById(Long id);
	public User save(UserSql user);
	public User update(UserSql user);
	public boolean findByExistId(Long id);
	public void delete(UserSql user);
	public List<User> findByLikeName(String query);
	Page<User> findAllFilter(Pageable pageable, FilterPagination filter);
}
