package es.upm.dit.adsw.canibal;
public class tribuCanibales {

	public static void main(String[] args) {

		int nRacionesMax = 4;
		int tamanoTribu  = 5;
		
		marmita laMarmita = new marmita(nRacionesMax);
		
		cocinero elCocinero = new cocinero (laMarmita);
		elCocinero.start();
		
		canibal[] canibales  = new canibal[tamanoTribu];		
		for (int i = 0; i < tamanoTribu; i++){
			try{
				Thread.sleep(1000);
				canibales[i] = new canibal(laMarmita, i);
				canibales[i].start();
			}catch(InterruptedException ie){}
		}
	}

}
