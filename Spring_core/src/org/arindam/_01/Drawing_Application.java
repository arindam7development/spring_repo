/**
 * 
 */
package org.arindam._01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author ARINDAM
 *
 */
@SuppressWarnings("deprecation")
public class Drawing_Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring_01.xml"));
         Triangle t = (Triangle) factory.getBean("triangle");
         t.draw();
	}

}
