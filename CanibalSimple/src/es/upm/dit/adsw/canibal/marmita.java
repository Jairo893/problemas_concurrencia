// Voy a quitar la restricci—n de que el que avisa coma primero, a ver como queda

package es.upm.dit.adsw.canibal;
public class marmita {
	private int capacidad;
	private int NRaciones = 0; //Inicialmente la marmita está vacia
	private boolean primero = false;

	public marmita(int capacidad){
		this.capacidad = capacidad;
	}

	public synchronized void comer(int id){

		if (NRaciones == 0) {
			System.out.println("El canibal " + id + " se para. La marmita est'a vaci'a");
		}

		if (primero && NRaciones == 0) {
			notifyAll();
			primero = false;
			System.out.println("El canibal " + id + " avisa al cocinero");
		}

		try {
			while (NRaciones == 0) {
				wait();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("Come canibal " + id + " " + NRaciones);
		NRaciones = NRaciones - 1;
		notifyAll();
	}

	public synchronized void rellenar(){
		try{
			while (NRaciones > 0) wait();
		}  catch(InterruptedException ie){}

		System.out.println("Rellena el cocinero ");
		NRaciones = capacidad;
		primero = true;
		notifyAll();
	}

}
