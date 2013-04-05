package es.upm.dit.adsw.rw;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Animacion de lectores y escritores.
 * 
 * @author jose a. manas
 * @date 4.4.2013
 */
public class ReaderWriter extends Thread {
	private static final Color IDLE = Color.LIGHT_GRAY;
	private static final Color READING = Color.BLUE;
	private static final Color WRITING = Color.RED;

	private final Random random = new Random();

	private final Data data;
	private final JButton button;

	public ReaderWriter(Data data, JButton button) {
		this.data = data;
		this.button = button;
	}

	@Override
	public void run() {
		try {
			while (true) {
				button.setBackground(IDLE);
				sleep(random.nextInt(2) * 1000);

				if (Math.random() < 0.1) {
					// 1 de cada 10 veces, escribe
					data.openWriting();
					button.setBackground(WRITING);
					sleep(random.nextInt(2) * 1000);
					data.closeWriting();

				} else {
					// 9 de cada 10 veces, escribe
					data.openReading();
					button.setBackground(READING);
					sleep(random.nextInt(3) * 1000);
					data.closeReading();
				}
			}
		} catch (InterruptedException ignored) {
		}
	}
}
