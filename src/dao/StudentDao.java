package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Student;
import util.DbUtil;
public class StudentDao {
    /**
     * 所有学生信息
     *
     * @return
     */
    public List<Student> selectStudent() {
        List<Student> studentList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from student";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Student student = new Student();
                student.setStudentId(rst.getInt("student_id"));
                student.setStudentSchool("A");
                student.setStudentName(rst.getString("student_name"));
                student.setStudentAge(rst.getString("student_age"));
                student.setStudentSex(rst.getInt("student_sex"));
                student.setStudentCollege(rst.getString("student_college"));
                studentList.add(student);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO student(student_name,student_age,student_sex,student_college,student_id) VALUES(?,?,?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, student.getStudentName());
            pst.setString(2, student.getStudentAge());
            pst.setInt(3, student.getStudentSex());
            pst.setString(4, student.getStudentCollege());
            pst.setInt(5, student.getStudentId());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    public boolean updateStudent(Student student) {
        String sql = "UPDATE student set student_name=?,student_Age=?,student_sex=?,student_College=? WHERE student_id=?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, student.getStudentName());
            pst.setString(2, student.getStudentAge());
            pst.setInt(3, student.getStudentSex());
            pst.setString(4, student.getStudentCollege());
            pst.setInt(5, student.getStudentId());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 删除学生信息
     *
     * @param studentId
     * @return
     */
    public boolean deleteStudent(int studentId) {
        String sql = "delete from student where student_id = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, studentId);
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 根据id查询学生
     *
     * @param studentId
     * @return
     */
    public Student getStudentById(int studentId) {
        Connection conn = DbUtil.getConnection();
        String sql = "select * from student where student_id = " + studentId;
        Student student = new Student();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                student.setStudentId(rst.getInt("student_id"));
                student.setStudentName(rst.getString("student_name"));
                student.setStudentAge(rst.getString("student_Age"));
                student.setStudentSex(rst.getInt("student_sex"));
                student.setStudentCollege(rst.getString("student_College"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}