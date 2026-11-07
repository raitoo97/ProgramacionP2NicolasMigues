package ejercitaciones;

public class Ejercicio1 {

	public static void main(String[] args) {
		int[]numeros = {9,8,22,1,5,0};
		int n = numeros.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if (numeros[j] > numeros[j+1]) {
					int aux = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = aux;
				}
			}
			System.out.print("pasada " + i +": ");
			for (int k = 0; k < numeros.length; k++) {
				System.out.print(numeros[k] + "\t");
			}
			System.out.println();
		}
	}
}
