package es.studium.wordle;


public class Principal
{

	static int letrasPorPalabra;

	public static void main(String[] args)
	{
		VistaMainMenu mainMenu = new VistaMainMenu();
		Modelo modelo = new Modelo(letrasPorPalabra);
		new Controlador(mainMenu, modelo);
	}

}
