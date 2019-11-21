package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Student;
import dao.StudentDao;
import java.io.IOException;
@WebServlet("/Login")
@SuppressWarnings("serial")


public class Login extends HttpServlet{
	
	static String adminn = "admin";
	static String adminp = "123456";
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter("adminPassword");
        
        if(adminName == adminn && adminPassword == adminp) {
        	resp.sendRedirect("/index.jsp");
        }
        
       
        
	}
}
