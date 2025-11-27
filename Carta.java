package munchkin;

public abstract class Carta {
	protected String nombre;

	public Carta (String nombre) {
		this.nombre=nombre;
	}

	public Carta() {
		this.nombre="";
	}

	public String getNombre() {
		return this.nombre;
	}

	public abstract void aplicarEfecto(Jugador jugador, Juego juego);

}
