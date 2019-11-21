package bean;

public class Student {
    private Integer studentId;
    
    private String studentSchool;
    
    private String studentName;
    private String studentAge;
    private Integer studentSex;
    private String studentCollege;
    public Student() {
    }
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    
    public void setStudentSchool(String studentSchool) {
    	this.studentSchool = studentSchool;
    }
    public String getStudentSchool(String studentSchool) {
    	return studentSchool;
    }
    
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentAge() {
        return studentAge;
    }
    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }
    public Integer getStudentSex() {
        return studentSex;
    }
    public void setStudentSex(Integer studentSex) {
        this.studentSex = studentSex;
    }
    public String getStudentCollege() {
        return studentCollege;
    }
    public void setStudentCollege(String studentCollege) {
        this.studentCollege = studentCollege;
    }
}