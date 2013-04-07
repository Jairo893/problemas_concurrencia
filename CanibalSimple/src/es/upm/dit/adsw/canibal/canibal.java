package es.upm.dit.adsw.canibal;
public class canibal extends Thread{

	marmita laMarmita; 
	int     id;
	int     retardo = 3000;

	public canibal (marmita laMarmita, int id) {
		this.laMarmita = laMarmita;
		this.id        = id;
	}

	public void run(){
		while (true) {
			try{
				Thread.sleep(retardo);
			} catch(InterruptedException ie){}

			laMarmita.comer(id);  

		}
	}
}
