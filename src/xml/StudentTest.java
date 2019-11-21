package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;
import bean.Student;


public class StudentTest {
	
	public static void main(String[] args) throws ParseException,SAXException,IOException, ParserConfigurationException{
		 SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		 
		 SAXParser saxParser = parserFactory.newSAXParser();
		 
		 StudentHandler handler = new StudentHandler();
		 saxParser.parse(
				 Thread.currentThread().getContextClassLoader().getResourceAsStream("/xml/student.xml"),
				 handler
				 );
	
	
	List<Student> studentList = handler.getStudentList();
	studentList.forEach(e->System.out.println(e.getStudentName()+"--->"+e.getStudentAge()));
	}

}
