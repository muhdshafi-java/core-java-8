package lambda;

public class LambdaDemo {

	public static void main(String[] args) {
		//OOP design 
		MathOperationI add = new Add(); 
		Calculator calc = new Calculator();
		System.out.println("Demo 1: "+calc.operate(10, 15, add));

		//Anonymous Class
		MathOperationI addAnonymous = new MathOperationI() {
			@Override
			public int operation(int num1, int num2) {
				return num1 + num2;
			}

		};
		System.out.println("Demo 2: "+calc.operate(10, 15, addAnonymous));
		
		//Lambda
		MathOperationI addLambda = (num1, num2) -> num1 + num2;
		System.out.println("Demo 3: "+calc.operate(10, 15, addLambda));
		
		//In line Lambda
		System.out.println("Demo 4: "+calc.operate(10, 15, (num1, num2) -> num1 + num2));
	}

}

class Calculator{
	int operate(int num1, int num2, MathOperationI op) {
		return op.operation(num1, num2);
	}
}

interface MathOperationI {
	int operation(int num1, int num2);
}

class Add implements MathOperationI{

	@Override
	public int operation(int num1, int num2) {
		return num1 + num2;
	}
	
}