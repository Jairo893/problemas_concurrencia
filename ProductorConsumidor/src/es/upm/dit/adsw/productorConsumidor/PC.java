package es.upm.dit.adsw.productorConsumidor;

public class PC  {
 
    static final int Longitud = 5;
 
    public static void main(String[] args) {
	
	ColaSincronizada cs= new ColaSincronizada(Longitud);

   	Productor p= new Productor(cs, 1000);
	Consumidor c= new Consumidor(cs, 5000);

	p.start();
	c.start();
    }
}
