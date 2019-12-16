package interfaze;
/**
 * 
 **** Default Method - providing a default implementation in interface.
 * it starts with the keyword default
 * It is not mandatory to implement the methods with default implementation for the classes. 
 * this help us while adding new method to interface, all the existing classes need not implement it.
 * can be overridden later either in sub interface or implementing class
 * Can not override methods from the Object class
 * if the Super class and Interface have the same method implementation class takes precedence.
 * 
 **** Static Method - method with implementation on interface 
 * unlike in classes, Static methods in interface are not inherited.
 * 
 * 
 * 
 * @author king
 *
 */
public class InterfaceDemo {

	public static void main(String[] args) {

		Animal animal = new Cow();
		animal.eat();
		
		
		Animal.makeNoice();
		//Vegitarian.makeNoice();//compilation error, static methods are not inherited for Interfaces.

		//if a super class and and an interface has same method implementation class takes the precedence.
		Class12 classInterface = new Class12();
		classInterface.method();
		
	}

}

interface Animal {
	
/*	default String toString() { //default method can not override from Object Class
		return "";
	}*/
	
	default void eat() {
		System.out.println("Animal eats meat!");
	}
	
	static void makeNoice() {
		System.out.println("Animal make noice!");
	}
}

interface Vegitarian extends Animal {
	default void eat() {
		System.out.println("Vegitarian eats leaves!");
	}
}

class Cow implements Vegitarian {
	public void eat() {
		System.out.println("Cow eat Grass!");
	}
}


//default method in class vs interface

class Class1{
	public void method() {
		System.out.println("Class1.method()");
	}
}

interface Interface2{
	default void method() {
		System.out.println("Interface2.method()");
	}
}

class Class12 extends Class1 implements Interface2 {
	
}
