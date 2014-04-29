
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

		new Thread(
				() -> System.out.println("hello world")
			)
			.start();
	}

	void printLambdaList() {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		//Old way:
		for(Integer n: list) {
    		System.out.println(n);
		}

		//New way:
		list.forEach(n -> System.out.println(n));

		//Double colon operator
		list.forEach(System.out::println);
	}
	
	public static void main(String[] args) {

		Lambda l = new Lambda();
		// l.runThreads();
		l.runLambdaThreads();
		l.runLambdaThreads2();
		l.printLambdaList();

	}
}
