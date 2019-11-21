package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDaob;
import java.io.IOException;
@WebServlet("/deleteb")
@SuppressWarnings("serial")
public class DeleteServletb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        StudentDaob studentDaob = new StudentDaob();
        studentDaob.deleteStudent(studentId);
        req.getRequestDispatcher("").forward(req, resp);
    }
}