package lab6.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.Videodao;
import edu.poly.model.User;
import edu.poly.utils.JpaUtils;




@WebServlet("/findFavoritesNamed")
public class bai3_2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/bai2_1.jsp");
		requestDispatcher.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String method = req.getMethod();
    	if(method.equalsIgnoreCase("POST")) {
    		try {
				EntityManager eManager = JpaUtils.getEntityManager();
				Videodao vdao = new Videodao();
				String id = req.getParameter("username");
				if(id.equals("")) {
					req.setAttribute("message", "khong duoc bo trong nghe chua!");
				}else {
					User user = eManager.find(User.class, id);
					req.setAttribute("user", user);
					req.setAttribute("video", vdao.findVideoFavoriteByUserIDNamed(id));
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				req.setAttribute("error", "Loi: " + e.getMessage());
			}
    	}
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/bai2_1.jsp");
		requestDispatcher.forward(req, resp);
    }
}