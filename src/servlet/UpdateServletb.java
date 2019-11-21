package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Studentb;
import dao.StudentDaob;
import java.io.IOException;
@WebServlet("/updateb")
@SuppressWarnings("serial")
public class UpdateServletb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        StudentDaob studentDaob = new StudentDaob();
        Studentb studentb = studentDaob.getStudentById(studentId);
        req.setAttribute("student", studentb);
        req.getRequestDispatcher("updateb.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Studentb studentb = new Studentb();
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        String studentCollege = req.getParameter("studentCollege");
        String studentName = req.getParameter("studentName");
        String studentAge = req.getParameter("studentAge");
        int studentSexx = Integer.parseInt(req.getParameter("studentSex"));
        String studentSex = null;
        if(studentSexx == 0) {
    		studentSex = "Å®";
    	}else {
    		studentSex = "ÄÐ";
    	}
        studentb.setStudentId(studentId);
        studentb.setStudentCollege(studentCollege);
        studentb.setStudentName(studentName);
        studentb.setStudentAge(studentAge);
        studentb.setStudentSex(studentSex);
        StudentDaob studentDaob = new StudentDaob();
        studentDaob.updateStudent(studentb);
        req.getRequestDispatcher("").forward(req, resp);
    }
}