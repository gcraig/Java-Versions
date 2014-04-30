
import java.util.List;
import java.util.Arrays;

public class Lambda {

	void runThreads() {

		Runnable run = new Runnable() {
		    public void run() {
		        try {
		            for (int i = 0; i < 5; i++) {
		                Thread.sleep(1000);
		                System.out.print(i + "\n" + "..");
		            }

		        } catch (InterruptedException e) {
		            System.out.println(" interrupted");
		        }
		    }
 		};
 		
 		new Thread(run).start();
 		new Thread(run).start();

	}

	void runLambdaThreads() {

		Runnable run = () -> {
	        try {
	            for (int i = 0; i < 5; i++) {
	                Thread.sleep(1000);
	                System.out.print(i + "\n" + "..");
	            }

	        } catch (InterruptedException e) {
	            System.out.println(" interrupted");
	        }
		};

 		new Thread(run).start();
 		new Thread(run).start();

	}

	void runLambdaThreads2() {
		new Thread(() -> System.out.println("Running thread ...")).start();
	}

	void printLambdaList() {
		//Test Data:
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		//Old way:
		for(Integer i: list) {
    		System.out.println(i);
		}

		//New way:
		list.forEach(x -> System.out.println(x));

		//Double colon operator
		list.forEach(System.out::println);
	}

	interface HelloWorld {
		void sayHello(String s);
	}

	interface HelloWorld2 {
		void sayHello();
	}

	interface HelloWorld3 {
		void sayHello(String s, String o);
	}

	static HelloWorld3 hw = (s, o) -> { 
		System.out.println("Hello " + s);
		System.out.printf("Processing %s\n", o);
	};


	static HelloWorld hs = s -> { //parens can be omitted for single args
		System.out.println("I said yo sucka! " + s);
		System.out.println("Processing invoices ...");
	};

	//Empty parens for anonymous
	static HelloWorld2 hh = () -> System.out.println("I *said* Hello!");
	
	public static void main(String[] args) {

		Lambda l = new Lambda();
		// l.runThreads();
		l.runLambdaThreads();
		l.runLambdaThreads2();
		l.printLambdaList();
		
		//aside from anonymous inner classes:

		//one powerful use of lambda closures:
		//run variable code blocks from the same interface, much like
		//polymorphism; instead of having to subclass, assign code blocks
		//to different instances, simpler syntax, and spin through a collection
		//of the same interface, resulting in different behavior
		hw.sayHello("George", "_orders_");
		hs.sayHello("Tim");
		hh.sayHello();

	}
}
