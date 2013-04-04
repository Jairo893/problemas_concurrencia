package es.upm.dit.adsw.LectoresEscritores;

/**
 * @author aalonso
 *
 * Interfaz con las operaciones necesarias para gestionar un conjunto
 * de hebras lectoras y escritoras
 */
public interface InterfazLectorEscritor {
   
	/**
	 * M'etodo que invoca una hebra lectora antes de comenzar a leer
	 */
	public void permisoLeer(int idLector) throws InterruptedException;
   
	/**
	 * M'etodo que invoca una hebra escritora antes de comenzar a escribir
	 */
	public void permisoEscribir(int idEscritor) throws InterruptedException;
  
	/**
	 * MŽtodo que invoca una hebra lectora al terminar de leer
	 */
	public void finLeer(int idLector);
   
	/**
	 * MŽtodo que invoca una hebra lectora al terminar de escribir
	 */
	public void finEscribir(int idEscritor);
}
