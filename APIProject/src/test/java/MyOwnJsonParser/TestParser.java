package MyOwnJsonParser;

import java.io.File;

public class TestParser {
	
	public static void javatojson() {
			
		  Employee m=new Employee("Dinesh",28,20000); 
		  JavaToJsonParser jobj=new JavaToJsonParser();
		  jobj.marshalling(m); 
		  System.out.println("Pass");
		
	}
	
	public static void jsontojava() {
		
		String fileName="EmployeeData.json";
		File file=new File(fileName);
		JsonToJavaParser jobj=new JsonToJavaParser();
		Employee eobj=jobj.unmarshalling(file, Employee.class);
		System.out.println(eobj);
	}
	
	public static void main(String[] args) {
		
		TestParser.jsontojava();	
		
	}

}
