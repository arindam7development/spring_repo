package org.arindam._01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing_Application_v2 {

	public static void main(String[] args) {
		//There are different implementing objects / classes of Application Context like AnnotationConfig
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_01.xml");
         Triangle t = (Triangle)context.getBean("triangle");
         t.draw();
         context.close();
	}

}
