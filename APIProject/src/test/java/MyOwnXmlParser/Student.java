package MyOwnXmlParser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class Student {
	
	String name, gender;
	int rollNum;
	double marks;
	
	public Student(String name, String gender, int rollNum, double marks) {
		super();
		this.name=name;
		this.gender=gender;
		this.rollNum=rollNum;
		this.marks=marks;
		
	}
	@XmlElement
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@XmlElement
	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	@XmlElement
	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public Student() {
		
	}
	
	@Override
	public String toString() {
		return "Data is :"+ name +" "+ rollNum +" "+gender +" "+ marks;
	}

}
