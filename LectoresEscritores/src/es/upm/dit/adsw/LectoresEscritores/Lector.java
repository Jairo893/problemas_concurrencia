package es.upm.dit.adsw.LectoresEscritores;

import java.util.Random;

public class Lector extends Thread{
    
    InterfazLectorEscritor elGestor;
    int lectorId;
    Random randomGenerator = new Random();
    
    public Lector(InterfazLectorEscritor elGestor, int lectorId){
            this.elGestor = elGestor;
            this.lectorId = lectorId;
    }
    
    public void run(){
            try {
                    while(true) {
                            Thread.sleep(randomGenerator.nextInt(3000));
                            elGestor.permisoLeer(lectorId);
                            Thread.sleep(randomGenerator.nextInt(1500));
                            elGestor.finLeer(lectorId);
                    }       
            }catch(InterruptedException ie){return;}
    }

}


