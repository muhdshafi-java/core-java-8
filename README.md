# Java-8
## Interfaces
### default method
### static method
## Lambda Expression
 * Comparison between Anonymous class and Lambda expression 
 * Lambdas implement a functional interface. 
 * Anonymous Inner Classes can extend a class or implement an interface with any number of methods. 
 * Variables – Lambdas can only access final or effectively final. 
 * State – Anonymous inner classes can use instance variables and thus can have state, lambdas cannot. 
 * Scope – Lambdas can't define a variable with the same name as a variable in enclosing scope.
 * Compilation – Anonymous compiles to a class, while lambda is an invokedynamic instruction.
 
 ### Inner Classes Scope
 #### Regular Class
 ```java
public class InnerClassScope {
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		r.run();
	}
	
}

class MyRunnable implements Runnable{
	String test = "Hello";
	@Override
	public void run() {
		System.out.println("MyRunnable.run() "+test);
		
	}
	
}
``` 

 #### Inner Class
 Lexical Scope
 ```java
public class InnerClassScope {
	
	String test = "Hello A";
	
	public static void main(String[] args) {
		InnerClassScope driver = new InnerClassScope();
		MyRunnable r = driver.new MyRunnable();
		r.run();
	}
	
	class MyRunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("MyRunnable.run() "+test);//MyRunnable.run() Hello A
		}
	}
	
}
``` 


## Method Reference
## Stream

