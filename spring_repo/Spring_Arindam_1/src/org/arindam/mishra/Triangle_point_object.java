/**
 * 
 */
package org.arindam.mishra;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author ARINDAM
 *
 */
public class Triangle_point_object implements ApplicationContextAware,BeanNameAware {
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context =null;
	
	public ApplicationContext getContext() {
		return context;
	}


	public void setContext(ApplicationContext context) {
		this.context = context;
	}


	public Point getPointA() {
		return pointA;
	}


	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public Point getPointB() {
		return pointB;
	}


	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	public Point getPointC() {
		return pointC;
	}


	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}


	public void draw(){
	
		System.out.println("Point A ("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("Point B ("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("Point C ("+getPointC().getX()+","+getPointC().getY()+")");
		
	}


	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("Bean Name"+beanName);
	}


	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		this.context =context ;
		
		
	}
	
}
