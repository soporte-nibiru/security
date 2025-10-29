package repository.sql;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import core.company.domain.Company;
import core.user.domain.input.FilterPagination;
import repository.sql.domain.CompanySql;

public interface CompanySqlRepository {
	public List<CompanySql> findAll();
    public Company findById(Long id);
	public Company save(CompanySql user);
	public Company update(CompanySql user);
	public boolean findByExistId(Long id);
	public void delete(CompanySql user);
	public List<Company> findByLikeName(String query);
	public Company findByNumberDocument(String numberDocument);
	public Company getCompanyByNumberDocument(String numberDocument);
	Page<Company> findAllFilter(Pageable pageable, FilterPagination filter);
}
