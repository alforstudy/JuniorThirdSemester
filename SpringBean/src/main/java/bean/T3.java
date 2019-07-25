package bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T3 {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		String str = (String)ctx.getBean("timestr");
		System.out.println(str);
		
		Thread.sleep(2000);
		
		str = (String)ctx.getBean("timestr");
		System.out.println(str);
		
		Student stu6 = (Student) ctx.getBean("student6");
		System.out.println(stu6);
		
		ctx.close();
	}
}
