package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Student;
import dao.StudentDao;
import java.io.IOException;
import java.util.List;
@WebServlet("/ListServlet")
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.selectStudent();
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}