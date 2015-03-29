package org.arindam._03;

import org.arindam._03.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ARINDAM
 *
 */
public class MainApplication_v3 {

	/**
	 * Coding through interfaces ; Here my Main Application is independent of what object bean 
	 * i am using . Later I can introduce my other shapes , I don't have to change my Application file . 
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_06.xml");
		//context.registerShutdownHook();
		Shape shape = (Shape)context.getBean("circle");
		shape.draw();
	    //context.close();
	}

}