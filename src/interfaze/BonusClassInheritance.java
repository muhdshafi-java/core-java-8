package interfaze;
/**
 * Method hiding - static parent method vs static child method
 * Method hiding is not possible if child is non static
 * Method Overriding - instance method of parent vs instance method of child
 * Overriding is not possible if parent method is static
 * 
 * @author king
 *
 */
public class BonusClassInheritance {
	public static void main(String[] args) {
		Vehicle v = new EngineVehicle();
		v.move();
	}
}

class Vehicle {
	public static void move() {
		System.out.println("Vehicles can move!");
	}
}

class EngineVehicle extends Vehicle {
	public static void move() {
		System.out.println("EngineVehicle can move with engine power!");
	}
}




