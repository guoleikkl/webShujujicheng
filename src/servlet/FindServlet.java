package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Studentb;
import dao.StudentDao;
import dao.StudentDaob;
import java.io.IOException;
import java.util.List;
@WebServlet("/find")
@SuppressWarnings("serial")

public class FindServlet extends HttpServlet{
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        this.doPost(req, resp);
	    }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	 StudentDao studentDao = new StudentDao();
	    	 StudentDaob studentDaob = new StudentDaob();
	    	 int studentId = Integer.parseInt(req.getParameter("studentId"));
	         Student student = studentDao.getStudentById(studentId);
	         Studentb studentb = studentDaob.getStudentById(studentId);
	         if(!student.equals(null) && studentb.equals(null)) {
	        	 req.setAttribute("student", student);
	             req.getRequestDispatcher("find.jsp").forward(req, resp);
	         }
	         else if(!studentb.equals(null) && student.equals(null)) {
	        	 req.setAttribute("student", studentb);
	             req.getRequestDispatcher("find.jsp").forward(req, resp);
	         }
	         else {
	        	 System.out.print("NO");
	         }

	    }
}
