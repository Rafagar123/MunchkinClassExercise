package munchkin;
import java.util.ArrayList;
import java.util.Random;

public class Juego {

	protected ArrayList<Jugador> jugadores;
	protected Mazo mazoPuerta;
	protected Mazo mazoTesoro;
	protected int ronda = 1;
	protected boolean terminado = false;
	protected String [] colorJugador = {"\033[32m", "\033[33m", "\033[34m", "\033[35m", "\033[36m", "\033[31m"};
	protected String colorActual;
	protected int colorContador = 0;

	Random aleatorio = new Random();

	public Juego (ArrayList<Jugador> jugadores, Mazo mazoPuerta, Mazo mazoTesoro) {
		this.jugadores = jugadores;
		this.mazoPuerta = mazoPuerta;
		this.mazoTesoro = mazoTesoro;
	}
	
	public Juego() {
		this.jugadores = new ArrayList<Jugador>();
		this.mazoPuerta = new Mazo();
		this.mazoTesoro = new Mazo();
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores (ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void inicializarCartas() {
		mazoTesoro.addCarta(new Tesoro("Espada de fuego frío", TipoTesoro.ARMA, 1 ));
		mazoTesoro.addCarta(new Tesoro("Armadura de estrella", TipoTesoro.ARMADURA, 2 ));
		mazoTesoro.addCarta(new Tesoro("Guantes de garra de oso", TipoTesoro.ACCESORIO, 1 ));
		mazoTesoro.addCarta(new Tesoro("Pócima de hipersalud", TipoTesoro.ACCESORIO, 1 ));
		mazoTesoro.addCarta(new Tesoro("Grillo celestial de la suerte", TipoTesoro.ACCESORIO, 2 ));
		mazoTesoro.addCarta(new Tesoro("Flechas de diamante", TipoTesoro.ARMA, 1 ));
		mazoTesoro.addCarta(new Tesoro("Sable tiránico", TipoTesoro.ARMA, 2 ));
		mazoTesoro.addCarta(new Tesoro("Cota de lava", TipoTesoro.ARMADURA, 1 ));
		mazoTesoro.addCarta(new Tesoro("Casco y espuelas del rey Arturo", TipoTesoro.ARMADURA, 1 ));
		mazoPuerta.addCarta(new Monstruo("Hidra de una cabeza", 1, 1 ));
		mazoPuerta.addCarta(new Monstruo("Perro oloroso", 1, 1 ));
		mazoPuerta.addCarta(new Monstruo("Tu tío de Matalascañas", 1, 2 ));
		mazoPuerta.addCarta(new Monstruo("Toalla que nunca seca bien", 1, 1 ));
		mazoPuerta.addCarta(new Monstruo("Gallina bicéfala", 1, 1 ));
		mazoPuerta.addCarta(new Monstruo("Gato de escayola", 1, 2 ));
		mazoPuerta.addCarta(new Monstruo("Arturo Perez Reverte", 1, 2 ));
		mazoPuerta.addCarta(new Monstruo("León de Nivea", 2, 2 ));
		mazoPuerta.addCarta(new Monstruo("Gorrión muy muy malvado", 2, 2 ));
		mazoPuerta.addCarta(new Monstruo("Pajarito chonco", 3, 1 ));
		mazoPuerta.addCarta(new Monstruo("Gusano morado feo fluorescente", 4, 2 ));
		mazoPuerta.addCarta(new Monstruo("El Ayuwoki", 6, 2 ));
		mazoPuerta.addCarta(new Monstruo("Madona", 6, 1 ));
		mazoPuerta.addCarta(new Monstruo("Rey emérito", 6, 1 ));
		mazoPuerta.addCarta(new Monstruo("Satán made in Almería", 8, 2 ));
		mazoPuerta.addCarta(new Monstruo("Satán made in Armilla", 7, 1 ));
		mazoPuerta.addCarta(new Monstruo("Michael Jackson", 5, 2 ));
		mazoPuerta.addCarta(new Monstruo("Votante de vox", 1, 1 ));
		mazoPuerta.addCarta(new Monstruo("El monstruo raro de Stranger Things", 2, 2));
		mazoPuerta.addCarta(new Monstruo("Fosquito caducado", 3, 2 ));
		mazoPuerta.addCarta(new Monstruo("Hada madrina rácana", 4, 1 ));
		mazoPuerta.addCarta(new Monstruo("Carmen Ayuso desquiciada", 1, 1 ));
		mazoPuerta.addCarta(new Maldicion("Maldición del hombre feo", "Te vuelves feo" ));
		mazoPuerta.addCarta(new Maldicion("Maldición de la Nocilla", "Cantas la canción de la Nocilla y te vueles esquizofrénico" ));
		mazoPuerta.addCarta(new Maldicion("Maldición del paparajote", "Paparajotes hasta la extenuación" ));
		mazoPuerta.addCarta(new Maldicion("Maldición de la perdiz", "Bibidibabidibú: ya no eres feliz" ));
		mazoPuerta.addCarta(new Maldicion("Maldición del cumpleaños sin amigos", "Los invitaste a todos, y nadie apareció" ));
		mazoPuerta.addCarta(new Maldicion("Maldición del kebab malo", "Ya sabes lo que va a pasar, y no será nada bueno" ));
		mazoPuerta.addCarta(new Maldicion("Maldición de la UGR", "No volverás a ser igual" ));
		mazoPuerta.addCarta(new Maldicion("Maldición de Quevedo", "Todas las canciones te sonarán a Quevedo" ));
		mazoPuerta.addCarta(new Maldicion("Maldición del pan con pasas", "Creíste que era chocolate, y creíste mal" ));
		mazoPuerta.addCarta(new Maldicion("Maldición de la bruja deficiente", "Te jode, pero no mucho" ));
		mazoPuerta.addCarta(new Maldicion("Maldición del vino del mercadona", "Prepárate para esta noche" ));

		mazoPuerta.mezclar();
		mazoTesoro.mezclar();
	}
	
	public void robarTesoro (Jugador jugador) {
		int num = aleatorio.nextInt(mazoTesoro.getMazoSize());
		jugador.recibirTesoro((Tesoro) mazoTesoro.robar(num));
	}

	public Carta robarPuerta () {
		int num = aleatorio.nextInt(mazoPuerta.getMazoSize());
		return mazoPuerta.robar(num);
	}

	public void intentarRobo (Jugador jugadorActual) {
		int numAleatorio = aleatorio.nextInt(3);
		int numJugador =aleatorio.nextInt(this.jugadores.size());
		Jugador jugadorRobado=this.jugadores.get(numJugador);

		if(numAleatorio==1 && jugadorRobado.tesoros.size()!=0 && jugadorRobado!=jugadorActual) {
			jugadorActual.tesoros.add(jugadorRobado.tesoros.get(0));
			System.out.println ("!!!!!!! " + jugadorActual.nombre + " ha robado a " + jugadorRobado.nombre + " la carta de tesoro: " + jugadorRobado.tesoros.get(0));
			jugadorRobado.tesoros.remove(0);
		}

	}

	public void jugar() {

		do {
			System.out.println("*******************************************RONDA " + ronda + "***********************************************************************************************");
			System.out.println();
			for(Jugador jugadorActual : jugadores) {
				
				if(colorContador == colorJugador.length || jugadorActual == jugadores.get(0)) {
					colorContador = 0;
				}
				
				colorActual = colorJugador[colorContador];
				
				if(!terminado) {
					
					Carta cartaActual = robarPuerta();
					Juego juegoActual = new Juego(this.jugadores, this.mazoPuerta, this.mazoTesoro);

					System.out.println(colorActual + " >>>>>>>>>>>>>>>>>>>> Es el turno de " + jugadorActual.nombre + ", con nivel " + jugadorActual.nivel + " y tesoros " + jugadorActual.tesoros.size());
					System.out.println("La puerta que ha abierto es: ");

					if (cartaActual instanceof Monstruo) {
						System.out.println(cartaActual.toString());
						cartaActual.aplicarEfecto(jugadorActual, juegoActual);

					} else if (cartaActual instanceof Maldicion){
						System.out.println(cartaActual.toString());
						cartaActual.aplicarEfecto(jugadorActual, juegoActual);
					}

					intentarRobo(jugadorActual);
					
					System.out.println();

					jugadorActual.infoJugador();

					if (jugadorActual.haGanado()) {
						terminado = true;
						System.out.println(" *^(·_·)^* " + jugadorActual.nombre + " ha ganado! *^(·_·)^*");
					}

					if (mazoPuerta.estaVacio() || mazoTesoro.estaVacio()) {
						terminado = true;
						System.out.println("No se puede seguir jugando porque uno de los mazos se ha agotado");
					}
					
					System.out.println("\033[0m");

				}
				
				colorContador += 1;
			}

			ronda = ronda + 1;

		} while (!terminado);

		System.out.println("La partida ha terminado");

	}

}
