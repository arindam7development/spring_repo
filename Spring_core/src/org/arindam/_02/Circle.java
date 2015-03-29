package org.arindam._02;

public class Circle implements Shape {
  private Point center ;
	public Point getCenter() {
	return center;
}
public void setCenter(Point center) {
	this.center = center;
}
	@Override
	public void draw() {
    System.out.println("Drawing a circle");
	System.out.println("Circle Center Point :"+"("+center.getX()+","+center.getY()+")");
	}

}
