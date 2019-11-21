package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Student;
import dao.StudentDao;
import java.io.IOException;
//@WebServlet("/add")
@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
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
        req.getRequestDispatcher("").forward(req, resp);
    }
}

