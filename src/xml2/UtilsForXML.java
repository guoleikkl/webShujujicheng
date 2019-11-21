package xml2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
 
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
 
public class UtilsForXML {
	
	/**
	 * ��Ҫһ������������DOM4j�� XML������������һ��Document����
	 */
	public static Document getDocument(String xmlPath) throws Exception {
		SAXReader reader = new SAXReader();
		//��XML�ļ�·������Document���󲢷�����ʵ��dom
		Document dom = reader.read(new File(xmlPath));
		return dom;
	}
	
	/**
	 * ��Ҫһ�������������º��document����д�뵽XML�ļ���ȥ
	 * @throws Exception 
	 */
	public static void writeToXML(Document dom ,String xmlPath) throws Exception{
		
		//���ȴ�����ʽ�������
		OutputFormat format = new OutputFormat().createPrettyPrint();
		OutputStream out = new FileOutputStream(xmlPath);
		XMLWriter writer = new XMLWriter(out,format);
		
		//д��֮��ر���
		writer.write(dom);
		writer.close();
	}
}
  
