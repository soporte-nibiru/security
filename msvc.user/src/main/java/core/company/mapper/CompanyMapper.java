package core.company.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import core.company.domain.Company;
import repository.sql.domain.CompanySql;

@Mapper
public interface CompanyMapper {
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "tenant", target = "tenants") // Mapeo de Tenant a TenantSql
    CompanySql toCompanySql(Company company);

    @Mapping(source = "tenants", target = "tenant") // Mapeo de TenantSql a Tenant
    Company toCompany(CompanySql companySql);
}
