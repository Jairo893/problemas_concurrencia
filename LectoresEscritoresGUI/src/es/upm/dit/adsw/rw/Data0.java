package es.upm.dit.adsw.rw;

/**
 * Lectores y escritores: ejercicio resuelto.
 * 
 * @author jose a. manas
 * @date 4.4.2013
 */
public class Data0 extends Data {
	private int nReaders;
	private boolean writing = false;
	private int waitingWriters = 0;

	@Override
	public synchronized void openReading() throws InterruptedException {
		while (writing || waitingWriters > 0)
			wait();
		nReaders++;
	}

	@Override
	public synchronized void closeReading() throws InterruptedException {
		nReaders--;
		notifyAll();
	}

	@Override
	public synchronized void openWriting() throws InterruptedException {
		while (writing || nReaders > 0) {
			waitingWriters++;
			System.out.printf("openWriting: %d readers; %d waiting writers.%n",
					nReaders, waitingWriters);
			wait();
			waitingWriters--;
		}
		writing = true;
		System.out.println("START WRITING");
	}

	@Override
	public synchronized void closeWriting() throws InterruptedException {
		writing = false;
		notifyAll();
		System.out.println("END WRITING");
	}
}