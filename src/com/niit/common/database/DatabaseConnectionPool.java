package com.niit.common.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 * 数据库连接池
 */
public final class DatabaseConnectionPool {

	
	 private static final Logger LOG = LoggerFactory
	  .getLogger(DatabaseConnectionPool.class);
	 
	
	 private static final ResourceBundle BUNDLE = ResourceBundle
	 .getBundle("connection");
	 
	private static final String DRIVER = "DRIVER";
	private static final String URL = "URL";
	private static final String USERNAME = "USERNAME";
	private static final String PASSWORD = "PASSWORD";
	private static final String MAX_CONNECTION = "MAX_CONNECTION";
	private static BoneCP pool;

	/**
	 * 开启连接池
	 */
	public static Connection startup() {
		Connection connection;
		try {
			
			Class.forName(BUNDLE.getString(DRIVER));
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(BUNDLE.getString(URL));
			config.setUsername(BUNDLE.getString(USERNAME));
			config.setPassword(BUNDLE.getString(PASSWORD));
			config.setMaxConnectionsPerPartition(Integer.parseInt(BUNDLE.getString(MAX_CONNECTION)));
			pool = new BoneCP(config);
			 connection=pool.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			 LOG.error(e.getMessage(), e);
			throw new DatabaseException(e);
		}
		return connection;
	}

	/**
	 * 关闭连接池
	 */
	public static void shutdown() {
		pool.shutdown();
	}

	/**
	 * @return 数据库连接
	 */
	public static Connection getConnection() {
		Connection connection;
		try {
			if(pool == null){
				connection =startup();
			 }
			else {
				connection = pool.getConnection();
			}
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			 LOG.error(e.getMessage(), e);
			throw new DatabaseException(e);
		}
	}

}
