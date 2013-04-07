package es.upm.dit.adsw.productorConsumidor;

public class Consumidor extends Thread {

    ColaSincronizada cs;
    int Id;
    
    public Consumidor(ColaSincronizada cs, int id) {
	this.cs=cs;
	this.Id=id;
    }
    
    public void run() {
	for (int i=1; i <= 20; i++) 
	    try {
		int Dato=cs.Toma();
		System.out.println("**** Consumidor "+Id+" consume "+Dato);
		Thread.sleep(Id);
	    } catch (Exception e) {}
    }
    
 }

