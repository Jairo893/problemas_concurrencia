package es.upm.dit.adsw.LectoresEscritores;


/** Monitor para gestionar a un conjunto de hebras lectoras y escritoras.
 * Si hay hebras lectoras y escritoras, se establece un turno de entranda.
 * @author aalonso
 */

public class GestorLEEquitativo implements InterfazLectorEscritor{

	private boolean bloqueoEscritor = false;
	private boolean bloqueoLector   = false;
	private int  nEscritoresEsperando = 0;
	private int  nLectoresEsperando   = 0;
	private boolean turnoEscritor     = true;
	private int  nLectores = 0;

	public synchronized void permisoLeer(int idLector) 
			throws InterruptedException { 
		
		if (bloqueoEscritor || (nEscritoresEsperando > 0 && turnoEscritor))
			System.out.println("LLLLL La hebra lectora " + idLector + " se ha bloqueado");

		nLectoresEsperando ++;
		while (bloqueoEscritor || (nEscritoresEsperando > 0 && turnoEscritor)) { wait(); }
		nLectoresEsperando --;
		bloqueoLector = true;
		nLectores ++;
		turnoEscritor = true;
		
		System.out.println("L>>>> La hebra lectora " + idLector + " tiene permiso para leer");
	}

	public synchronized void permisoEscribir(int idEscritor) 
			throws InterruptedException{
		
		if (bloqueoEscritor || bloqueoLector 
				|| (nLectoresEsperando > 0 && !turnoEscritor))
			System.out.println("EEEEE La hebra escritora " + 
				idEscritor + " se ha bloqueado");
		
		nEscritoresEsperando ++;
		while (bloqueoEscritor || bloqueoLector 
				|| (nLectoresEsperando > 0 && !turnoEscritor)) { wait(); }
		nEscritoresEsperando --;
		bloqueoEscritor = true;
		turnoEscritor = false;
		
		System.out.println("E>>>> La hebra escritora " + idEscritor + 
				" tiene permiso para escribir");
	}

	public synchronized void finLeer(int idLector){
		System.out.println("L<<<< La hebra lectora " + idLector + 
				" ha terminado de leer");
		
		nLectores --;
		if (nLectores == 0) {
			bloqueoLector = false;
			notifyAll();
		}
	}

	public synchronized void finEscribir(int idEscritor) {
		
		System.out.println("E<<<< La hebra escritora " + idEscritor + 
				" ha terminado de escribir");
		
		bloqueoEscritor = false;
		notifyAll();
	}
}