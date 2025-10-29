package core.company.mapper;

import org.springframework.stereotype.Service;

import core.company.domain.Company;
import repository.sql.domain.CompanySql;

@Service
public class CompanyMapperService {
	 public CompanySql convertToCompanySql(Company company) {
	        return CompanyMapper.INSTANCE.toCompanySql(company);
	    }

	    public Company convertToCompany(CompanySql companySql) {
	        return CompanyMapper.INSTANCE.toCompany(companySql);
	    }
}
