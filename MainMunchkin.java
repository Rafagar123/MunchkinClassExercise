package munchkin;
import java.util.ArrayList;
import java.util.Scanner;


public class MainMunchkin {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		int numJugadores = scan.nextInt();
		ArrayList <Jugador> jugadores=new ArrayList<Jugador>(numJugadores);
		
		System.out.println("Introduzca el número de jugadores: ");

		for (int i=0; i < numJugadores; i++) {
			System.out.println("Introduzca el jugador: ");
			String nombreJugador=scan2.nextLine();
			ArrayList <Tesoro> tesoroJugador = new ArrayList<Tesoro>();
			Jugador jugadorActual = new Jugador(nombreJugador, 1, tesoroJugador);
			jugadores.add(jugadorActual);
		}
		
		scan.close();
		scan2.close();

		System.out.println();
		System.out.println("Los jugadores de esta partida son: ");

		for (Jugador jugadorActual : jugadores) {
			System.out.println(jugadorActual);
		}
		
		System.out.println();

		Juego juego=new Juego();

		juego.setJugadores(jugadores);

		juego.inicializarCartas();

		juego.jugar();

	}

}
