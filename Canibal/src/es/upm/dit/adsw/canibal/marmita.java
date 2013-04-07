package es.upm.dit.adsw.canibal;

public class marmita {
	private int capacidad;
	private int NRaciones = 0; //Inicialmente la marmita está vacia
	private boolean vacio = false;
	
	public marmita(int capacidad){
		this.capacidad = capacidad;
	}

	public synchronized void comer(int id){
		try{
			if (vacio)
				System.out.println("El canibal " + id + " se para. La marmita est‡ vac’a");
			while (vacio) wait();
		} catch(InterruptedException ie){}

		if (NRaciones == 0) {
			System.out.println("El canibal " + id + " avisa al cocinero");
			vacio = true;
			notifyAll();
			try{
				while (NRaciones == 0) wait();
			}catch(InterruptedException ie){}
			vacio = false;
			System.out.println("Come canibal " + id + " " + NRaciones);
			NRaciones = NRaciones - 1;
			notifyAll();
		}
		else {
			System.out.println("Come canibal " + id + " " + NRaciones);
			NRaciones = NRaciones - 1;
		}
	}
	
	public synchronized void rellenar(){
		try{
			// No se deja s—lo NRaciones > 0 para que solo
			// se rellene la marmita cuando un canibal se 
			// da cuenta de que est'a vacia
			// Se a–ade NRaciones == 0 para asegurar que el
			// cocinero no se adelante al canibal si se da mucha 
			//prisa y la gesti—n de las colas lo permite.
			while (!vacio || NRaciones > 0) wait();
		}  catch(InterruptedException ie){}

		System.out.println("Rellena el cocinero ");
		NRaciones = capacidad;
		notifyAll();
	}
	
}
