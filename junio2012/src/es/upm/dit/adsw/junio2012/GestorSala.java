package es.upm.dit.adsw.junio2012;

public class GestorSala {

	private int nPersonas = 0;
	private int nMaxPersonasNormalT = 50;
	private int nMaxPersonasAltaT   = 35;
	private int nMaxPersonas = nMaxPersonasNormalT;
	private int tUmbral = 30;
	private int nJubilados = 0;

	public synchronized void entrarSalaJubilado()
			throws InterruptedException {
		nJubilados ++;
		while (nPersonas >= nMaxPersonas) {
			wait();
		}
		nJubilados --;
		nPersonas ++;
	}

	public synchronized void entrarSala ()
			throws InterruptedException {
		while (nPersonas >= nMaxPersonas || nJubilados > 0)
		{
			// Espero si no pueden entrar m'as personas
			wait();
		}
		nPersonas++;
	}

	public synchronized void salirSala ()
			throws InterruptedException {
		nPersonas--;
		notifyAll();
	}

	public synchronized void notificarTemperatura (int temperatura)
	{
		if (temperatura > tUmbral) nMaxPersonas = nMaxPersonasAltaT;
		if (temperatura < tUmbral) nMaxPersonas = nMaxPersonasNormalT;
	}
}