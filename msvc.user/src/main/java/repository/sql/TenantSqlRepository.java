package repository.sql;

import core.tenant.domain.Tenant;
import repository.sql.domain.TenantSql;

public interface TenantSqlRepository {
	public Tenant findById(Long id);
	public Tenant save(TenantSql tenant);
}
