package es.upm.dit.adsw.canibal;
public class cocinero extends Thread{
	
	marmita laMarmita;
	int retardo = 1000;
	
	public cocinero (marmita laMarmita) {
		this.laMarmita = laMarmita;
	}
	
	public void run () {
		while(true){
		laMarmita.rellenar();
		try{
			Thread.sleep(retardo);
		} catch(InterruptedException ie){}
	}
	}
}
