package repository.sql.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import core.exception.NotFoundException;
import core.tenant.domain.Tenant;
import repository.sql.TenantSqlRepository;
import repository.sql.dao.TenantSqlDao;
import repository.sql.domain.TenantSql;

public class TenantSqlAdapter implements TenantSqlRepository {

	private TenantSqlDao tenantDao;
	private ModelMapper modelMapper;
	
	
	public TenantSqlAdapter(TenantSqlDao tenantDao, ModelMapper modelMapper) {
		this.tenantDao = tenantDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Tenant findById(Long id) {
		// TODO Auto-generated method stub
		Optional<TenantSql> tenant = tenantDao.findById(id);
		return tenant
				.map(tenantSql ->  modelMapper.map(tenantSql, Tenant.class))
				.orElseThrow(() -> new NotFoundException(302,"tenant not found"));
	}

	@Override
	public Tenant save(TenantSql tenant) {
		// TODO Auto-generated method stub
		Optional<TenantSql> tenantOptional = tenantDao.findByName(tenant.getName());		
		if (tenantOptional.isPresent()) {
			return modelMapper.map(tenantOptional.orElseThrow(() -> new NotFoundException(302,"Tenant found")), Tenant.class);
		}	
		return modelMapper.map(tenantDao.save(tenant), Tenant.class);
	}

}
