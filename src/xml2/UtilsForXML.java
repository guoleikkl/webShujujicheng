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
	 * 需要一个方法来创建DOM4j德 XML解析器并返回一个Document对象
	 */
	public static Document getDocument(String xmlPath) throws Exception {
		SAXReader reader = new SAXReader();
		//将XML文件路径传给Document对象并返回其实例dom
		Document dom = reader.read(new File(xmlPath));
		return dom;
	}
	
	/**
	 * 需要一个方法来将更新后的document对象写入到XML文件中去
	 * @throws Exception 
	 */
	public static void writeToXML(Document dom ,String xmlPath) throws Exception{
		
		//首先创建样式和输出流
		OutputFormat format = new OutputFormat().createPrettyPrint();
		OutputStream out = new FileOutputStream(xmlPath);
		XMLWriter writer = new XMLWriter(out,format);
		
		//写入之后关闭流
		writer.write(dom);
		writer.close();
	}
}
  
