package es.studium.wordle;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;

public class VistaRanking extends Frame 
{
	private static final long serialVersionUID = 1L;

	int letrasPorPalabra;

	Modelo modelo = new Modelo(letrasPorPalabra);
	
	TextArea txaRanking = new TextArea(180,210);
	Button btnBack = new Button("BACK");
	Font font2 = new Font("Forte", Font.BOLD, 20);

	Image backgroundImage;
	Toolkit tool;
	
	public VistaRanking() {
		setLayout(null);
		setTitle("Ranking");
		setSize(730, 670);
		setLocationRelativeTo(null);
		setResizable(false);
		
		tool = getToolkit();
		backgroundImage = tool.getImage("img/MainMenuGreen.jpg");
		
		txaRanking.setBackground(new Color(195,225,171));
		txaRanking.setBounds(60, 170, 600, 410);
		txaRanking.setEditable(false);
		btnBack.setBounds(350, 610, 60, 40);
		btnBack.setBackground(new Color(0, 102, 102));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Arial", Font.BOLD, 16));
		
		txaRanking.setFont(font2);
		//// cambiar el tamaño de la fuente dentro de txaRanking
		txaRanking.setText(modelo.obtenerJugadores());
		
		add(txaRanking);
		add(btnBack);
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(backgroundImage, 5, 15,this);
		Font font = new Font("Verdana", Font.BOLD, 28);
		// Aplicamos la fuente
		g.setFont(font);
		Color color = new Color(37,76,6);
		g.setColor(color);
		g.drawString("RANKING DE 10 MEJORES JUGADORES", 50, 150);
	}
}
