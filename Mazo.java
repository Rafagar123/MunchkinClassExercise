package munchkin;
import java.util.ArrayList;

public class Mazo {
	protected ArrayList<Carta> cartas;
	
	public Mazo(ArrayList cartas) {
		this.cartas=cartas;
	}
	
	public Mazo() {
		this.cartas= new ArrayList<Carta>();
	}
	
	public void addCarta(Carta carta) {
		this.cartas.add(carta);
	}
	
	public void mezclar() {
		java.util.Collections.shuffle(this.cartas);
	}
	
	public Carta robar(int num) {
		Carta cartaElegida;
		cartaElegida=this.cartas.get(num);
		this.cartas.remove(num);
		return cartaElegida;
	}
	
	
	public int getMazoSize() {
		return this.cartas.size();
	}
	
	
	
	
	
	public boolean estaVacio() {
		if(this.cartas.size()==0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
