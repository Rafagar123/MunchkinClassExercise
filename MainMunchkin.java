package munchkin;
import java.util.ArrayList;


public class MainMunchkin {

	public static void main(String[] args) {

		ArrayList <Jugador> jugadores=new ArrayList<Jugador>();
		ArrayList <Tesoro> tesoroJuan = new ArrayList<Tesoro>();
		ArrayList <Tesoro> tesoroIvi = new ArrayList<Tesoro>();
		ArrayList <Tesoro> tesoroAle = new ArrayList<Tesoro>();
		Juego juego=new Juego();

		Jugador jugadorJuan = new Jugador ("Juan", 1, tesoroJuan);
		Jugador jugadorIvi = new Jugador ("Ivi", 1, tesoroIvi);
		Jugador jugadorAle = new Jugador ("Ale", 1, tesoroAle);

		jugadores.add(jugadorJuan);
		jugadores.add(jugadorIvi);
		jugadores.add(jugadorAle);
		juego.setJugadores(jugadores);
		
		juego.inicializarCartas();
		
		juego.jugar();
		

		
	
	}
	
}
