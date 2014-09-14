/**
 * 
 */
package org.arindam.mishra;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ARINDAM 
 *
 */
public class DrawingApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Triangle triangle = new Triangle();
		/*We will ask the Spring bean factory to instantiate the Triangle
         * So we will instantiate the bean factory first , I will be using xml bean factory .
         * There are different types of bean factories . 
         */
     		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
        Triangle_point_object triangle_inherit = (Triangle_point_object) context.getBean("triangle1");
		triangle_inherit.draw();
		System.out.println("Hi bean inheritance");
		//Now if we are inheriting beans with list of objects
		
		Triangle_list_point_object triangleList1_inherit = (Triangle_list_point_object) context.getBean("triangleList1");
		triangleList1_inherit.draw();
		System.out.println("Inheriting the list objects");
		Triangle_point_object triangle_point =(Triangle_point_object)context.getBean("triangle_point_object");
		triangle_point.draw();
		Triangle_list_point_object triangle_point_new =(Triangle_list_point_object)context.getBean("triangle_list_point_object");
		triangle_point_new.draw();
		
        /*Point local_point=(Point)triangle_point.getPointB();
        System.out.println("x coordinate "+local_point.getX()+" y coordinate "+local_point.getY());
		*/
		/*  System.out.println(Triangle.Rand());
    System.out.println(Triangle.Rand());
	*/	

	}

}
