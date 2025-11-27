package munchkin;

public class Monstruo extends Carta implements EfectoCarta{
	
	protected int nivelMonstruo;
	protected int recompensaNivel;

	
	public Monstruo (String nombre, int nivelMonstruo, int recompensaNivel) {
		super(nombre);
		this.nivelMonstruo=nivelMonstruo;
		this.recompensaNivel=recompensaNivel;
	}
	
	
	@Override
	public String toString() {
		return "El monstruo "+ nombre + "(nivel=" + nivelMonstruo + ", recompensa=" + recompensaNivel + ")";
	}



	public Monstruo () {
		super();
		this.nivelMonstruo=0;
		this.recompensaNivel=0;
	}
	
	
	@Override
	public  void ejecutar(Jugador jugador, Juego juego) {
		if(this.nivelMonstruo > jugador.getFuerza()) {
				if(jugador.nivel>1) {
			jugador.bajarNivel(1);
			System.out.println("El jugador ha bajado un nivel");
				}else {
			System.out.println("El jugador no puede bajar más niveles");
				}
			
		}else {
			jugador.subirNivel(recompensaNivel);
			juego.robarTesoro(jugador);
			System.out.println("El jugador ha subido " + this.recompensaNivel+" nivel/es, y ha recibido un tesoro");

		}
	}

	@Override
	public void aplicarEfecto(Jugador jugador, Juego juego) {
		ejecutar(jugador, juego);
	}

}
