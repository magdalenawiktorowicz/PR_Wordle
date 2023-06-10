package es.studium.wordle;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class VistaGameTest extends Frame
{
	private static final long serialVersionUID = 1L;

	Font font = new Font("Times New Roman", Font.BOLD, 26);
	Font font2 = new Font("Forte", Font.BOLD, 20);
	Font font3 = new Font("Times New Roman", Font.BOLD, 22);
	String ayuda = "?";
	Button btnAyuda = new Button(ayuda);
	Button btnOK = new Button("OK");
	Label lblInput = new Label("Write a word: ");
	TextField txtInput = new TextField(50);

	Image backgroundImage;
	Toolkit tool;
	String palabraUser;
	String[] palabraUserLetras;

	int letrasPorPalabra = 0;
	Modelo modelo = new Modelo(letrasPorPalabra);

	int x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22, x23, x24,
			x25, x26, x27, x28, x29, x30;
	int y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12, y13, y14, y15, y16, y17, y18, y19, y20, y21, y22, y23, y24,
			y25, y26, y27, y28, y29, y30;

	int fila;

	Color c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24,
			c25, c26, c27, c28, c29, c30;
	
	
	Dialog dlgMensajeError = new Dialog(this, "Error", true);
	Label lblMensajeError = new Label("");
	
	Label lblLetra1 = new Label("");
	Label lblLetra2 = new Label("");
	Label lblLetra3 = new Label("");
	Label lblLetra4 = new Label("");
	Label lblLetra5 = new Label("");
	Label lblLetra6 = new Label("");

	Dialog dlgGameOver = new Dialog(this, "Game Over", true);
	Label lblMensajeGameOver = new Label("");
	Label lblScore = new Label("");
	Button btnNewGame = new Button("New Game");
	

	public VistaGameTest(int i)
	{

		letrasPorPalabra = i;

		setLayout(null);
		btnAyuda.setBounds(390, 35, 40, 40);
		lblInput.setBounds(60, 400, 130, 30);
		txtInput.setBounds(200, 400, 150, 30);
		btnOK.setBounds(200, 450, 60, 30);
		btnAyuda.setFont(font);
		lblInput.setFont(font2);
		btnOK.setFont(font2);
		
		lblLetra1.setFont(font3);
		lblLetra2.setFont(font3);
		lblLetra3.setFont(font3);
		lblLetra4.setFont(font3);
		lblLetra5.setFont(font3);
		lblLetra6.setFont(font3);
		
		add(btnAyuda);
		add(btnOK);
		add(lblInput);
		add(txtInput);

		setBackground(new Color(205, 232, 198));
		setTitle("Wordle");
		setSize(450, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		

		c1 = Color.white;

		// fila 0
		x1 = 50;
		x2 = 110;
		x3 = 170;
		x4 = 230;
		x5 = 290;
		x6 = 350;
		y1 = 90;
		y2 = 90;
		y3 = 90;
		y4 = 90;
		y5 = 90;
		y6 = 90;

		// fila 1
		x7 = 50;
		x8 = 110;
		x9 = 170;
		x10 = 230;
		x11 = 290;
		x12 = 350;
		y7 = 150;
		y8 = 150;
		y9 = 150;
		y10 = 150;
		y11 = 150;
		y12 = 150;

		// fila 2
		x13 = 50;
		x14 = 110;
		x15 = 170;
		x16 = 230;
		x17 = 290;
		x18 = 350;
		y13 = 210;
		y14 = 210;
		y15 = 210;
		y16 = 210;
		y17 = 210;
		y18 = 210;

		// fila 3
		x19 = 50;
		x20 = 110;
		x21 = 170;
		x22 = 230;
		x23 = 290;
		x24 = 350;
		y19 = 270;
		y20 = 270;
		y21 = 270;
		y22 = 270;
		y23 = 270;
		y24 = 270;

		// fila 4
		x25 = 50;
		x26 = 110;
		x27 = 170;
		x28 = 230;
		x29 = 290;
		x30 = 350;
		y25 = 330;
		y26 = 330;
		y27 = 330;
		y28 = 330;
		y29 = 330;
		y30 = 330;
		

		palabraUser = txtInput.getText();
		//palabraUserLetras = palabraUser.split("");
		
		
		setVisible(true);

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(font);

		// primera fila (fila 0)
		g.setColor(c1);
		g.fillRect(x1, y1, 40, 40);
		g.setColor(c2);
		g.fillRect(x2, y2, 40, 40);
		g.setColor(c3);
		g.fillRect(x3, y3, 40, 40);

		if (letrasPorPalabra == 4)
		{
			g.setColor(c4);
			g.fillRect(x4, y4, 40, 40);

		} else if (letrasPorPalabra == 5)
		{
			g.setColor(c4);
			g.fillRect(x4, y4, 40, 40);
			g.setColor(c5);
			g.fillRect(x5, y5, 40, 40);

		} else if (letrasPorPalabra == 6)
		{
			g.setColor(c4);
			g.fillRect(x4, y4, 40, 40);
			g.setColor(c5);
			g.fillRect(x5, y5, 40, 40);
			g.setColor(c6);
			g.fillRect(x6, y6, 40, 40);
		}

		// segunda fila (fila 1)
		g.setColor(c7);
		g.fillRect(x7, y7, 40, 40);
		g.setColor(c8);
		g.fillRect(x8, y8, 40, 40);
		g.setColor(c9);
		g.fillRect(x9, y9, 40, 40);

		if (letrasPorPalabra == 4)
		{
			g.setColor(c10);
			g.fillRect(x10, y10, 40, 40);

		} else if (letrasPorPalabra == 5)
		{
			g.setColor(c10);
			g.fillRect(x10, y10, 40, 40);
			g.setColor(c11);
			g.fillRect(x11, y11, 40, 40);

		} else if (letrasPorPalabra == 6)
		{
			g.setColor(c10);
			g.fillRect(x10, y10, 40, 40);
			g.setColor(c11);
			g.fillRect(x11, y11, 40, 40);
			g.setColor(c12);
			g.fillRect(x12, y12, 40, 40);
		}

		// tercera fila (fila 2)
		g.setColor(c13);
		g.fillRect(x13, y13, 40, 40);
		g.setColor(c14);
		g.fillRect(x14, y14, 40, 40);
		g.setColor(c15);
		g.fillRect(x15, y15, 40, 40);

		if (letrasPorPalabra == 4)
		{
			g.setColor(c16);
			g.fillRect(x16, y16, 40, 40);

		} else if (letrasPorPalabra == 5)
		{
			g.setColor(c16);
			g.fillRect(x16, y16, 40, 40);
			g.setColor(c17);
			g.fillRect(x17, y17, 40, 40);

		} else if (letrasPorPalabra == 6)
		{
			g.setColor(c16);
			g.fillRect(x16, y16, 40, 40);
			g.setColor(c17);
			g.fillRect(x17, y17, 40, 40);
			g.setColor(c18);
			g.fillRect(x18, y18, 40, 40);
		}

		// cuarta fila (fila 3)
		g.setColor(c19);
		g.fillRect(x19, y19, 40, 40);
		g.setColor(c20);
		g.fillRect(x20, y20, 40, 40);
		g.setColor(c21);
		g.fillRect(x21, y21, 40, 40);

		if (letrasPorPalabra == 4)
		{
			g.setColor(c22);
			g.fillRect(x22, y22, 40, 40);

		} else if (letrasPorPalabra == 5)
		{
			g.setColor(c22);
			g.fillRect(x22, y22, 40, 40);
			g.setColor(c23);
			g.fillRect(x23, y23, 40, 40);

		} else if (letrasPorPalabra == 6)
		{
			g.setColor(c22);
			g.fillRect(x22, y22, 40, 40);
			g.setColor(c23);
			g.fillRect(x23, y23, 40, 40);
			g.setColor(c24);
			g.fillRect(x24, y24, 40, 40);
		}

		// quinta fila (fila 4)
		g.setColor(c25);
		g.fillRect(x25, y25, 40, 40);
		g.setColor(c26);
		g.fillRect(x26, y26, 40, 40);
		g.setColor(c27);
		g.fillRect(x27, y27, 40, 40);

		if (letrasPorPalabra == 4)
		{
			g.setColor(c28);
			g.fillRect(x28, y28, 40, 40);

		} else if (letrasPorPalabra == 5)
		{
			g.setColor(c28);
			g.fillRect(x28, y28, 40, 40);
			g.setColor(c29);
			g.fillRect(x29, y29, 40, 40);

		} else if (letrasPorPalabra == 6)
		{
			g.setColor(c28);
			g.fillRect(x28, y28, 40, 40);
			g.setColor(c29);
			g.fillRect(x29, y29, 40, 40);
			g.setColor(c30);
			g.fillRect(x30, y30, 40, 40);
		}
		

	}

	// indice corresponde a x, fila corresponde a y
	public void asignarVerde(int indice, int fila)
	{
		switch(fila) {
		// fila 0
		case 0:
			switch(indice) {
			case 0:
				c1 = Color.green;
				repaint(x1, y1, 40, 40);
				break;
			case 1:
				c2 = Color.green;
				repaint(x2, y2, 40, 40);
				break;	
			case 2:
				c3 = Color.green;
				repaint(x3, y3, 40, 40);
				break;	
			case 3:
				c4 = Color.green;
				repaint(x4, y4, 40, 40);
				break;	
			case 4:
				c5 = Color.green;
				repaint(x5, y5, 40, 40);
				break;	
			case 5:
				c6 = Color.green;
				repaint(x6, y6, 40, 40);
				break;	
			}
			break;
		// fila 1
		case 1:
			switch(indice) {
			case 0:
				c7 = Color.green;
				repaint(x7, y7, 40, 40);
				break;
			case 1:
				c8 = Color.green;
				repaint(x8, y8, 40, 40);
				break;	
			case 2:
				c9 = Color.green;
				repaint(x9, y9, 40, 40);
				break;	
			case 3:
				c10 = Color.green;
				repaint(x10, y10, 40, 40);
				break;	
			case 4:
				c11 = Color.green;
				repaint(x11, y11, 40, 40);
				break;	
			case 5:
				c12 = Color.green;
				repaint(x12, y12, 40, 40);
				break;	
			}
			break;
		// fila 2
		case 2:
			switch(indice) {
			case 0:
				c13 = Color.green;
				repaint(x13, y13, 40, 40);
				break;
			case 1:
				c14 = Color.green;
				repaint(x14, y14, 40, 40);
				break;	
			case 2:
				c15 = Color.green;
				repaint(x15, y15, 40, 40);
				break;	
			case 3:
				c16 = Color.green;
				repaint(x16, y16, 40, 40);
				break;	
			case 4:
				c17 = Color.green;
				repaint(x17, y17, 40, 40);
				break;	
			case 5:
				c18 = Color.green;
				repaint(x18, y18, 40, 40);
				break;	
			}
			break;
		// fila 3
		case 3:
			switch(indice) {
			case 0:
				c19 = Color.green;
				repaint(x19, y19, 40, 40);
				break;
			case 1:
				c20 = Color.green;
				repaint(x20, y20, 40, 40);
				break;	
			case 2:
				c21 = Color.green;
				repaint(x21, y21, 40, 40);
				break;	
			case 3:
				c22 = Color.green;
				repaint(x22, y22, 40, 40);
				break;	
			case 4:
				c23 = Color.green;
				repaint(x23, y23, 40, 40);
				break;	
			case 5:
				c24 = Color.green;
				repaint(x24, y24, 40, 40);
				break;	
			}
			break;
		// fila 4
		case 4:
			switch(indice) {
			case 0:
				c25 = Color.green;
				repaint(x25, y25, 40, 40);
				break;
			case 1:
				c26 = Color.green;
				repaint(x26, y26, 40, 40);
				break;	
			case 2:
				c27 = Color.green;
				repaint(x27, y27, 40, 40);
				break;	
			case 3:
				c28 = Color.green;
				repaint(x28, y28, 40, 40);
				break;	
			case 4:
				c29 = Color.green;
				repaint(x29, y29, 40, 40);
				break;	
			case 5:
				c30 = Color.green;
				repaint(x30, y30, 40, 40);
				break;	
			}
		break;
		}

	}

	public void asignarAmarillo(int indice, int fila)
	{
		switch(fila) {
		// fila 0
		case 0:
			switch(indice) {
			case 0:
				c1 = Color.yellow;
				repaint(x1, y1, 40, 40);
				break;
			case 1:
				c2 = Color.yellow;
				repaint(x2, y2, 40, 40);
				break;	
			case 2:
				c3 = Color.yellow;
				repaint(x3, y3, 40, 40);
				break;	
			case 3:
				c4 = Color.yellow;
				repaint(x4, y4, 40, 40);
				break;	
			case 4:
				c5 = Color.yellow;
				repaint(x5, y5, 40, 40);
				break;	
			case 5:
				c6 = Color.yellow;
				repaint(x6, y6, 40, 40);
				break;	
			}
			break;
		// fila 1
		case 1:
			switch(indice) {
			case 0:
				c7 = Color.yellow;
				repaint(x7, y7, 40, 40);
				break;
			case 1:
				c8 = Color.yellow;
				repaint(x8, y8, 40, 40);
				break;	
			case 2:
				c9 = Color.yellow;
				repaint(x9, y9, 40, 40);
				break;	
			case 3:
				c10 = Color.yellow;
				repaint(x10, y10, 40, 40);
				break;	
			case 4:
				c11 = Color.yellow;
				repaint(x11, y11, 40, 40);
				break;	
			case 5:
				c12 = Color.yellow;
				repaint(x12, y12, 40, 40);
				break;	
			}
			break;
		// fila 2
		case 2:
			switch(indice) {
			case 0:
				c13 = Color.yellow;
				repaint(x13, y13, 40, 40);
				break;
			case 1:
				c14 = Color.yellow;
				repaint(x14, y14, 40, 40);
				break;	
			case 2:
				c15 = Color.yellow;
				repaint(x15, y15, 40, 40);
				break;	
			case 3:
				c16 = Color.yellow;
				repaint(x16, y16, 40, 40);
				break;	
			case 4:
				c17 = Color.yellow;
				repaint(x17, y17, 40, 40);
				break;	
			case 5:
				c18 = Color.yellow;
				repaint(x18, y18, 40, 40);
				break;	
			}
			break;
		// fila 3
		case 3:
			switch(indice) {
			case 0:
				c19 = Color.yellow;
				repaint(x19, y19, 40, 40);
				break;
			case 1:
				c20 = Color.yellow;
				repaint(x20, y20, 40, 40);
				break;	
			case 2:
				c21 = Color.yellow;
				repaint(x21, y21, 40, 40);
				break;	
			case 3:
				c22 = Color.yellow;
				repaint(x22, y22, 40, 40);
				break;	
			case 4:
				c23 = Color.yellow;
				repaint(x23, y23, 40, 40);
				break;	
			case 5:
				c24 = Color.yellow;
				repaint(x24, y24, 40, 40);
				break;	
			}
			break;
		// fila 4
		case 4:
			switch(indice) {
			case 0:
				c25 = Color.yellow;
				repaint(x25, y25, 40, 40);
				break;
			case 1:
				c26 = Color.yellow;
				repaint(x26, y26, 40, 40);
				break;	
			case 2:
				c27 = Color.yellow;
				repaint(x27, y27, 40, 40);
				break;	
			case 3:
				c28 = Color.yellow;
				repaint(x28, y28, 40, 40);
				break;	
			case 4:
				c29 = Color.green;
				repaint(x29, y29, 40, 40);
				break;	
			case 5:
				c30 = Color.yellow;
				repaint(x30, y30, 40, 40);
				break;	
			}
		break;
		}

	}
	
	public void asignarGris(int indice, int fila)
	{
		switch(fila) {
		// fila 0
		case 0:
			switch(indice) {
			case 0:
				c1 = Color.gray;
				repaint(x1, y1, 40, 40);
				break;
			case 1:
				c2 = Color.gray;
				repaint(x2, y2, 40, 40);
				break;	
			case 2:
				c3 = Color.gray;
				repaint(x3, y3, 40, 40);
				break;	
			case 3:
				c4 = Color.gray;
				repaint(x4, y4, 40, 40);
				break;	
			case 4:
				c5 = Color.gray;
				repaint(x5, y5, 40, 40);
				break;	
			case 5:
				c6 = Color.gray;
				repaint(x6, y6, 40, 40);
				break;	
			}
			break;
		// fila 1
		case 1:
			switch(indice) {
			case 0:
				c7 = Color.gray;
				repaint(x7, y7, 40, 40);
				break;
			case 1:
				c8 = Color.gray;
				repaint(x8, y8, 40, 40);
				break;	
			case 2:
				c9 = Color.gray;
				repaint(x9, y9, 40, 40);
				break;	
			case 3:
				c10 = Color.gray;
				repaint(x10, y10, 40, 40);
				break;	
			case 4:
				c11 = Color.gray;
				repaint(x11, y11, 40, 40);
				break;	
			case 5:
				c12 = Color.gray;
				repaint(x12, y12, 40, 40);
				break;	
			}
			break;
		// fila 2
		case 2:
			switch(indice) {
			case 0:
				c13 = Color.gray;
				repaint(x13, y13, 40, 40);
				break;
			case 1:
				c14 = Color.gray;
				repaint(x14, y14, 40, 40);
				break;	
			case 2:
				c15 = Color.gray;
				repaint(x15, y15, 40, 40);
				break;	
			case 3:
				c16 = Color.gray;
				repaint(x16, y16, 40, 40);
				break;	
			case 4:
				c17 = Color.gray;
				repaint(x17, y17, 40, 40);
				break;	
			case 5:
				c18 = Color.gray;
				repaint(x18, y18, 40, 40);
				break;	
			}
			break;
		// fila 3
		case 3:
			switch(indice) {
			case 0:
				c19 = Color.gray;
				repaint(x19, y19, 40, 40);
				break;
			case 1:
				c20 = Color.gray;
				repaint(x20, y20, 40, 40);
				break;	
			case 2:
				c21 = Color.gray;
				repaint(x21, y21, 40, 40);
				break;	
			case 3:
				c22 = Color.gray;
				repaint(x22, y22, 40, 40);
				break;	
			case 4:
				c23 = Color.gray;
				repaint(x23, y23, 40, 40);
				break;	
			case 5:
				c24 = Color.gray;
				repaint(x24, y24, 40, 40);
				break;	
			}
			break;
		// fila 4
		case 4:
			switch(indice) {
			case 0:
				c25 = Color.gray;
				repaint(x25, y25, 40, 40);
				break;
			case 1:
				c26 = Color.gray;
				repaint(x26, y26, 40, 40);
				break;	
			case 2:
				c27 = Color.gray;
				repaint(x27, y27, 40, 40);
				break;	
			case 3:
				c28 = Color.gray;
				repaint(x28, y28, 40, 40);
				break;	
			case 4:
				c29 = Color.gray;
				repaint(x29, y29, 40, 40);
				break;	
			case 5:
				c30 = Color.gray;
				repaint(x30, y30, 40, 40);
				break;	
			}
		break;
		}

	}
	
	//Método para limpiar campos
	public void limpiar()
	{
		txtInput.setText("");
		txtInput.requestFocus();
	}
	
	public void mostrarMensajeError(){
		
		dlgMensajeError.setLayout(new FlowLayout());
		dlgMensajeError.setSize(350,100);
		dlgMensajeError.add(lblMensajeError);
		dlgMensajeError.setLocationRelativeTo(null);
		dlgMensajeError.setVisible(true); 
	}
	
	public void mostrarMensajeFinal(){
		
		dlgGameOver.setLayout(new FlowLayout());
		lblMensajeGameOver.setFont(font3);
		lblScore.setFont(font3);
		btnNewGame.setBackground(new Color(0, 102, 102));
		btnNewGame.setForeground(new Color(255, 255, 255));
		btnNewGame.setFont(font);
		dlgGameOver.setSize(320,180);
		dlgGameOver.add(lblMensajeGameOver);
		dlgGameOver.add(lblScore);
		dlgGameOver.add(btnNewGame);
		dlgGameOver.setLocationRelativeTo(null);
		dlgGameOver.setVisible(true); 
	}
	
}