package bean;

import java.util.Date;

public class Factory2 {

	public Student getStudent(String name, int age, Date ctime) {
		System.out.println("Factory2.getStudent");
		Student stu = new Student();
		stu.setName(name);
		stu.setAge(age);
		stu.setCtime(ctime);
		return stu;
	}
}
