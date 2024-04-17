import java.security.SecureRandom;

public class Producer implements Runnable{

	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;
	
	//Constructor(es)
	public Producer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	//Guarda valores de 1 a 10 en sharedLocation
	@Override
	public synchronized void run() {
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {	
			try {
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sharedLocation.blockingPut(i); // set value in buffer
				sum += i;
				System.out.printf("\t%2d%n", sum);
				
			} catch (InterruptedException e) {
				
				Thread.currentThread().interrupt();
				
			}//Try
			
		}//For
		
		System.out.printf("Producer termino de producir %nTerminando producer%n");
		
	}//Run
	
}//Producer
