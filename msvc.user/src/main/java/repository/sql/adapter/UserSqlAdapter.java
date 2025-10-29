package repository.sql.adapter;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import core.exception.NotFoundException;
import core.user.domain.User;
import core.user.domain.input.FilterPagination;
import repository.sql.UserSqlRepository;
import repository.sql.dao.UserSqlDao;
import repository.sql.domain.UserSql;

public class UserSqlAdapter implements UserSqlRepository{

	private UserSqlDao userDao;
	private ModelMapper modelMapper;
	
	public UserSqlAdapter(UserSqlDao userDao, ModelMapper modelMapper) {
		this.userDao = userDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<UserSql> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(UserSql user) {
		// TODO Auto-generated method stub
		Optional<UserSql> userOptional = userDao.findByEmail(user.getEmail());		
		if (userOptional.isPresent()) {
			return modelMapper.map(userOptional.orElseThrow(() -> new NotFoundException(302,"User found")), User.class);
		}	
		return modelMapper.map(userDao.save(user), User.class);

	}

	@Override
	public User update(UserSql user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findByExistId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(UserSql user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findByLikeName(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAllFilter(Pageable pageable, FilterPagination filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
