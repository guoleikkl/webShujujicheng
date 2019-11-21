package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Student;
import dao.StudentDao;
import java.io.IOException;
@WebServlet("/update")
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.getStudentById(studentId);
        req.setAttribute("student", student);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Student student = new Student();
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        String studentCollege = req.getParameter("studentCollege");
        String studentName = req.getParameter("studentName");
        String studentAge = req.getParameter("studentAge");
        int studentSex = Integer.parseInt(req.getParameter("studentSex"));
        student.setStudentId(studentId);
        student.setStudentCollege(studentCollege);
        student.setStudentName(studentName);
        student.setStudentAge(studentAge);
        student.setStudentSex(studentSex);
        StudentDao studentDao = new StudentDao();
        studentDao.updateStudent(student);
        req.getRequestDispatcher("").forward(req, resp);
    }
}