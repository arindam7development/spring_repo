package org.arindam._03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.arindam._03.Point;
import org.arindam._03.Shape;

public class Circle implements Shape {
	  private Point center ;
		public Point getCenter() {
		return center;
	    }
	@Resource	
	public void setCenter(Point center) {
		this.center = center;
	}
		@Override
		public void draw() {
	    System.out.println("Drawing a circle");
		System.out.println("Circle Center Point :"+"("+center.getX()+","+center.getY()+")");
		}
		/*@PostConstruct
		public void initializeCircle(){
			System.out.println("Initialzing the Circle bean ...");
		}
		@PreDestroy
		public void destroyCircle(){
			System.out.println("Just going to destroy circle bean !");
		}
		*/
	}
