package org.arindam._02;




public class Employee {
 private Properties p1 ;

public Properties getP1() {
	
	return p1;
}

public void setP1(Properties p1) {
	this.p1 = p1;
}
 
public void display(){
	System.out.println("My name is "+getP1().getFirst_name()+" "+getP1().getLast_name()+" my id is "+getP1().getId());
}

}
