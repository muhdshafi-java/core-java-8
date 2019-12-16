package lambda;

/**
 * Comparison between Anonymous class and Lambda expression 
 * Lambdas implement a functional interface. 
 * Anonymous Inner Classes can extend a class or implement an interface with any number of methods. 
 * Variables – Lambdas can only access final or effectively final. 
 * State – Anonymous inner classes can use instance variables and thus can have state, lambdas cannot. 
 * Scope – Lambdas can't define a variable with the same name as a variable in enclosing scope.
 * Compilation – Anonymous compiles to a class, while lambda is an invokedynamic instruction.
 * 
 * @author king
 *
 */
public class AnonymusVsLambda {
	public static void main(String[] args) {
		String species = "Dog"; //can not access variable in the enclosed scope
		Animal a = new Animal("Cat") {
			void eat() {
				System.out.println("Cat eat fish, "+"species:"+species);//can access the variable in the instance variable.
			}
		};
		a.eat();
		
		String bodyType = "Sedan";
		getVehicleDetails(() -> System.out.println(bodyType+" car is moving!"));
		
	}
	
	public static void getVehicleDetails(Vehicle v) {
		v.move();
	}
}



 interface Vehicle{//must be an interface not abstract class
	public static final String bodyType = "Hatchback";//anti-pattern just for the sake of demo
	abstract void move();
}

class Animal{
	public String species;
	Animal(String species){
		this.species = species;
	}
	void eat() {
		System.out.println("Animal eat anything");
	}
}