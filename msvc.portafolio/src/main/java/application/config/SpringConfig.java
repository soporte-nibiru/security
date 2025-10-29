package application.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import controller.CategoryServiceController;
import core.category.service.CategoryService;
import repository.sql.CategorySqlRepository;
import repository.sql.adapter.CategorySqlAdapter;
import repository.sql.dao.CategorySqlDao;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages= {"repository"})
public class SpringConfig{

   
	@Autowired
	private CategorySqlDao categorydao;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public CategorySqlRepository categorySqlRepository() {
		return new CategorySqlAdapter(categorydao, modelMapper());
	}
	
	@Bean
	public CategoryService categoryService() {
		return new CategoryService(categorySqlRepository());
	}
	
	@Bean
	public CategoryServiceController categoriaController() {
		return new CategoryServiceController(categoryService(),modelMapper());
	}
	

	

}
