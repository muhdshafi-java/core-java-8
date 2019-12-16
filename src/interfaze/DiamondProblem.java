package interfaze;

/**
 * When Diamond problem occurs with multiple interfaces with default methods,
 * implementation class need to override and specify which default
 * implementation to be used or provide a new implementation
 * 
 * @author king
 *
 */
public class DiamondProblem {

	public static void main(String[] args) {

		MyClassA a = new MyClassA();
		a.method();
		MyClassAB ab = new MyClassAB();
		ab.method();
	}

}

interface InterfaceA {
	default void method() {
		System.out.println("InterfaceA");
	}
}

interface InterfaceB {
	default void method() {
		System.out.println("InterfaceB");
	}
}

class MyClassA implements InterfaceA {}

class MyClassAB implements InterfaceA, InterfaceB {

	@Override
	public void method() {
		InterfaceB.super.method();
	}
}

