package es.upm.dit.adsw.LectoresEscritores;

public class PruebaLE {

        public static void main(String[] args) {
                
                final int nLectores     = 10;
                final int nEscritores   =  8;
                InterfazLectorEscritor  elGestor  = new GestorLE();
                //InterfazLectorEscritor  elGestor  = new GestorLEEquitativo();
                //InterfazLectorEscritor  elGestor  = new GestorLEPrioridadEscritores();
                Lector[]   losLectores   = new Lector[nLectores];
                Escritor[] losEscritores = new Escritor[nEscritores];
                                
                for (int i = 0; i < nEscritores; i++ ) {
                        losEscritores[i] = new Escritor(elGestor, i);
                        losEscritores[i].start();
                }
                for (int i = 0; i < nLectores; i++ ) {
                        losLectores[i] = new Lector(elGestor, i);
                        losLectores[i].start();
                }
        }
}

