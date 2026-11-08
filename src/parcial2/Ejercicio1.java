package parcial2;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	private String[] namesOfStudents;
	private int[] studentGrades;
	
	private int numberOfStudents;
	private int input = 0;
	public void Excerice1() {
		JOptionPane.showMessageDialog(null, "Hola bienvenido al sistema de gestion de notas");
		InputStudentsNames();
		InputStudentsGrades();
		BubbleSort();
		while (input == 0) {
		    checkStudentsPass();
		    boolean validAnswer;
		    do {
		        String answer = JOptionPane.showInputDialog(null, "Presiona 0 si deseas volver a consultar la nota o presiona cualquier otro numero para salir");
		        if (answer == null || answer.trim().isEmpty()) {
		        	validAnswer = false;
		        	continue;
		        }
		        try {
		            input = Integer.parseInt(answer.trim());
		            validAnswer = true;
		        } catch (NumberFormatException error) {
		            JOptionPane.showMessageDialog(null, "Debes ingresar un valor numerico", "Error", JOptionPane.ERROR_MESSAGE);
		            validAnswer = false;
		        }
		    } while (!validAnswer);
		}
		
	}
	
	private void InputStudentsNames() {
		do {
			String number = JOptionPane.showInputDialog(null, "Que cantidad de estudiantes quisiera ingresar: ");
			if(number == null || number.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debes ingresar un valor numerico","Error",JOptionPane.ERROR_MESSAGE);
				numberOfStudents = 0;
				continue;
			}
			try {
				numberOfStudents =Integer.parseInt(number.trim());
			} catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(null, "Debes Ingresar un valor numerico","Error",JOptionPane.ERROR_MESSAGE);
				numberOfStudents = 0;
				continue;
			}
			if (numberOfStudents <= 0) 
				JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que 0");
		}while(numberOfStudents <= 0);
		
		namesOfStudents = new String[numberOfStudents];
		studentGrades = new int[numberOfStudents];
		for (int i = 0; i < numberOfStudents; i++) {
		    String name;
		    do {
		        name = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante " + (i + 1));
		        if (name == null || name.trim().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Debes ingresar un nombre", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    } while (name == null || name.trim().isEmpty());
		    namesOfStudents[i] = name.trim();
		}
	}
	
	private void InputStudentsGrades() {
		for (int i = 0; i < numberOfStudents; i++) {
			int grade;
			do {
				String number = JOptionPane.showInputDialog(null, "Ingrese la nota de " + namesOfStudents[i]);
				if(number == null || number.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes ingresar un valor numerico","Error",JOptionPane.ERROR_MESSAGE);
					grade = -1;
					continue;
				}
				try {
					grade = Integer.parseInt(number.trim());
					
				} catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "Debes ingresar un valor numerico","Error",JOptionPane.ERROR_MESSAGE);
					grade = -1;
					continue;
				}
				if (grade < 0 || grade > 10) {
					JOptionPane.showMessageDialog(null, "Nota incorrecta\nLa nota debe ir entre 0 y 10");
				}else {
					JOptionPane.showMessageDialog(null, "Nota ingresada con exito!");
				}
			}while(grade < 0 || grade > 10);
			studentGrades[i] = grade;
		}
	}
	
	private float CalculateAverage() {
		float average = 0f;
		int total = 0;
		for (int i = 0; i < studentGrades.length; i++) {
			total += studentGrades[i];
		}
		average =(float) total / numberOfStudents;
		return average;
	}
	
	private void BubbleSort() 
	{
		int n = studentGrades.length;
		for (int i = 0; i < n- 1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if(studentGrades[j] > studentGrades[j + 1]) {
					int aux = studentGrades[j];
					studentGrades[j] = studentGrades[j + 1];
					studentGrades[j + 1] = aux;
					String auxName = namesOfStudents[j];
					namesOfStudents[j] = namesOfStudents[j + 1];
					namesOfStudents[j + 1] = auxName;
					
				}
			}
		}
	}
	private int lowestGrade() {
		return studentGrades[0];
	}
	
	private int highestGrade() {
		return studentGrades[numberOfStudents - 1];
	}
	
	private boolean hasPassed(int grade) {
		return grade >= 6;
	}
	
	private void checkStudentsPass(){
		String list = "Listado de estudiantes:\n";
		for (int i = 0; i < numberOfStudents; i++) {
			if (hasPassed(studentGrades[i])) {
				list += namesOfStudents[i] + " - Nota: " + studentGrades[i] + " - Aprobo\n";
			} else {
				list += namesOfStudents[i] + " - Nota: " + studentGrades[i] + " - Desaprobo\n";
			}
		}
		list += "\nPromedio general del curso: " + CalculateAverage();
		list += "\nNota mas alta: " + highestGrade();
		list += "\nNota mas baja: " + lowestGrade();
		JOptionPane.showMessageDialog(null, list);
	}
}
