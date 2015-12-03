package com.niit.servlet;

import java.io.IOException;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.niit.action.UsersAction;
import com.niit.model.Message;
import com.niit.model.Users;

/**
 * 用于用户信息处理 http://localhost:8080/项目名称/urlPatterns
 * http://localhost:8080/SLT_Andorid_Parttime/users/users
 * 
 * 注册、登录、忘记密码
 * 
 */
@WebServlet(name = "users", urlPatterns = "/users/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsersServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// ///////
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String action = request.getParameter("action") == null ? "" : request
				.getParameter("action");
		// 1-先获取用户注册信息
		int usersID = request.getParameter("usersID") == null ? 0 : Integer
				.parseInt(request.getParameter("usersID"));
		String usersName = request.getParameter("usersName") == null ? ""
				: request.getParameter("usersName").trim();
		String usersPwd = request.getParameter("usersPwd") == null ? ""
				: request.getParameter("usersPwd").trim();
		String usersInvalitCode = request.getParameter("usersInvalitCode") == null ? ""
				: request.getParameter("usersInvalitCode").trim();
		int usersIsForgot = request.getParameter("usersIsForgot") == null ? 0
				: Integer.parseInt(request.getParameter("usersIsForgot"));
		String usersRegDate = request.getParameter("usersRegDate") == null ? ""
				: request.getParameter("usersRegDate").trim();

		UsersAction op = new UsersAction();

		Users users = new Users();
		users.usersID = usersID;
		users.usersName = usersName;
		users.usersPwd = usersPwd;
		users.usersInvalitCode = usersInvalitCode;
		users.usersIsForgot = usersIsForgot;
		users.usersRegDate = usersRegDate;

		if (action.equals("add")) {// 注册

			// 2-得到用户的新增后的ID
			int id = op.add(users);// 新增数据进入数据库
			// 3-反馈信息给安卓客户端（JSON）
			JSONObject jsonObject;
			if (id > 0) {
				Users model = new Users();
				model = op.findById(id);// 查找到该用户的所有数据
				String data = JSONObject.fromObject(model).toString();
				jsonObject = JSONObject
						.fromObject(new Message(1, "注册成功", data));
			} else {
				jsonObject = JSONObject.fromObject(new Message(0, "注册失败", ""));
			}
			response.getWriter().print(jsonObject.toString());

		} else if (action.equals("validate")) {// 登录验证
			String where = "AND usersName = '" + usersName
					+ " 'AND usersPwd =' " + usersPwd + "'";
			List<Users> lists = op.findWhere(where);// 根据用户名和密码查找符合条件的用户集合
			JSONObject jsonObject;
			if (lists.size() > 0) {// OK
				Users user = lists.get(0);
				String data = JSONObject.fromObject(user).toString();
				jsonObject = JSONObject
						.fromObject(new Message(1, "登录成功", data));
			} else {// no
				jsonObject = JSONObject.fromObject(new Message(0, "登录失败", ""));
			}
			response.getWriter().print(jsonObject.toString());
		} else if (action.equals("forgotpwd")) {// 忘记密码
			// 1-先获取用户名，检查该用户名是否存在
			String where = "AND UsersName ='" + usersName + "'";
			JSONObject jsonObject;
			List<Users> lists = op.findWhere(where);
			if (lists.size() > 0) {
				// 2-根据用户名修改新密码
				Users user = lists.get(0);
				user.usersPwd = usersPwd;
				user.usersIsForgot = usersIsForgot;
				int id = op.edit(user);
				if (id > 0) {
					jsonObject = JSONObject.fromObject(new Message(1, "密码修改成功",
							""));
				} else {
					jsonObject = JSONObject.fromObject(new Message(0, "密码修改失败",
							""));
				}

			} else {
				jsonObject = JSONObject
						.fromObject(new Message(0, "找不到该用户", ""));
			}

			response.getWriter().print(jsonObject.toString());
		} else if (action.equals("mdpwd")) {
			String oldPwd = request.getParameter("usersOldPwd");
			String where = "AND UsersName ='" + usersName + "'"
					+ "And usersPwd='" + oldPwd + "'";
			JSONObject jsonObject;
			List<Users> lists = op.findWhere(where);
			if (lists.size() > 0) {
				// 2-根据用户名修改新密码
				Users user = lists.get(0);
				user.usersPwd = usersPwd;

				int id = op.edit(user);
				if (id > 0) {
					jsonObject = JSONObject.fromObject(new Message(1, "密码修改成功",
							""));
				} else {
					jsonObject = JSONObject.fromObject(new Message(0, "密码修改失败",
							""));
				}

			} else {
				jsonObject = JSONObject.fromObject(new Message(0, "解析失败", ""));
			}

			response.getWriter().print(jsonObject.toString());
		}

	}
}
