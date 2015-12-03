package com.niit.dao;

import java.sql.Connection;
import java.util.List;

import com.niit.common.database.access.DataAccess;
import com.niit.common.database.convert.IntegerConverter;
import com.niit.convert.UsersConvert;
import com.niit.model.Users;

/**
 * 数据库操作层。直接完成sql语句操作
 * @author Admin
 *
 */
public class UsersDao extends DataAccess {

	public UsersDao(Connection conn) {
		super(conn);
	}

	/**
	 * 新增整个用户对象
	 * 
	 * @return
	 */
	public int add(Users model) {
		String sql = "INSERT INTO users (UsersName,UsersPwd,UsersInvalitCode,UsersIsForgot,UsersRegDate) Values (?,?,?,?,?)";
		return super.insert(sql, new IntegerConverter(), model.usersName,
				model.usersPwd, model.usersInvalitCode, model.usersIsForgot,
				model.usersRegDate);
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public int edit(Users model) {
		String sql = "UPDATE users SET UsersName = ?,UsersPwd=?,UsersInvalitCode=?,UsersIsForgot=?,UsersRegDate=? WHERE USERSID = ?";
		return super.update(sql, model.usersName, model.usersPwd,
				model.usersInvalitCode, model.usersIsForgot,
				model.usersRegDate, model.usersID);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public int delete(int usersID) {
		String sql = "DELETE FORM users WHERE usersid = ?";
		return super.update(sql, usersID);
	}

	/**
	 * 查找所有
	 * 
	 * @return
	 */
	public List<Users> findAll() {
		String sql = "SELECT * FROM users";
		return super.queryForList(sql, new UsersConvert());
	}

	/**
	 * 根据条件完成查找
	 * 
	 * @return
	 */
	public List<Users> findWhere(String where) {
		String sql = "SELECT * FROM users WHERE 1=1  " + where;// ? 1=1 ?
		return super.queryForList(sql, new UsersConvert());
	}

	/**
	 * 分页
	 * 
	 * @param start
	 *            :开始的记录
	 * @param size
	 *            ：读取的记录数
	 * @return
	 * 
	 *         在主键不连续的情况下，请读取第5-10行的记录 1-select * from users limit 4,6; 2-select
	 *         top 10 * from users where userID not in (select top 4 userid from
	 *         users);
	 */
	public List<Users> findByRange(int start, int size) {
		String sql = "SELECT * FROM users limit ?,?";
		return super.queryForList(sql, new UsersConvert(), start, size);
	}

	/**
	 * 查找单个对象
	 * 
	 * @return
	 */
	public Users findById(int usersID) {
		String sql = "SELECT * FROM users where usersid = ?";
		return super.queryForObject(sql, new UsersConvert(), usersID);
	}

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getCount() {
		String sql = "SELECT COUNT(*) FROM users";
		return super.queryForObject(sql, new IntegerConverter());
	}

}
