package MyOwnXmlParser;

import javax.xml.bind.JAXBException;

public class TestParser {
	
	public static void main(String[] args) throws JAXBException {
		
		/*
		 * Student s=new Student("Dinesh","Male",3,90);
		 * JavaToXmlParser jp=new JavaToXmlParser(); 
		 * jp.marshalling(s);
		 */
		
		String fileName="StudentData.xml";
		XmlToJavaParser xp=new XmlToJavaParser();
		xp.unmarshalling(fileName);
		
	}
	
	
}
