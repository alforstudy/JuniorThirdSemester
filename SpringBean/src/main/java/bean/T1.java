package bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T1 {

	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Student stu1 = (Student)ctx.getBean("student1");
		System.out.println(stu1);
		Student stu2 = (Student)ctx.getBean("student1");
		System.out.println(stu2);
		System.out.println(stu1 == stu2);
		
		
		Student stu3 = (Student)ctx.getBean("student2");
		System.out.println(stu3);
		Thread.sleep(2000);
		Student stu4 = (Student)ctx.getBean("student2");
		System.out.println(stu4);
		System.out.println(stu3 == stu4);
		
		ctx.close();
	}
}
