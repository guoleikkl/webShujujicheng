package util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DbUtil {
    private static String url = "jdbc:mysql://localhost/schoola?useSSL=FALSE&serverTimezone=UTC";// ���ݿ��ַ
    private static String userName = "root"; // ���ݿ��û���
    private static String passWord = "guolei"; // ���ݿ�����
    private static Connection conn = null;
    /**
     * ������ݿ�����
     *
     * @return
     */
    public static Connection getConnection() {
        if (null == conn) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, userName, passWord);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}