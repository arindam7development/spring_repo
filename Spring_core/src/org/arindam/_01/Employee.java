package org.arindam._01;

public class Employee {
private String first_name ;
private String last_name ;
 public Employee(String f , String l){
	 this.first_name = f;
	 this.last_name = l; 
 }
 
 public String getFirst_name() {
	return first_name;
}

/*public void setFirst_name(String first_name) {
	this.first_name = first_name;
}*/

public String getLast_name() {
	return last_name;
}

/*public void setLast_name(String last_name) {
	this.last_name = last_name;
}
*/
public void display(){
	 System.out.println(getFirst_name()+" "+getLast_name());
 }
 
 
}
