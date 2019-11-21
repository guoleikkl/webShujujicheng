package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Studentb;
import dao.StudentDaob;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListbServlet")
public class ListbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDaob studentDaob = new StudentDaob();
        List<Studentb> studentListb = studentDaob.selectStudent();
        req.setAttribute("studentListb", studentListb);
        req.getRequestDispatcher("listb.jsp").forward(req, resp);
    }
}