package com.niit.convert;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.common.database.convert.ResultConverter;
import com.niit.model.Users;

/**
 * 将数据库查找出来的ResultSet转变为Users对象
 * @author Admin
 *
 */
public class UsersConvert implements ResultConverter<Users>{

	@Override
	public Users convert(ResultSet rs) throws SQLException {
		Users users = new Users();
		users.usersID = rs.getInt(1);
		users.usersName = rs.getString(2);
		users.usersPwd = rs.getString(3);
		users.usersInvalitCode = rs.getString(4);
		users.usersIsForgot = rs.getInt(5);
		users.usersRegDate = rs.getString(6);
		
		return users;
	}

}
