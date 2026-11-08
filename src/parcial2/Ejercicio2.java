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
			String number = JOptionPane.showInputDialog(null,
			        "Presiona 0 para registrar una venta"+
			        "\nPresiona 1 para mostrar las ventas realizadas"+
			        "\nPresiona 2 para mostrar el total recaudado"+
			        "\nPresiona 3 para mostrar el producto mas vendido"+
			        "\nPresiona 4 para salir del programa"
			);

			if (number == null) {
			    option = 4;
			    continue;
			}

			try {
			    option = Integer.parseInt(number.trim());
			} catch (NumberFormatException error) {
			    JOptionPane.showMessageDialog(null, "Tenes que ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
			    JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    option = -1;
			    continue;
			}
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
			String number = JOptionPane.showInputDialog(null, "Cuantos productos tiene la tienda?");
			if (number == null || number.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tenes que ingresar la cantidad de productos", "Error", JOptionPane.ERROR_MESSAGE);
				numberOfProducts = 0;
				continue;
			}
			try {
				numberOfProducts = Integer.parseInt(number.trim());
			} catch (NumberFormatException error) {
		        JOptionPane.showMessageDialog(null, "Tenes que ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
		        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
		        numberOfProducts = 0;
		        continue;
		        
			}
			if (numberOfProducts <= 0) {
				JOptionPane.showMessageDialog(null, "La cantidad de productos debe ser mayor a 0","Error",JOptionPane.ERROR_MESSAGE);
			}
		} while (numberOfProducts <= 0);
		
		products = new String[numberOfProducts];
		prices = new int[numberOfProducts];
		for (int i = 0; i < numberOfProducts; i++) {
			String name;
			do {
				name = JOptionPane.showInputDialog(null, "Nombre del producto con codigo " + i);
				if (name == null || name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tenes que ingresar un nombre", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} while (name == null || name.trim().isEmpty());
			products[i] = name.trim();
			int price;
			do {
			    String number = JOptionPane.showInputDialog(null, "Precio de " + products[i]);
			    if (number == null || number.trim().isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Tenes que ingresar un precio", "Error", JOptionPane.ERROR_MESSAGE);
			        price = 0;
			        continue;
			    }
			    try {
			        price = Integer.parseInt(number.trim());
			    } catch (NumberFormatException error) {
			        JOptionPane.showMessageDialog(null, "Tenes que ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
			        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        price = 0;
			        continue;
			    }
			    if (price <= 0) {
			        JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0");
			    }
			} while (price <= 0);
			prices[i] = price;
		}
	}
	
	private void CreateSalesMatrix() {
		int maxSales;
		do {
			String number = JOptionPane.showInputDialog(null, "Cuantas ventas como maximo queres registrar?");
			if (number == null || number.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tenes que ingresar la cantidad de ventas", "Error", JOptionPane.ERROR_MESSAGE);
				maxSales = 0;
				continue;
			}
			try {
				maxSales = Integer.parseInt(number.trim());
				
			} catch (NumberFormatException error) {
		        JOptionPane.showMessageDialog(null, "Tenes que ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
		        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
		        maxSales = 0;
		        continue;
			}
			if (maxSales <= 0) {
				JOptionPane.showMessageDialog(null, "La cantidad de ventas debe ser mayor a 0","Error",JOptionPane.ERROR_MESSAGE);
			}
		} while (maxSales <= 0);
		sellsInformation = new int[maxSales][3];
	}
	
	private void RecordSales() {
		int input = 0;
		do {
			if (numberOfSales == sellsInformation.length) {
				JOptionPane.showMessageDialog(null, "No se pueden registrar mas ventas, la base esta llena" ,"Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int code;
			do {
				String number = JOptionPane.showInputDialog(null, "Ingrese el codigo del producto (de 0 a " + (products.length - 1) + ")");
				if (number == null || number.trim().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Volviendo al menu");
				    return;
				}
				try {
					code = Integer.parseInt(number.trim());
				} catch (NumberFormatException error) {
			        JOptionPane.showMessageDialog(null, "Tenes que ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
			        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
			        code = -1;
			        continue;
				}
				if (code < 0 || code >= products.length) {
					JOptionPane.showMessageDialog(null, "El codigo no existe" ,"Error",JOptionPane.ERROR_MESSAGE);
				}
			} while (code < 0 || code >= products.length);

			int quantity;
			do {
			    String number = JOptionPane.showInputDialog(null, "Cantidad vendida de " + products[code]);
			    if (number == null || number.trim().isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Como no pusiste ninguna cantidad volves al menu", "Warning", JOptionPane.WARNING_MESSAGE);
			        return;
			    }
			    try {
			        quantity = Integer.parseInt(number.trim());
			    } 
			    catch (NumberFormatException error) {
			        JOptionPane.showMessageDialog(null, "Tenes que ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
			        JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
			        quantity = 0;
			        continue;
			    }
			    if (quantity <= 0) {
			        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0");
			    }
			} while (quantity <= 0);

			int amount = prices[code] * quantity;

			boolean validAnswer;
			do {
				String answer = JOptionPane.showInputDialog(null,
				        "Venta: " + quantity + " unidades del producto " + products[code] +
				        " a $" + prices[code] + " la unidad. El total es = $" + amount +
				        "\nPresiona 0 para confirmar y registrar otra venta" +
				        "\nPresiona cualquier otro numero para confirmar y volver al menu" +
				        "\nPresiona Cancelar para anular esta venta");
				if (answer == null) {
				    JOptionPane.showMessageDialog(null, "Venta anulada, volves al menu", "Warning", JOptionPane.WARNING_MESSAGE);
				    return;
				}
				try {
				    input = Integer.parseInt(answer.trim());
				    validAnswer = true;
				} catch (NumberFormatException error) {
				    JOptionPane.showMessageDialog(null, "Tenes que ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
				    validAnswer = false;
				}
			} while (!validAnswer);

			sellsInformation[numberOfSales][0] = code;
			sellsInformation[numberOfSales][1] = quantity;
			sellsInformation[numberOfSales][2] = amount;
			numberOfSales++;
		} while (input == 0);
	}
	
	private void ShowSales() {
		if (numberOfSales == 0) {
			JOptionPane.showMessageDialog(null, "Todavia no hay ventas registradas" ,"Error",JOptionPane.ERROR_MESSAGE);
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
