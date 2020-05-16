package MyOwnJsonParser;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JavaToJsonParser {
	
	public void marshalling(Employee obj) {
		ObjectMapper m=new ObjectMapper();
	
			try {
				m.writeValue(new File("EmployeeData.json"), obj);
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
