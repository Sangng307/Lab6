package lab6.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.Videodao;
@WebServlet("/random")
public class bai4_1 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/bai4_1.jsp");
		requestDispatcher.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Videodao vdao = new Videodao();
			req.setAttribute("videos", vdao.random10Video());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Lỗi: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/bai4_1.jsp").forward(req, resp);
	}
}
