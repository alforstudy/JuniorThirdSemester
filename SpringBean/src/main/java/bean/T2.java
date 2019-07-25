package bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T2 {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Student stu = (Student) ctx.getBean("student3");
		System.out.println(stu);
				
		Student stu2 = ctx.getBean(Student.class);
		System.out.println(stu2);
		
		Student stu4 = (Student) ctx.getBean("student4");
		System.out.println(stu4);
		
		Student stu5 = (Student) ctx.getBean("student5");
		System.out.println(stu5);
		
		Student stu6 = (Student) ctx.getBean("student6");
		System.out.println(stu6);

		ctx.close();
	}
}
