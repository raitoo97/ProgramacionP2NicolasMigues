package parcial2;

import javax.swing.JOptionPane;

public class Ejercicio3 {
	private int score = 0;
	private String[] riddles = {
		"Blanca por dentro, verde por fuera, si quieres que te lo diga espera",
		"Tiene dientes y no come, tiene cabeza y no es hombre",
		"Vuela sin alas, silba sin boca, pega sin manos y no se ve ni se toca"
	};

	public void Excerice3() {
		JOptionPane.showMessageDialog(null, "Hola bienvenido al juego de adivinanzas");
		int input;
		do {
			Play();
			String number;
			input = Integer.parseInt(JOptionPane.showInputDialog(null, "Presiona 0 para jugar otra ronda o cualquier otro numero para salir"));
		} while (input == 0);
		JOptionPane.showMessageDialog(null, "Gracias por jugar!");
	}

	private void Play() {
		score = 0;
		for (int i = 0; i < riddles.length; i++) {
			String answer = JOptionPane.showInputDialog(null, "Adivinanza " + (i + 1) + ":\n" + riddles[i]);
			if (IsCorrect(i, answer)) {
				score++;
				JOptionPane.showMessageDialog(null, "Correcto! Sumas un punto");
			} else {
				JOptionPane.showMessageDialog(null, "Incorrecto");
			}
		}
		JOptionPane.showMessageDialog(null, "Fin de la ronda\nPuntaje final: " + score + " de " + riddles.length);
	}

	private boolean IsCorrect(int number, String answer) {
		switch (number) {
		case 0:
			return "pera".equalsIgnoreCase(answer);
		case 1:
			return "ajo".equalsIgnoreCase(answer);
		case 2:
			return "viento".equalsIgnoreCase(answer);
		default:
			return false;
		}
	}
}
