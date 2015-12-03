package com.niit.action;

import java.util.ArrayList;
import java.util.List;

import com.niit.common.database.DatabaseTransaction;
import com.niit.dao.UsersDao;
import com.niit.model.Users;
import com.niit.service.UsersService;

public class UsersAction {

	/**
	 * 新增整个用户对象
	 * 
	 * @return
	 */
	public int add(Users model) {
		int id = 0;
		// Users model2 = new Users();
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			id = service.add(model);
			// service.add(model2);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}

		return id;
	}

	public int edit(Users model) {
		int id = 0;
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			id = service.edit(model);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}

		return id;
	}

	public int delete(int usersID) {
		int id = 0;
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			id = service.delete(usersID);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}

		return id;
	}

	/**
	 * 查找所有
	 * 
	 * @return
	 */
	public List<Users> findAll() {
		List<Users> lists = new ArrayList<Users>();
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			lists = service.findAll();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return lists;
	}

	/**
	 * 根据条件完成查找
	 * 
	 * @return
	 */
	public List<Users> findWhere(String where) {
		List<Users> lists = new ArrayList<Users>();
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			lists = service.findWhere(where);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return lists;
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
		List<Users> lists = new ArrayList<Users>();
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			lists = service.findByRange(start, size);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return lists;
	}

	/**
	 * 查找单个对象
	 * 
	 * @return
	 */
	public Users findById(int usersID) {
		Users users = new Users();
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			users = service.findById(usersID);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return users;
	}
	
	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getCount() {
		int count = 0;
		DatabaseTransaction trans = new DatabaseTransaction(true);

		try {
			UsersService service = new UsersService(trans);
			count = service.getCount();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			trans.close();
		}
		return count;
	}
}
