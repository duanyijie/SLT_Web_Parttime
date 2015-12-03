package com.niit.servlet;

import java.io.IOException;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.Converter;

import com.niit.action.JoblistAction;
import com.niit.model.Joblist;
import com.niit.model.Message;

/**
 * 用户处理兼职信息
 * 
 * http://localhost:8080/SLT_Andorid_Parttime/JobList/JobList
 */
@WebServlet(name = "Joblist", urlPatterns = "/Joblist/Joblist")
public class JobListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public JobListServlet() {
		super();
	}

	/**
	 * GET方法
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * POST方法
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action") == null ? "" : request
				.getParameter("action");

		int jobID = request.getParameter("jobID") == null ? 0 : Integer
				.parseInt(request.getParameter("jobID"));

		JoblistAction op = new JoblistAction();

		if (action.equals("list")) {// 分页查找
			JSONObject jsonObject;
			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));

			List<Joblist> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize);
			JSONArray array = JSONArray.fromObject(lists);
			String data = array.toString();
			jsonObject = JSONObject.fromObject(new Message(1, "更新了"
					+ lists.size() + "信息", data));
			response.getWriter().print(jsonObject.toString());
		} else if (action.equals("view")) {// 查看具体的兼职信息
			Joblist job = op.findById(jobID);
			JSONObject jsonObject;
			if (job != null) {
				String data = JSONObject.fromObject(job).toString();
				jsonObject = JSONObject.fromObject(new Message(1, "找到了该信息",
						data));
			} else {
				jsonObject = JSONObject
						.fromObject(new Message(0, "找不到该信息", ""));
			}
			response.getWriter().print(jsonObject.toString());
		}
	}

}
