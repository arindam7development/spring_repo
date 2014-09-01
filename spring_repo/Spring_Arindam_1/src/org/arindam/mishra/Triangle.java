package org.arindam.mishra;
public class Triangle {
	
	private String type ;
	
	private int height ;
	//Here we are using constructor injection .Notice that we are not using the setType() and setHeight .
	//I have eliminated the setter injection 
	// If Spring use setter for initializing type . I have to set the <property> tag in the spring.xml file .
	// Like <property name="type" value = "Equilateral"></property>
 
	/*public void setType(String type) {
		this.type = type;
	}

*/ 

      // Below is the configuration of spring.xml .If I use contructor injection .
	/*<bean id ="triangle" class="org.arindam.mishra.Triangle">
	   <constructor-arg index="0" value = "Equilateral"/>
	   <constructor-arg index="1" value = "20"/>
	   Backup of spring .xml that was used for constructor injection
	   </bean>*/
	

	public int getHeight() {
		return height;
	}

public Triangle(String type){
		
		this.type=type;
	}
 public Triangle(int height){
		
		this.height=height;
	}
	
public Triangle(String type,int height){
		
		this.type=type;
		this.height=height ;
	}
	
 public String getType() {
		return type;
	}


 


public void draw(){
	 System.out.println("Hi , Arindam Mishra your" +getType()+"Traingle is drawn of height"+getHeight());
 }
  //static final AtomicLong gn = new AtomicLong() ;
 /*
 public static Random svcRand = new Random();

 public static int Rand () {
   return svcRand.nextInt();
 }
 public static AtomicLong generate(){
   gn.getAndIncrement();
   return gn ;
 }
 */
}
