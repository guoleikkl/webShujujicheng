package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Studentb;
import util.DbUtilb;
public class StudentDaob {
    /**
     * 所有学生信息
     *
     * @return
     */
    public List<Studentb> selectStudent() {
        List<Studentb> studentListb = new ArrayList<>();
        Connection conn = DbUtilb.getConnection();
        String sql = "select * from studentinformation";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Studentb studentb = new Studentb();
                studentb.setStudentId(rst.getInt("studentid"));
                studentb.setStudentName(rst.getString("studentname"));
                studentb.setStudentAge(rst.getString("studentage"));
                studentb.setStudentSex(rst.getString("studentsex"));
                studentb.setStudentCollege(rst.getString("studentcollege"));
                studentListb.add(studentb);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentListb;
    }
    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    public boolean addStudent(Studentb studentb) {
        String sql = "INSERT INTO student(studentname,studentage,studentsex,studentcollege,studentid) VALUES(?,?,?,?,?);";
        Connection conn = DbUtilb.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, studentb.getStudentName());
            pst.setString(2, studentb.getStudentAge());
            pst.setString(3, studentb.getStudentSex());
            pst.setString(4, studentb.getStudentCollege());
            pst.setInt(5, studentb.getStudentId());
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
    public boolean updateStudent(Studentb studentb) {
        String sql = "UPDATE student set studentname=?,studentAge=?,studentsex=?,studentCollege=? WHERE studentid=?";
        Connection conn = DbUtilb.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, studentb.getStudentName());
            pst.setString(2, studentb.getStudentAge());
            pst.setString(3, studentb.getStudentSex());
            pst.setString(4, studentb.getStudentCollege());
            pst.setInt(5, studentb.getStudentId());
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
        String sql = "delete from student where studentid = ?";
        Connection conn = DbUtilb.getConnection();
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
    public Studentb getStudentById(int studentId) {
        Connection conn = DbUtilb.getConnection();
        String sql = "select * from student where studentid = " + studentId;
        Studentb student = new Studentb();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                student.setStudentId(rst.getInt("studentid"));
                student.setStudentName(rst.getString("studentname"));
                student.setStudentAge(rst.getString("studentAge"));
                student.setStudentSex(rst.getString("studentsex"));
                student.setStudentCollege(rst.getString("studentCollege"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}