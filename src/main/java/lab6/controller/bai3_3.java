package lab6.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.Videodao;

@WebServlet("/findDay")
public class bai3_3 extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/bai3_3.jsp");
		requestDispatcher.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Videodao vdao = new Videodao();
			String min = req.getParameter("mindate");
			String max = req.getParameter("maxdate");
			if (min.equals("") || max.equals("")) {
				req.setAttribute("message", "Vui lòng chọn ngày tháng nằm!");
			} else {
				req.setAttribute("videos", vdao.findInRange(min, max));
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/bai3_3.jsp").forward(req, resp);
	}
}
