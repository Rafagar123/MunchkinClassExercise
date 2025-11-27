package munchkin;
import java.util.ArrayList;
import java.util.Random;

public class Jugador {
	protected String nombre;
	protected int nivel;
	protected ArrayList <Tesoro> tesoros;

	public Jugador(String nombre, int nivel, ArrayList<Tesoro> tesoros) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.tesoros = tesoros;
	}

	public Jugador() {
		this.nombre = "";
		this.nivel = 1;
		this.tesoros = new ArrayList<Tesoro>();
	}

	public int getFuerza() {
		int sumaBonus=0;
		for (Tesoro tesoroActual : tesoros) {
			sumaBonus += tesoroActual.bonus;
		}
		return sumaBonus + this.nivel;
	}

	public void subirNivel (int num) {
		this.nivel=this.nivel+num;
	}

	public void bajarNivel (int num) {
		this.nivel=this.nivel-num;
	}
	
	public void recibirTesoro (Tesoro tesoro) {
		this.tesoros.add(tesoro);
	}

	public void removerTesoroAleatorio() {
		Random aleatorio = new Random();
		
		int num= aleatorio.nextInt(this.tesoros.size());
		this.tesoros.remove(num);
	}


	public boolean haGanado() {
		if (this.nivel>=5) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return  nombre + ", nivel " + nivel + ", tesoros " + tesoros+ " )";
	}

	public void infoJugador() {
		System.out.println("Info del jugador en esta ronda:" +toString());
	}


} 
