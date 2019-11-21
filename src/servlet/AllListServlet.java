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


@WebServlet("/AllListServlet")
@SuppressWarnings("serial")
public class AllListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();
        StudentDaob studentDaob = new StudentDaob();
        List<Student> studentList = studentDao.selectStudent();
        List<Studentb> studentListb = studentDaob.selectStudent();
        
        
        req.setAttribute("studentList", studentList);
        req.setAttribute("studentListb", studentListb);
        req.getRequestDispatcher("listall.jsp").forward(req, resp);
    }
}