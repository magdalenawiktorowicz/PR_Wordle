package es.studium.wordle;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener, ItemListener
{
	Modelo modelo;
	VistaMainMenu vistaMainMenu;
	VistaEntre vistaEntre;
	VistaGame vistaGame;
	VistaRanking vistaRanking;

	String nickname;
	int letrasPorPalabra;
	String userWord;
	String randomWord;
	String[] userWordLetras;
	String[] randomWordLetras;
	int intentos;
	int puntos;
	int fila;

	Dialog dlgMensajeError;
	Dialog dlgGameOver;

	public Controlador(VistaMainMenu vistaMainMenu, Modelo modelo)
	{
		this.vistaMainMenu = vistaMainMenu;
		this.modelo = modelo;

		this.vistaMainMenu.addWindowListener(this);
		this.vistaMainMenu.btnNewGame.addActionListener(this);
		this.vistaMainMenu.btnRanking.addActionListener(this);
		this.vistaMainMenu.btnHelp.addActionListener(this);
		this.vistaMainMenu.btnExit.addActionListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// cuando estamos en vistaMainMenu
		if (vistaMainMenu != null && vistaMainMenu.isActive())
		{
			// al pulsar el botón de nuevo juego
			if (e.getSource().equals(vistaMainMenu.btnNewGame))
			{
				// Acción para el botón "NEW GAME" - instanciar la vistaEntre & añadir los listeners
				vistaEntre = new VistaEntre();
				vistaEntre.addWindowListener(this);
				vistaEntre.btnBack.addActionListener(this);
				vistaEntre.btnOK.addActionListener(this);
				vistaEntre.letterChoice.addItemListener(this);
				vistaEntre.dlgAvisoNick.addWindowListener(this);
				System.out.println("Clicked NEW GAME");
			} else if (e.getSource().equals(vistaMainMenu.btnRanking))
			{
				// Acción para el botón "RANKING" - instanciar la vistaRanking & añadir los listeners
				vistaRanking = new VistaRanking();
				vistaRanking.addWindowListener(this);
				vistaRanking.btnBack.addActionListener(this);
				System.out.println("Clicked RANKING");
			} else if (e.getSource().equals(vistaMainMenu.btnHelp))
			{
				// Acción para el botón "HELP" - abrir html con ayuda
				System.out.println("Clicked HELP");
				modelo.ayuda();
			} else if (e.getSource().equals(vistaMainMenu.btnExit))
			{
				// Acción para el botón "EXIT" - cerrar la ventana
				System.out.println("Clicked EXIT");
				System.exit(0);
			}
		// cuando estamos en vistaEntre
		} else if (vistaEntre != null && vistaEntre.isActive())
		{
			// salir de la vistaEntre con 'Back'
			if (e.getSource().equals(vistaEntre.btnBack))
			{
				vistaEntre.setVisible(false);
			// al pulsar el botón 'OK' en vistaEntre
			} else if (e.getSource().equals(vistaEntre.btnOK))
			{
				// si no se introduce el nombre o si no se selecciona el número de las letras
				if (vistaEntre.txtNick.getText().length() == 0 || vistaEntre.letterChoice.getSelectedIndex() == 0)
				{
					// mostrar el diálogo de aviso
					vistaEntre.dlgAvisoNick.setVisible(true);
				// al introducir el nombre y elegir el número de las letras en la palabra secreta
				} else
				{
					nickname = vistaEntre.txtNick.getText();
					// instanciar la vistaGame pasándole el parámetro del número de las letras elegidas & añadir los listeners
					vistaGame = new VistaGame(vistaEntre.letterChoice.getSelectedIndex() + 2);
					vistaGame.addWindowListener(this);
					vistaGame.btnAyuda.addActionListener(this);
					vistaGame.btnOK.addActionListener(this);
					vistaGame.dlgMensajeError.addWindowListener(this);
					vistaGame.dlgGameOver.addWindowListener(this);
					vistaGame.btnNewGame.addActionListener(this);
					// obtener la palabra secreta
					randomWord = modelo.obtenerPalabraAleatoria(vistaEntre.letterChoice.getSelectedIndex() + 2);
					intentos = 5;
					puntos = 1;
					fila = 0;
				}
			}
		// cuando estamos en la vistaRanking y pulsamos 'back'
		} else if (vistaRanking != null && vistaRanking.isActive())
		{
			if (e.getSource().equals(vistaRanking.btnBack))
			{
				vistaRanking.setVisible(false);
			}
		}
		// cuando estamos en la vista del juego
		else if (vistaGame != null && vistaGame.isActive())
		{
			// obtener la palabra del jugador y ponerla a minúsculas
			userWord = vistaGame.txtInput.getText().toLowerCase();
			// convertir la palabra del jugador y la palabra secreta de String a un array
			userWordLetras = userWord.split("");
			randomWordLetras = randomWord.split("");

			// si la palabra del jugador no está de la misma longitud y pulsa el 'OK'
			if ((userWord.length() != randomWord.length()) && (e.getSource().equals(vistaGame.btnOK)))
			{
				vistaGame.lblMensajeError.setText("You must insert a correct word.");
				vistaGame.mostrarMensajeError();
			//cuando las palabras están de la misma longitud y todavía hay intentos
			} else if ((userWord.length() == randomWord.length()) && (e.getSource().equals(vistaGame.btnOK))
					&& (intentos > 0))
			{
				// establecer las coordinadas y
				int y = 100 +(fila*60);
				// recorrer cada fila para mostrar las palabras del jugador
				for (int r = fila; r < 5; r++)
				{
					// establecer las coordinadas z (x)
					int z = 60;
					// asignar cada letra a un label de la vista y mostrarla
					vistaGame.lblLetra1.setBounds(z, y, 20, 20);
					vistaGame.lblLetra1.setText(userWordLetras[0]);
					vistaGame.add(vistaGame.lblLetra1);
					vistaGame.lblLetra2.setBounds(z * 2, y, 20, 20);
					vistaGame.lblLetra2.setText(userWordLetras[1]);
					vistaGame.add(vistaGame.lblLetra2);
					vistaGame.lblLetra3.setBounds(z * 3, y, 20, 20);
					vistaGame.lblLetra3.setText(userWordLetras[2]);
					vistaGame.add(vistaGame.lblLetra3);
					// en el caso de una palabra de 4 letras
					if (randomWord.length() == 4)
					{
						vistaGame.lblLetra4.setBounds(z * 4, y, 20, 20);
						vistaGame.lblLetra4.setText(userWordLetras[3]);
						vistaGame.add(vistaGame.lblLetra4);
					}
					// en el caso de una palabra de 5 letras
					if (randomWord.length() == 5)
					{
						vistaGame.lblLetra4.setBounds(z * 4, y, 20, 20);
						vistaGame.lblLetra4.setText(userWordLetras[3]);
						vistaGame.add(vistaGame.lblLetra4);
						vistaGame.lblLetra5.setBounds(z * 5, y, 20, 20);
						vistaGame.lblLetra5.setText(userWordLetras[4]);
						vistaGame.add(vistaGame.lblLetra5);
					}
					// en el caso de una palabra de 6 letras
					if (randomWord.length() == 6)
					{
						vistaGame.lblLetra4.setBounds(z * 4, y, 20, 20);
						vistaGame.lblLetra4.setText(userWordLetras[3]);
						vistaGame.add(vistaGame.lblLetra4);
						vistaGame.lblLetra5.setBounds(z * 5, y, 20, 20);
						vistaGame.lblLetra5.setText(userWordLetras[4]);
						vistaGame.add(vistaGame.lblLetra5);
						vistaGame.lblLetra6.setBounds(z * 6, y, 20, 20);
						vistaGame.lblLetra6.setText(userWordLetras[5]);
						vistaGame.add(vistaGame.lblLetra6);
					}
				}
				// cuando las palabras son iguales - victoria
				if (userWord.equals(randomWord))
				{
					// pintar cuadrados verdes
					for (int i = 0; i < userWord.length(); i++)
					{
						vistaGame.asignarVerde(i, fila);
					}
					// calcular puntos
					puntos = modelo.calcularPuntuacion(intentos);
					// mostrar el dialogo de victoria
					vistaGame.dlgGameOver.setBackground(new Color(194, 238, 134));
					vistaGame.dlgGameOver.setSize(320,180);
					vistaGame.lblMensajeGameOver.setText("Congratulations! You WON!");
					vistaGame.lblScore.setText("    Score: " + puntos + "\n");
					vistaGame.mostrarMensajeFinal();
					// llamar al método que guarda el resultado en BD
					modelo.guardarPuntuacion(nickname, puntos);
					// quitar el listener del botón 'OK'
					vistaGame.btnOK.removeActionListener(this);
				// la lógica de comprar las letras
				} else
				{
					// recorrer la palabra de usuario letra por letra
					for (int i = 0; i < userWordLetras.length; i++)
					{
						// cuando las letras están iguales y en la misma posición
						if (userWord.charAt(i) == randomWord.charAt(i))
						{
							// pintar el cuadrado correspondiente en verde
							vistaGame.asignarVerde(i, fila);
						}
						// cuando la letra aparece en la palabra pero no en esa posición
						if ((randomWord.contains(userWordLetras[i])) && (userWord.charAt(i) != randomWord.charAt(i)))
						{
							// pintar el cuadrado correspondiente amarillo
							vistaGame.asignarAmarillo(i, fila);
						}
						// cuando la letra no aparece en la palabra secreta
						if ((userWord.charAt(i) != randomWord.charAt(i)) && !(randomWord.contains(userWordLetras[i])))
						{
							// pintar el cuadrado correspondiente gris
							vistaGame.asignarGris(i, fila);
						}
					}
				}
				intentos--;
				++fila;
				// borrar la palabra introducida del textField
				vistaGame.limpiar();
				// cuando no queda más intentos y el jugador no ha adivinado la palabra
				if ((intentos == 0) && (!(userWord.equals(randomWord))))
				{
					// mostrar el diálogo de derrota
					vistaGame.dlgGameOver.setBackground(new Color(254, 233, 104));
					vistaGame.dlgGameOver.setSize(400, 150);
					vistaGame.lblMensajeGameOver.setText("You lost... The word was: " + randomWord);
					puntos = 0;
					vistaGame.lblScore.setText("    Score: " + puntos + "    \n");
					vistaGame.mostrarMensajeFinal();
					// guardar el resultado en BD
					modelo.guardarPuntuacion(nickname, puntos);
					// quitar el listener del botón
					vistaGame.btnOK.removeActionListener(this);
				}
			}
			// al pulsar el botón de ayuda en la vistaGame
			else if (vistaGame != null && vistaGame.isActive() && e.getSource().equals(vistaGame.btnAyuda)) {
				modelo.ayuda();
			}
		}
		// al pulsar el botón de nuevo juego desde el diálogo de victoria o derrota
		else if (vistaGame.dlgGameOver != null && vistaGame.dlgGameOver.isActive() && e.getSource().equals(vistaGame.btnNewGame)) {
			vistaGame.dlgGameOver.setVisible(false);
			vistaGame.setVisible(false);
			vistaEntre.setVisible(false);
			vistaEntre = new VistaEntre();
			vistaEntre.addWindowListener(this);
			vistaEntre.btnBack.addActionListener(this);
			vistaEntre.btnOK.addActionListener(this);
			vistaEntre.letterChoice.addItemListener(this);
		}
	}

	@Override
	public void windowOpened(WindowEvent e){}

	@Override
	public void windowClosing(WindowEvent e)
	{
		if (vistaMainMenu != null && vistaMainMenu.isActive())
		{
			vistaMainMenu.setVisible(false);
		} else if (vistaEntre != null && vistaEntre.isActive())
		{
			vistaEntre.setVisible(false);
		} else if (vistaGame != null && vistaGame.isActive())
		{
			vistaGame.setVisible(false);
		} else if (vistaRanking != null && vistaRanking.isActive())
		{
			vistaRanking.setVisible(false);
		} else if (vistaEntre.dlgAvisoNick != null && vistaEntre.dlgAvisoNick.isActive()) {
			vistaEntre.dlgAvisoNick.setVisible(false);
		} else if (vistaGame.dlgMensajeError != null && vistaGame.dlgMensajeError.isActive())
		{
			vistaGame.dlgMensajeError.setVisible(false);
		} else if (vistaGame.dlgGameOver != null && vistaGame.dlgGameOver.isActive()) {
			vistaGame.dlgGameOver.setVisible(false);
		}	
		else
		{
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
