package lab6.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.Videodao;

@WebServlet("/findByMonth")
public class bai3_4 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/bai3_4.jsp");
		requestDispatcher.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String[] values = req.getParameterValues("months");
			List<Integer> months = new ArrayList<Integer>();
			for (String month : values) {
				months.add(Integer.valueOf(month));
			}
			Videodao vdao = new Videodao();
			req.setAttribute("videos", vdao.findInMonths(months));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/bai3_4.jsp").forward(req, resp);
	}
}
