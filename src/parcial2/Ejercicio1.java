package parcial2;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	private String[] namesOfStudents;
	private int[] studentGrades;
	private int numberOfStudents;
	int input = 0;
	public void Excerice1() {
		JOptionPane.showMessageDialog(null, "Hola bienvenido al sistema de gestion de notas");
		InputStudentsNames();
		InputStudentsGrades();
		BubbleSort();
		boolean condition = input == 0;
		while(condition) {
			checkStudentsPass();
			input = Integer.parseInt(JOptionPane.showInputDialog(null,"Presiona 0 si deseas volver a consultar la nota o presiona cualquierotra numero para salir"));
		}
		
	}
	
	private void InputStudentsNames() {
		numberOfStudents =Integer.parseInt(JOptionPane.showInputDialog(null, "Que cantidad de estudiantes quisiera ingresar: ")); 
		for (int i = 0; i < numberOfStudents; i++) {
			namesOfStudents[i] = JOptionPane.showInputDialog(null,"Ingrese nombre de estudiante");
		}
	}
	
	private void InputStudentsGrades() {
		for (int i = 0; i < numberOfStudents; i++) {
			boolean validNote = studentGrades[i] > 0 && studentGrades[i] <= 0;
			do {
				studentGrades[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese notas de estudiante"));
				if(validNote) {
					JOptionPane.showMessageDialog(null, "Nota Ingresada con exito");
				}else {
					JOptionPane.showMessageDialog(null, "Nota incorrecta" + "\n" + " La nota debe ir entre 1 y 10");
				}
			}while(validNote);
		}
	}
	
	private float CalculateAverage() {
		float average = 0f;
		int total = 0;
		for (int i = 0; i < studentGrades.length; i++) {
			total += studentGrades[i];
		}
		average = total / numberOfStudents;
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
				}
			}
		}
	}
	
	private void checkStudentsPass(){
		boolean condition = input == 0;
		for (int i = 0; i < studentGrades.length; i++) {
			boolean hasPassed = studentGrades[i] >= 6;
			if(hasPassed) {
				JOptionPane.showMessageDialog(null,"El estudiante llamado: " + namesOfStudents[i] + "Aprobo con: " + studentGrades[i]);
			}else {
				JOptionPane.showMessageDialog(null,"El estudiante llamado: " + namesOfStudents[i] + "desaprobo con: " + studentGrades[i]);
			}
		}
		JOptionPane.showMessageDialog(null, "El promedio general de la cursada fue: " + CalculateAverage());
	}
}
