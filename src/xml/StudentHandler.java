package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import bean.Student;
import java.util.*;


public class StudentHandler extends DefaultHandler{
	private List<Student> studentList;
	private Student student;
	private String tag;
	
	public void startDocument() throws SAXException {
		studentList = new ArrayList<>();
	}
	
	
	public void startElement(String uri,String localName,String qName,Attributes attributes )throws SAXException{
		if (null != qName) {
			tag = qName;
		}
		
		if (null != qName && qName.equals("student")) {
			student = new Student();
		}
	}
	
	public void characters(char[] ch,int start,int length)throws SAXException{
		String s = new String(ch,start,length);
		if(null != tag && tag.equals("name")) {
			student.setStudentName(s);
		}else if(null != tag && tag.equals("age")) {
			student.setStudentAge(s);
		}
	}
	
	
	public void endElement(String uri,String localName,String qName)throws SAXException{
		if (qName.equals("student")) {
			studentList.add(student);
		}
		tag = null;
	}
	
	public void endDocument() throws SAXException{
		System.out.println("接收文件尾的通知。");
	}
	
	public List<Student> getStudentList(){
		return studentList;
	}



	
}
