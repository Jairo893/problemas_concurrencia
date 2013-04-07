package es.upm.dit.adsw.productorConsumidor;

public class ColaSincronizada {
  
    int[] Caja;  
    int Primero, Ultimo, Numero;
    
    public ColaSincronizada(int Longitud) {
	Caja= new int[Longitud];
        Primero = 0;
	Ultimo = 0;
	Numero = 0;
    }

    public synchronized void Pon(int X) throws InterruptedException {
	while (Numero == Caja.length) wait();
	Caja[Ultimo] = X; 
        Ultimo = (Ultimo + 1) % Caja.length;
	++Numero;
	notifyAll();
    }
    
    public synchronized int Toma() throws InterruptedException {
	while (Numero == 0) wait();
	int X = Caja[Primero]; 
	Primero = (Primero + 1) % Caja.length;
	--Numero;
	notifyAll();
	return X;
    } 
}
