package org.arindam._02;

import java.util.List;




public class Employee_v2 {
private List<Properties> p1;

public List<Properties> getP1() {
	return p1;
}

public void setP1(List<Properties> p1) {
	this.p1 = p1;
}
 

  
/*HashMap<String, String> hm = new HashMap<String, String>();
//add key-value pair to hashmap
hm.put("first", "FIRST INSERTED");
hm.put("second",<SECOND INSERTED>);
hm.put("third","THIRD INSERTED");
System.out.println(hm);
//getting value for the given key from hashmap
System.out.println("Value of second: "+hm.get("second"));

*/
 public void display(){
	 for(Properties prop : p1){
		 System.out.println("First Name : "+prop.getFirst_name()+" Last name : "+prop.getLast_name()+" ID :"+prop.getId());
	 }
 }





}
