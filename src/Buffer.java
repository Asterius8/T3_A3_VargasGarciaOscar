
public interface Buffer {
	//Coloca un valor entero(int) dentro de el Buffer
	public void blockingPut(int value) throws InterruptedException;
	
	//Regresa un valor entero(int) desde el Buffer
	public int blockingGet() throws InterruptedException;
	
}
