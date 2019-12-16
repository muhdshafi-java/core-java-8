package lambda;

public class App {

	public static void main(String args[]) {
		App tester = new App();
		// Anonymous class
		MathOperation add = new MathOperation() {
			@Override
			public int operation(int a, int b) {
				return a + b;
			}
		};
		// Lambda
		MathOperation addLambda = (a, b) -> a + b; 
		// in line lambda
		System.out.println("10 + 5 = " + tester.operate(10, 5, (a, b) -> a + b));

	}
	//implementation class
	class MathOperationAdd implements MathOperation {

		@Override
		public int operation(int a, int b) {
			return a + b;
		}

	}

	interface MathOperation {
		int operation(int a, int b);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}