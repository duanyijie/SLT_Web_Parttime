package com.niit.common.service;

import java.sql.Connection;

import com.niit.common.database.DatabaseTransaction;

public abstract class BaseService {
	
	private DatabaseTransaction trans;
	
	protected BaseService(DatabaseTransaction trans) {
		this.trans = trans;
	}
	
	protected BaseService() { }

	protected DatabaseTransaction getTransaction() {
		return trans;
	}
	
	protected Connection getConnection() {
		return trans.getConnection();
	}

}

