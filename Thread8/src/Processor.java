import java.util.Scanner;

/**
 * Wait and Notify
 * 
 * @author jciqueira https://github.com/JohnathanCiqueira/
 *
 */
public class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producecr thread running ....");
			wait();
			System.out.println("Resumed.");
		}
	}

	public void consume() throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);

		synchronized (this) {
			System.out.println("Waiting for return key.");
			sc.nextLine();
			System.out.println("Return key pressed.");
			notify();
			Thread.sleep(5000);
		}
	}

}