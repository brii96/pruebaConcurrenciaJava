package concurrencia;

import java.util.Arrays;

public class ArrayConcurrente implements Runnable{
	
	private int[] vec;
	private int tam;
	private int id;
		
	public ArrayConcurrente(int tam, int id) {
		this.vec =new int[tam];
		this.id=id;
	}
	
	public void rellenarVector() {
		for(int i=0; i<this.vec.length; i++) {
			this.vec[i] = (int) (Math.random()*20+0);
		}
	}
	
	public void mostrarVector() {
//		System.out.println("Vector con id: "+this.id);
		for(int j=0; j<this.vec.length; j++) {
			System.out.print(this.vec[j]+"\t");
		}
		System.out.println();
	}
	
	public void mostrarVectorOrdenado() {
		Arrays.sort(this.vec);
//		System.out.println("Vector ordenado con id: "+this.id);
//		for (int m=0; m<this.vec.length; m++) {
//			System.out.print(this.vec[m]+"\t");
//		}
//		System.out.println();
	}
		
	@Override
	public void run() {
//		System.out.println("Soy el hilo: "+this.id);
		System.out.println("[R] Ejecutandose hilo de id --> " +this.id);
		for (int i = 0; i < this.vec.length; i++) {
			System.out.println(" " +this.vec[i]);
		}
	}
		
	public static void main(String[] args) {
		ArrayConcurrente v1 = new ArrayConcurrente (5, 1);
		Thread t1 = new Thread (v1);
		ArrayConcurrente v2 = new ArrayConcurrente (5, 2);
		Thread t2 = new Thread (v2);
		
		v1.rellenarVector();
		v1.mostrarVector();
		v1.mostrarVectorOrdenado();
		t1.start();
		
		v2.rellenarVector();
		v2.mostrarVector();
		v2.mostrarVectorOrdenado();
		t2.start();
		
//		Thread arr1 = new Thread (new VectorConcurrente(1));
//		//Asignando ids a cada hilo
//		VectorConcurrente [] v1 = new VectorConcurrente [2];
//		
//		arr1.start();
//		
//		for (int i = 0; i < 100; i++) {
//			System.out.println("Soy el hilo principal");
//		}
		
	}

	
}
