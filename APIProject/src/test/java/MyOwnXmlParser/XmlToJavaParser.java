package MyOwnXmlParser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlToJavaParser {
	
	public void unmarshalling(String fileName) throws JAXBException{
		
		File f=new File(fileName);
		JAXBContext jc=JAXBContext.newInstance(Student.class);
		Unmarshaller cum =jc.createUnmarshaller();
		Student s=(Student)cum.unmarshal(f);
		System.out.println(s);
	}

}
