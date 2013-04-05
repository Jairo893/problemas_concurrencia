package es.upm.dit.adsw.rw;

import javax.swing.*;
import java.awt.*;

/**
 * Animacion de lectores y escritores.
 * 
 * @author jose a. manas
 * @date 4.4.2013
 */
public class Botones {
	private static final int N_ROWS = 5;
	private static final int N_COLS = 5;

	public static void main(String[] args) {
		// Data es el ejercicio pendiente resolucion
//		Data data = new Data();
		
		// Data0 es una solucion al ejercicio
		Data data = new Data0();

		JFrame frame = new JFrame("Readers & writers");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new GridLayout(N_ROWS, N_COLS));
		for (int row = 0; row < N_ROWS; row++) {
			for (int col = 0; col < N_COLS; col++) {
				JButton button = new JButton(String.format("%d, %d", row, col));
				container.add(button);

				// cada tarea tiene un boton para colorearlo egun su estado
				ReaderWriter rw = new ReaderWriter(data, button);
				rw.start();
			}
		}

		frame.pack();
		frame.setVisible(true);
	}
}