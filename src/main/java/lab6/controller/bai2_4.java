package lab6.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.Videodao;
@WebServlet("/findLikeOrNot")
public class bai2_4 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/bai2_4.jsp");
		requestDispatcher.forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				Videodao vdao = new Videodao();
				boolean favorite = Boolean.parseBoolean(req.getParameter("favorite"));
				req.setAttribute("videos", vdao.findVideoEmpty(favorite));
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", "Lỗi: " + e.getMessage());
			}
		}
		req.getRequestDispatcher("/views/bai2_4.jsp").forward(req, resp);
	}
}
