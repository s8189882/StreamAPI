package lambdaexpression.numberplaylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlaylist {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> myNumberList = new ArrayList<Integer>();
		for(int i = 0; i < 8; i++)
			myNumberList.add(i);
		
		
		//Method 1 : traversing using Iterator
		Iterator<Integer> it = myNumberList.iterator();
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.println("Method 1 :\tIterator Value :: " + i);
		}
		
		
		//Method 2 : traversing with Explicit Consumer interface implementation
		class MyConsumer implements Consumer<Integer> {
			public void accept(Integer t) {
				System.out.println("Method 2 :\tConsumer impl Value :: " + t);
			}
		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);
	
		
		//Method 3 : traversing with Anonymous Consumer interface implementation
		myNumberList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("Method 3 :\tforEach Anonymous class Value :: " + t);
			}
		});
		
		
		//Method 4 : Explicit Lambda Function
		Consumer<Integer> myListAction = n -> {
			System.out.println("Method 4 :\tforEach Lambda impl Value :: " + n);
		};
		myNumberList.forEach(myListAction);
		
		
		//Method 5 : Implicit Lambda Function
		myNumberList.forEach(n -> {
			System.out.println("Method 5 :\tforEach (implicit) Lambda impl Value :: " + n);
		});
		
		
		//Method 6 : Implicit Lambda Function to print double value
		Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
		myNumberList.forEach(n -> {
			System.out.println("Method 6 :\tforEach Lambda double Value :: " + toDoubleFunction.apply(n));
		});
		
		
		//Method 7 : Implicit Lambda function to Check Even Numbers
		Predicate<Integer> isEvenFunction = n -> n > 0 && n%2 == 0;
		myNumberList.forEach(n -> {
			System.out.println("Method 7 :\tforEach Value : " + n + "\ttest if Even  : " + isEvenFunction.test(n));
		});
	}
}
