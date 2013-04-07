package es.upm.dit.adsw.productorConsumidor;

public class Productor extends Thread {
    
    ColaSincronizada cs;
    int Id;
    
    public Productor(ColaSincronizada cs, int id) {
	this.cs=cs;
	this.Id=id;
    }
    
    public void run() {
	for (int i=1; i <= 20; i++) 
	    try {
		cs.Pon(i+Id);
		System.out.println("---- Productor "+Id+" produce "+(i+Id));
		Thread.sleep(Id);
	    } catch (Exception e) {}
    }
    
}

