package lambdaexpression.numberplaylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		
		
		//Create Stream and iterate
		myNumberList.stream().forEach( n -> {
			System.out.println("Stream\tforEach Value : " + n);
		});
		
		
		//Process the Stream, Apply Double operation on the stream, Store the result
		List<Double> doubleList = myNumberList.stream().map(toDoubleFunction).collect(Collectors.toList());
		System.out.println("Stream\tPrinting Double List : " + doubleList);
		
		
		//Process the Stream, Apply Even Filter on the stream, Store the result
		List<Integer> evenList = myNumberList.stream().filter(isEvenFunction).collect(Collectors.toList());
		System.out.println("Stream\tPrinting Even List : " + evenList);
		
		
		//Process the Stream, Apply Find First and Even Filter on the stream, Store the result
		Integer firstEven = myNumberList.stream().filter(isEvenFunction).peek(n -> System.out.println("Peak Even Number : "+n)).findFirst().orElse(null);
		System.out.println("Stream\tPrinting First Even from List : " + firstEven);
		
		
		//Process the Stream, Find minimum from the stream, Store the result
		Integer min = myNumberList.stream().filter(isEvenFunction).min((n1, n2) -> n1-n2).orElse(null);
		System.out.println("Stream\tPrinting Minimum Even from List : " + min);

		
		//Process the Stream, Find maximum from the stream, Store the result
		Integer max = myNumberList.stream().filter(isEvenFunction).max(Comparator.comparing(Integer::intValue)).orElse(null);
		System.out.println("Stream\tPrinting Maximum Even from List : " + max);

		
		//Process the Stream, Find sum and average of the stream, Store the result
		Integer sum = myNumberList.stream().reduce(0, Integer::sum);
		long count = myNumberList.stream().count();
		System.out.println("Stream\tPrinting Average of " + sum + "/" + count + " : " + sum/count);

	}
}
