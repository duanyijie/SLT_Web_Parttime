package com.niit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.niit.action.JobcollectAction;
import com.niit.model.Jobcollect;
import com.niit.model.Message;
import com.sun.mail.handlers.message_rfc822;

/**
 * 用户收藏信息处理
 * 
 */
@WebServlet(name = "Jobcollect", urlPatterns = "/Jobcollect/Jobcollect")
public class JobCollectServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public JobCollectServlet() {
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
	 * PSOT方法
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String action = request.getParameter("action") == null ? "" : request
				.getParameter("action");
		int jobCollectID = request.getParameter("jobCollectID") == null ? 0
				: Integer.parseInt(request.getParameter("jobCollectID"));
		String jobCollectDate = request.getParameter("jobCollectDate") == null ? ""
				: request.getParameter("jobCollectDate").trim();
		int usersID = request.getParameter("usersID") == null ? 0 : Integer
				.parseInt(request.getParameter("usersID"));
		int jobID = request.getParameter("jobID") == null ? 0 : Integer
				.parseInt(request.getParameter("jobID"));
		JobcollectAction op = new JobcollectAction();
		Jobcollect jobcollect = new Jobcollect();
		jobcollect.jobCollectID = jobCollectID;
		jobcollect.jobCollectDate = jobCollectDate;
		jobcollect.usersID = usersID;
		jobcollect.jobID = jobID;

		if (action.equals("add")) {// 添加收藏
			int id = op.add(jobcollect);
			JSONObject jsonObject;
			if (id > 0) {
				jsonObject = JSONObject
						.fromObject(new Message(1, "成功添加收藏", ""));
			} else {
				jsonObject = JSONObject
						.fromObject(new Message(0, "添加收藏失败", ""));
			}
			response.getWriter().print(jsonObject.toString());

		} else if (action.equals("list")) {// 展示个人收藏列表
			int pagenum = request.getParameter("page") == null ? 1 : Integer
					.parseInt(request.getParameter("page"));

			List<Jobcollect> lists = op.findByRange((pagenum - 1) * pageSize,
					pageSize, usersID);
			
			JSONArray array = JSONArray.fromObject(lists);
			String data = array.toString();
			JSONObject jsonObject;
			
			jsonObject = JSONObject.fromObject(new Message(1, "更新了"
					+ lists.size() + "信息", data));
			response.getWriter().print(jsonObject.toString());
		}

	}

}
