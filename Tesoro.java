package munchkin;


public class Tesoro extends Carta{
	
	protected TipoTesoro tipoTesoro;
	protected int bonus;


	public Tesoro (String nombre, TipoTesoro tipoTesoro, int bonus) {
		super(nombre);
		this.tipoTesoro = tipoTesoro;
		this.bonus = bonus;
	}
	public Tesoro() {
		super();
		this.tipoTesoro = TipoTesoro.ACCESORIO;
		this.bonus = 0;
	}


	@Override
	public void aplicarEfecto (Jugador jugador, Juego juego) {
		Tesoro tesoroNuevo = new Tesoro(this.nombre, this.tipoTesoro, this.bonus);
		jugador.recibirTesoro(tesoroNuevo);
	}

	@Override
	public String toString() {
		return nombre + " (tipoTesoro=" + tipoTesoro + ", bonus= " + bonus + ")";
	}

}
