package core.user.service;


import java.util.Optional;
import java.util.UUID;


import core.company.domain.Company;
import core.user.domain.User;
import repository.sql.CompanySqlRepository;
import repository.sql.TenantSqlRepository;
import repository.sql.UserSqlRepository;
import repository.sql.domain.CompanySql;
import repository.sql.domain.TenantSql;
import repository.sql.domain.UserSql;

public class UserService {

	private UserSqlRepository repository;
	private CompanySqlRepository companyRepository;
    private TenantSqlRepository tenantRepository;
	
	public UserService(UserSqlRepository repository, 
					   CompanySqlRepository companyRepository,
					   TenantSqlRepository tenantRepository) {
		this.repository = repository;
		this.companyRepository = companyRepository;
		this.tenantRepository = tenantRepository;
	}


	public User save(User user) {

		UserSql userSql = new UserSql();
		userSql.setEmail(user.getEmail());
		Company company = companyRepository.getCompanyByNumberDocument(user.getNumberDocument());
		Optional<Company> optionalValue = Optional.ofNullable(company);
		if (optionalValue.isEmpty()) {
			
			CompanySql companySql = new CompanySql();
			companySql.setName(user.getFullName());
			companySql.setNumberDocument(user.getNumberDocument());
			companyRepository.save(companySql);
			
			TenantSql tenantSql=new TenantSql();
			tenantSql.setName("Tenant 50");
			tenantSql.setCompany(companySql);
			tenantRepository.save(tenantSql);
			
			userSql.setCompany(companySql);
			userSql.setTenant(tenantSql);
			String randomUUID = UUID.randomUUID().toString();
			userSql.setPassword(user.getPassword());
			userSql.setVerificationToken(randomUUID);
		}
		else {
			
		}
			
		
		//userSql.setUpdateUser(user.getCreateUser());
		//userSql.setStatus(user.getStatus());
		return repository.save(userSql);
	}
}
