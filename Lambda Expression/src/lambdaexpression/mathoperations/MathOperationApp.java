package lambdaexpression.mathoperations;


@FunctionalInterface
interface IMathFunction {
	int calculate(int a, int b);
	static void printResult (int a, int b, String function, IMathFunction fobj) {
		System.out.println("Result of " + function + " is " + fobj.calculate(a, b));
	}
}

public class MathOperationApp {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Math Operation App!\n");
		
		//Lambda Expressions
		IMathFunction add = (int x, int y) -> x + y;
		IMathFunction subtract = (int x, int y) -> x - y;
		IMathFunction multiply = (x, y) -> x * y;
		IMathFunction divide = (int x, int y) -> {
			if ( y == 0 ) return 0;
			return x / y;
		};
		
		//Operations using Lambda Expressions
		System.out.println("Addition is " + add.calculate(25, 5));
		System.out.println("Subtraction is " + subtract.calculate(25, 5));
		System.out.println("Multiplication is " + multiply.calculate(25, 5));
		System.out.println("Division is " + divide.calculate(25, 5));
		try {
			System.out.println("Division is " + divide.calculate(25, 0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Passing Lambda expressions as function parameter tp print result using static function
		IMathFunction.printResult(25, 5, "Addition", add);
		IMathFunction.printResult(25, 5, "Subtraction", subtract);
		IMathFunction.printResult(25, 5, "Multiplication", multiply);
		IMathFunction.printResult(25, 5, "Division", divide);
	}
}
