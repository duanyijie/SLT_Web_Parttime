package com.niit.service;

import java.util.List;

import com.niit.common.database.DatabaseTransaction;
import com.niit.common.database.convert.IntegerConverter;
import com.niit.common.service.BaseService;
import com.niit.convert.UsersConvert;
import com.niit.dao.UsersDao;
import com.niit.model.Users;

/**
 * 服务层。相当于以前的BLL层，专门用于调用dao
 * @author Admin
 *
 */
public class UsersService extends BaseService{

	public UsersService(){
		super();
	}
	
	public UsersService(DatabaseTransaction trans) {
		super(trans);
	}
	
	/**
	 * 新增整个用户对象
	 * 
	 * @return
	 */
	public int add(Users model) {
		UsersDao dao = new UsersDao(getConnection());
		return dao.add(model);
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public int edit(Users model) {
		UsersDao dao = new UsersDao(getConnection());
		return dao.edit(model);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public int delete(int usersID) {
		UsersDao dao = new UsersDao(getConnection());
		return dao.delete(usersID);
	}

	/**
	 * 查找所有
	 * 
	 * @return
	 */
	public List<Users> findAll() {
		UsersDao dao = new UsersDao(getConnection());
		return dao.findAll();
	}

	/**
	 * 根据条件完成查找
	 * 
	 * @return
	 */
	public List<Users> findWhere(String where) {
		UsersDao dao = new UsersDao(getConnection());
		return dao.findWhere(where);
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
		UsersDao dao = new UsersDao(getConnection());
		return dao.findByRange(start, size);
	}

	/**
	 * 查找单个对象
	 * 
	 * @return
	 */
	public Users findById(int usersID) {
		UsersDao dao = new UsersDao(getConnection());
		return dao.findById(usersID);
	}

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getCount() {
		UsersDao dao = new UsersDao(getConnection());
		return dao.getCount();
	}
	
}
