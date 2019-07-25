package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

	private String name;
	private int age;
	private Date ctime;

	public Student() {
	}

	public Student(String name, int age, Date ctime) {
		this.name = name;
		this.age = age;
		this.ctime = ctime;
	}

	public void init2() {
		System.out.println("student init ...");
	}

	public void close2() {
		System.out.println("student close ...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String toString() {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ctime);
		return String.format("name=%s, age=%d, time=%s", name, age, time);
	}

}
