package org.arindam._01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing_Application_v3 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_02.xml");
        Employee e = (Employee)context.getBean("employee");
        e.display();
        context.close();

	}

}
