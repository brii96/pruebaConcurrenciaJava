package concurrencia;

public class VectorConcurrente extends Vector implements Runnable{
	
	private int id;
	
	public VectorConcurrente(int tam, int id) {
		super(tam);
		this.id=id;
	}	
		
	@Override
	public void run() {
			
		for (int i = 0; i < this.getVec().length; i++) {
			System.out.println(this.getVec()[i]+ " Hilo nro: " +this.id);
			
			try {
				Thread.sleep(500);
								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public int getId() {
		return id;
	}

	public static void main(String[] args) {
		
		VectorConcurrente v1 = new VectorConcurrente (10, 1);
		Thread t1 = new Thread (v1);
		
		VectorConcurrente v2 = new VectorConcurrente (10, 2);
		Thread t2 = new Thread (v2);
		
		VectorConcurrente v3 = new VectorConcurrente (10, 3);
		Thread t3 = new Thread (v3);
		
//		VectorConcurrente v4 = new VectorConcurrente (10, 4);
//		Thread [] t4 = new Thread [4] ; Chequear con pruebas
		
	
		v1.rellenarVector();
		v1.mostrarVectorOrdenado();
		v2.rellenarVector();
		v2.mostrarVectorOrdenado();
		v3.rellenarVector();
		v3.mostrarVectorOrdenado();

		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.start();		
		
		t2.start();
		
//		System.out.println("Ejecutando Thread");
	}

}
