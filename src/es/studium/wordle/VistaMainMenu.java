package es.studium.wordle;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class VistaMainMenu extends Frame
{
	private static final long serialVersionUID = 1L;
	
	Button btnNewGame = new Button("NEW GAME");
	Button btnRanking = new Button("RANKING");
	Button btnHelp = new Button("HELP");
	Button btnExit = new Button("EXIT");
	
	//Fondo
	Image backgroundImage;
	Toolkit tool;
	
	public VistaMainMenu() {

		setLayout(null);
		
		//Add button NEW GAME
		btnNewGame.setBounds(210, 180, 310, 40);
		btnNewGame.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewGame.setBackground(new Color(0, 102, 102));
		btnNewGame.setForeground(new Color(255, 255, 255));

		//Add button RANKING
		btnRanking.setBounds(210, 230, 310, 40);
		btnRanking.setFont(new Font("Arial", Font.BOLD, 24));
		btnRanking.setBackground(new Color(0, 102, 102));
		btnRanking.setForeground(new Color(255, 255, 255));
		
		//Add button NEW HELP
		btnHelp.setBounds(210, 280, 310, 40);
		btnHelp.setFont(new Font("Arial", Font.BOLD, 24));
		btnHelp.setBackground(new Color(0, 102, 102));
		btnHelp.setForeground(new Color(255, 255, 255));

		//Add button EXIT
		btnExit.setBounds(210, 330, 310, 40);
		btnExit.setFont(new Font("Arial", Font.BOLD, 24));
		btnExit.setBackground(new Color(0, 102, 102));
		btnExit.setForeground(new Color(255, 255, 255));
		
		add(btnNewGame);
		add(btnRanking);
		add(btnHelp);
		add(btnExit);
		
		setTitle("Main Menu");
		setSize(730, 670);
		setLocationRelativeTo(null);
		setResizable(false);
		
		tool = getToolkit();
		backgroundImage = tool.getImage("img/MainMenuGreen.jpg");
		
		setVisible(true);

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(backgroundImage, 5, 15,this);
	}
}
