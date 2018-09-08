package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.DAO.GDPDetailDAO;
import com.zh.DAOImp.GDPDetailDAOImp;
import com.zh.Domain.GDPDetail;

import net.sf.json.JSONArray;

public class Servlet_Click extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 得到DAO对象
		GDPDetailDAO dao = new GDPDetailDAOImp();
		// 得到2016年的数据
		List<GDPDetail> GDPDetails = dao.findByCityName(req.getParameter("cityName"));
		System.out.println(req.getParameter("cityName"));
		
		// 转换成json数据
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		JSONArray obj = JSONArray.fromObject(GDPDetails);
		resp.getWriter().print(obj.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
