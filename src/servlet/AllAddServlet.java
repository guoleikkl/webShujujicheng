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
@WebServlet("/add")
@SuppressWarnings("serial")
public class AllAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String studentSchool = req.getParameter("studentSchool");
        if(studentSchool.equals("a")) {
        	Student student = new Student();
        	String studentCollege = req.getParameter("studentCollege");
        	String studentName = req.getParameter("studentName");
        	String studentAge = req.getParameter("studentAge");
        	int studentSex = Integer.parseInt(req.getParameter("studentSex"));
        	int studentId = Integer.parseInt(req.getParameter("studentId"));
        
        	student.setStudentCollege(studentCollege);
        	student.setStudentName(studentName);
        	student.setStudentAge(studentAge);
        	student.setStudentSex(studentSex);
        	student.setStudentId(studentId);
        	StudentDao studentDao = new StudentDao();
        	studentDao.addStudent(student);
        }else {
        	Studentb studentb = new Studentb();
        	String studentCollege = req.getParameter("studentCollege");
        	String studentName = req.getParameter("studentName");
        	String studentAge = req.getParameter("studentAge");
        	int studentSexx = Integer.parseInt(req.getParameter("studentSex"));
        	String studentSex = null;
        	int studentId = Integer.parseInt(req.getParameter("studentId"));
        	
        	if(studentSexx == 0) {
        		studentSex = "Å®";
        	}else {
        		studentSex = "ÄÐ";
        	}
        
        	studentb.setStudentCollege(studentCollege);
        	studentb.setStudentName(studentName);
        	studentb.setStudentAge(studentAge);
        	studentb.setStudentSex(studentSex);
        	studentb.setStudentId(studentId);
        	StudentDaob studentDaob = new StudentDaob();
        	studentDaob.addStudent(studentb);
        }
        
        req.getRequestDispatcher("").forward(req, resp);
    }
}


