package concurrencia;

import java.util.Arrays;

public class Vector {
	
	private int[] vec;
	private int tam;
	
	public Vector(int tam) {
		this.vec =new int[tam];
	}
		
	public int[] getVec() {
		return this.vec;
	}

//	@Override
//	public String toString() {
//		return "Vector [vec=" + Arrays.toString(this.getVec()) + "]";
//	}

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
		for (int m=0; m<this.vec.length; m++) {
			System.out.print(this.vec[m]+"\t");
		}
		System.out.println();
	}
	
}
