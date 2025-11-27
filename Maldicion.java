package munchkin;

public class Maldicion extends Carta implements EfectoCarta{

	protected String descripcion;

	public Maldicion (String nombre, String descripcion) {
		super(nombre);	
		this.descripcion = descripcion;
	}

	public Maldicion () {
		super();	
		this.descripcion = "";
	}

	@Override
	public void ejecutar (Jugador jugador, Juego juego) {
		if (jugador.nivel>1) {
			jugador.bajarNivel(1);
		} else if (jugador.nivel==1 && jugador.tesoros.size()>0) {
			jugador.removerTesoroAleatorio();
		}
	}

	@Override
	public void aplicarEfecto (Jugador jugador, Juego juego) {
		ejecutar(jugador, juego);		
	}



	@Override
	public String toString() {
		return nombre + " (" + descripcion + ")";
	}


}
