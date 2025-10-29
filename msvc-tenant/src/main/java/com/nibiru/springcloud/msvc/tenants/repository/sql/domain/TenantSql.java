package com.nibiru.springcloud.msvc.tenants.repository.sql.domain;

import java.io.Serializable;

import jakarta.persistence.*;



public class TenantSql implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id")
	   private Long id;
}
