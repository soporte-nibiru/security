package repository.sql.adapter;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import core.company.domain.Company;
import core.company.mapper.CompanyMapperService;
import core.exception.NotFoundException;
import core.user.domain.User;
import core.user.domain.input.FilterPagination;
import repository.sql.CompanySqlRepository;
import repository.sql.dao.CompanySqlDao;
import repository.sql.domain.CompanySql;
import repository.sql.domain.UserSql;

public class CompanySqlAdapter implements CompanySqlRepository{

	private CompanySqlDao companyDao;
	private ModelMapper modelMapper;
	private CompanyMapperService companyMapper;
	
	public CompanySqlAdapter(CompanySqlDao companyDao, ModelMapper modelMapper) {
		super();
		this.companyDao = companyDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<CompanySql> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company save(CompanySql user) {
		// TODO Auto-generated method stub
		Optional<CompanySql> userOptional = companyDao.findByNumberDocument(user.getNumberDocument());		
		if (userOptional.isPresent()) {
			return modelMapper.map(userOptional.orElseThrow(() -> new NotFoundException(302,"Company found")), Company.class);
		}	
		return modelMapper.map(companyDao.save(user), Company.class);
	}

	@Override
	public Company update(CompanySql user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findByExistId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(CompanySql user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Company> findByLikeName(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findByNumberDocument(String numberDocument) {
		// TODO Auto-generated method stub
		Optional<CompanySql> company = companyDao.findByNumberDocument(numberDocument);
		return company
				.map(companySql ->  companyMapper.convertToCompany(companySql))
				.orElseThrow(() -> new NotFoundException(302,"Company not found"));
	}

	@Override
	public Page<Company> findAllFilter(Pageable pageable, FilterPagination filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompanyByNumberDocument(String numberDocument) {
		// TODO Auto-generated method stub
		Optional<CompanySql> company = companyDao.findByNumberDocument(numberDocument);
		if (company.isPresent())
			return companyMapper.convertToCompany(modelMapper.map(company, CompanySql.class));
		else
			return null;
	}

}
