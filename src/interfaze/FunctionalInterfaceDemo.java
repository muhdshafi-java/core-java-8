package interfaze;

public class FunctionalInterfaceDemo {
	public static void main(String[] arg) {
		System.out.println("Test.main()");
	}
}

@FunctionalInterface
interface Vehicle{
	void eat();
}
