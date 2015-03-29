/**
 * 
 */
package org.arindam._02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ARINDAM
 *
 */
public class MainApplication_V2 {

	/**
	 * Coding through interfaces ; Here my Main Application is independent of what object bean 
	 * i am using . Later I can introduce my other shapes , I don't have to change my Application file . 
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_05.xml");
		Shape shape = (Shape)context.getBean("circle");
		shape.draw();
	    context.close();
	}

}
