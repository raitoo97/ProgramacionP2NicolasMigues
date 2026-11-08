package parcial2;

import javax.swing.JOptionPane;

public class Ejercicio2 {
	//							0					1					2
	// La matriz seria: código del producto, la cantidad vendida y el importe total.
	private int[][] sellsInformation;
	private int[] prices;
	private String[] products;
	private int numberOfSales = 0;
	
	public void Excerice2() {
		JOptionPane.showMessageDialog(null, "Hola bienvenido al programa de la tienda: \"Profe porfa aprobame :D\" ");
		RegisterProducts();
		CreateSalesMatrix();
		Menu();
	}
	
	private void Menu() {
		int option;
		do {
			option = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Presiona 0 para registrar una venta"+
					"\nPresiona 1 para mostrar las ventas realizadas"+
					"\nPresiona 2 para mostrar el total recaudado"+
					"\nPresiona 3 para mostrar el producto mas vendido"+
					"\nPresiona 4 para salir del programa"
					));
			switch (option) {
			case 0:
				RecordSales();
				break;
			case 1:
				ShowSales();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "El total recaudado es: $" + CalculateTotal());
				break;
			case 3:
				ShowBestSellingProduct();
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Hasta luego");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta");
			}
		} while (option != 4);
	}
	
	private void RegisterProducts() {
		int numberOfProducts;
		do {
			numberOfProducts = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos productos tiene la tienda?"));
			if (numberOfProducts <= 0) {
				JOptionPane.showMessageDialog(null, "La cantidad de productos debe ser mayor a 0");
			}
		} while (numberOfProducts <= 0);
		products = new String[numberOfProducts];
		prices = new int[numberOfProducts];
		for (int i = 0; i < numberOfProducts; i++) {
			products[i] = JOptionPane.showInputDialog(null, "Nombre del producto con codigo " + i);
			prices[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Precio de " + products[i]));
		}
	}
	
	private void CreateSalesMatrix() {
		int maxSales;
		do {
			maxSales = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas ventas como maximo queres registrar?"));
			if (maxSales <= 0) {
				JOptionPane.showMessageDialog(null, "La cantidad de ventas debe ser mayor a 0");
			}
		} while (maxSales <= 0);
		sellsInformation = new int[maxSales][3];
	}
	
	private void RecordSales() {
		int input = 0;
		do {
			if (numberOfSales == sellsInformation.length) {
				JOptionPane.showMessageDialog(null, "No se pueden registrar mas ventas, la base esta llena");
				return;
			}
			
			int code;
			do {
				code = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del producto (de 0 a " + (products.length - 1) + ")"));
				if (code < 0 || code >= products.length) {
					JOptionPane.showMessageDialog(null, "El codigo no existe");
				}
			} while (code < 0 || code >= products.length);

			int quantity;
			do {
				String text = JOptionPane.showInputDialog(null, "Cantidad vendida de " + products[code]);
				if (text == null) {
					return;
				}
				quantity = Integer.parseInt(text);
				if (quantity <= 0) {
					JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0");
				}
			} while (quantity <= 0);

			int amount = prices[code] * quantity;
			sellsInformation[numberOfSales][0] = code;
			sellsInformation[numberOfSales][1] = quantity;
			sellsInformation[numberOfSales][2] = amount;
			numberOfSales++;

			input = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Venta registrada: " + quantity + " unidades del producto " + products[code] + " a $" + prices[code] + " la unidad"+ " el total es  = $" + amount +
					"\nPresiona 0 para registrar otra venta o cualquier otro numero para volver al menu"));
		} while (input == 0);
	}
	
	private void ShowSales() {
		if (numberOfSales == 0) {
			JOptionPane.showMessageDialog(null, "Todavia no hay ventas registradas");
			return;
		}
		String list = "Ventas realizadas:\n";
		for (int i = 0; i < numberOfSales; i++) {
			int code = sellsInformation[i][0];
			list += "Venta " + (i) + ": " + products[code] + " - Cantidad : "
					+ sellsInformation[i][1] + " - Importe: $" + sellsInformation[i][2] + "\n";
		}
		JOptionPane.showMessageDialog(null, list);
	}
	
	private int CalculateTotal() {
		int total = 0;
		for (int i = 0; i < numberOfSales; i++) {
			total += sellsInformation[i][2];
		}
		return total;
	}
	
	private void ShowBestSellingProduct() {
		if (numberOfSales == 0) {
			JOptionPane.showMessageDialog(null, "Todavia no hay ventas registradas");
			return;
		}
		int[] quantityPerProduct = new int[products.length];
		for (int i = 0; i < numberOfSales; i++) {
			int code = sellsInformation[i][0];
			quantityPerProduct[code] += sellsInformation[i][1];
		}
		
		int best = 0;
		for (int i = 0; i < products.length; i++) {
		    if (quantityPerProduct[i] > quantityPerProduct[best]){
		        best = i;
		    }
		}
		JOptionPane.showMessageDialog(null, "El producto mas vendido es " + products[best] + " con " + quantityPerProduct[best] + " unidades");
	}
}
