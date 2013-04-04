package es.upm.dit.adsw.LectoresEscritores;


/** Monitor para gestionar a un conjunto de hebras lectoras y escritoras.
 * Ninguna tiene prioridad frente a las otras. Si hay lectores continuamente
 * entrando, los escritores nunca entrar‡n: situaci—n de hambruna.
 * @author aalonso
 */

public class GestorLE implements InterfazLectorEscritor{

	private boolean bloqueoEscritor = false;
	private boolean bloqueoLector   = false;
	private int  nLectores = 0;

	public synchronized void permisoLeer(int idLector) 
			throws InterruptedException {
		
		if (bloqueoEscritor)
			System.out.println("LLLLL La hebra lectora " + idLector + 
					" se ha bloqueado");

		while (bloqueoEscritor) {wait();}
		bloqueoLector = true;
		nLectores ++;
		
		System.out.println("L>>>> La hebra lectora " + idLector + 
				" tiene permiso para leer");
	}

	public synchronized void permisoEscribir(int idEscritor) 
			throws InterruptedException{
		
		if (bloqueoEscritor || bloqueoLector)
			System.out.println("EEEEE La hebra escritora " + idEscritor + 
					" se ha bloqueado");
		
		while (bloqueoEscritor || bloqueoLector){wait();}
		bloqueoEscritor = true;
		
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