package lambdaexpression.mathoperations;


@FunctionalInterface
interface IMathFunction {
	int calculate(int a, int b);
}

public class MathOperationApp {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Math Operation App!\n");
		
		IMathFunction add = (int x, int y) -> x + y;
		IMathFunction subtract = (int x, int y) -> x - y;
		IMathFunction multiply = (x, y) -> x * y;
		IMathFunction divide = (int x, int y) -> x / y;
		
		System.out.println("Addition is " + add.calculate(25, 5));
		System.out.println("Subtraction is " + subtract.calculate(25, 5));
		System.out.println("Multiplication is " + multiply.calculate(25, 5));
		System.out.println("Division is " + divide.calculate(25, 5));
	}
}
