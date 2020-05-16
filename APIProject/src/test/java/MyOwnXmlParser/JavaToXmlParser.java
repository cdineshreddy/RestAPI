package MyOwnXmlParser;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JavaToXmlParser {
	
	public void marshalling(Student st) throws JAXBException{
	JAXBContext jc = JAXBContext.newInstance(Student.class);
	Marshaller cm = jc.createMarshaller();
	cm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	//Displays the XML file in the Console
	//Real Conversion of Java to XML
	cm.marshal(st,System.out);
	//Create a new XML file in the Specific path
	cm.marshal(st, new File("StudentData.xml"));
	}

}
