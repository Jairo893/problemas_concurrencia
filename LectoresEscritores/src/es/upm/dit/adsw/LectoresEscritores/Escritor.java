package es.upm.dit.adsw.LectoresEscritores;

import java.util.Random;

public class Escritor extends Thread{

	InterfazLectorEscritor elGestor;
	int escritorId;
    Random randomGenerator = new Random();

	public Escritor(InterfazLectorEscritor elGestor, int escritorId){
		this.elGestor = elGestor;
		this.escritorId = escritorId;
	}

	public void run(){
		try {
			while(true) {
                Thread.sleep(randomGenerator.nextInt(3000));
				elGestor.permisoEscribir(escritorId);
                Thread.sleep(randomGenerator.nextInt(3000));
				elGestor.finEscribir(escritorId);
			}       
		}catch(InterruptedException ie){return;}
	}

}
