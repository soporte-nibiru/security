package application.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.UserServiceController;
import core.user.service.UserService;
import repository.sql.CompanySqlRepository;
import repository.sql.TenantSqlRepository;
import repository.sql.UserSqlRepository;
import repository.sql.adapter.CompanySqlAdapter;
import repository.sql.adapter.TenantSqlAdapter;
import repository.sql.adapter.UserSqlAdapter;
import repository.sql.dao.CompanySqlDao;
import repository.sql.dao.TenantSqlDao;
import repository.sql.dao.UserSqlDao;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages= {"repository"})
public class SpringConfig {

	@Autowired
	private UserSqlDao userDao;
	
	@Autowired
	private CompanySqlDao companyDao;
	
	@Autowired
	private TenantSqlDao tenantDao;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public UserSqlRepository userSqlRepository() {
		return new UserSqlAdapter(userDao, modelMapper());
	}
	
	
	@Bean
	public CompanySqlRepository companySqlRepository() {
		return new CompanySqlAdapter(companyDao, modelMapper());
	}
	
	@Bean
	public TenantSqlRepository tenantSqlRepository() {
		return new TenantSqlAdapter(tenantDao, modelMapper());
	}

	
	@Bean
	public UserService userService() {
		return new UserService(userSqlRepository(),companySqlRepository(),tenantSqlRepository());
	}
	
	@Bean
	public UserServiceController userServiceController() {
		return new UserServiceController(userService(),modelMapper());
	}
	
	
}
