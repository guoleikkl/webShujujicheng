package xml_dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class Dome {
	
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        xmlTest();
    }
    public static void xmlTest() throws ParserConfigurationException, SAXException, IOException {
        //����һ��DOM��������������;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //ͨ���������󴴽�DOM������
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //�����ĵ�
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("student.xml");
        Document doc = documentBuilder.parse(resourceAsStream);//doc ��Ϊ��״�ṹ�Ĵ洢����,���ڴ���;
 
        ArrayList<Student> studentList = new ArrayList<>();
        NodeList XMLstudentlist = doc.getElementsByTagName("stu");
        Student student = null;
        for (int i = 0; i <XMLstudentlist.getLength(); i++) {
            student = new Student();
            //��ȡ����ֵ
            //String s_id = XMLstudentlist.item(i).getAttributes().getNamedItem("person_id").getNodeValue();
            //student.setStudentId(Integer.parseInt(s_id));
            NodeList childNodes = XMLstudentlist.item(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node children_node = childNodes.item(j);
                String node_name = children_node.getNodeName();
                if ("name".equals(node_name)){
                    //���ı�Ҳ����һ���ڵ㣬<name>zy</name> ��zy�����ڵ㣻children_node.getFirstChild()��ʾ��ȡzy����ڵ㣻
                    //zy.getNodeValue() ��ȡ��ֵ����zy;
                    String s_name = children_node.getFirstChild().getNodeValue();
                    student.setStudentName(s_name);
                }else if ("age".equals(node_name)){
                    String s_age = children_node.getFirstChild().getNodeValue();
                    student.setStudentAge(s_age);
                }
            }
            studentList.add(student);
        }
        studentList.forEach((p)->System.out.println(p));
    }
}