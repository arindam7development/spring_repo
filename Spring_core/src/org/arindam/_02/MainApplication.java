/**
 * 
 */
package org.arindam._02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ARINDAM
 *
 */
public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_04.xml");
		Employee_v2 e = (Employee_v2)context.getBean("employee");
		e.display();
	    context.close();
	}

}
