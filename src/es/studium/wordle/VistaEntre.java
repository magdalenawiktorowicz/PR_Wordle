package es.studium.wordle;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class VistaEntre extends Frame
{
	private static final long serialVersionUID = 1L;

	// Crea variables para componentes
		Label lblNick = new Label("Enter your nickname:", Font.BOLD);
		TextField txtNick = new TextField(15);

		Label lblLetters = new Label("Choose the number of letters:");
		Choice letterChoice = new Choice();

		Button btnOK = new Button("OK");
		Button btnBack = new Button("BACK");

		// Fondo
		Image backgroundImage;
		Toolkit tool;

		Dialog dlgAvisoNick = new Dialog(this,"Ooops...", true);
		Label lblAvisoNick = new Label(" Write your name and choose the number of letters.");
		
	public VistaEntre() {
		setLayout(null);

		// Add parameters nick label
		lblNick.setBounds(127, 150, 245, 30);
		lblNick.setFont(new Font("Arial", Font.BOLD, 24));
		lblNick.setAlignment(NORMAL);

		// Add parameters nick label
		txtNick.setBounds(160, 190, 183, 30);
		txtNick.setFont(new Font("Arial", Font.BOLD, 18));

		// Add parameters letters label
		lblLetters.setBounds(100, 230, 300, 30);
		lblLetters.setFont(new Font("Arial", Font.BOLD, 21));

		// Add parameters letter choice
		letterChoice.setBounds(175, 270, 150, 30);
		letterChoice.setFont(new Font("Arial", Font.BOLD, 18));
		letterChoice.setPreferredSize(new Dimension(200, 20));
		letterChoice.add("Choose...");
		letterChoice.add("3 letters");
		letterChoice.add("4 letters");
		letterChoice.add("5 letters");
		letterChoice.add("6 letters");
		letterChoice.select(0); // Set the default option

		// Add parameters button OK
		btnOK.setBounds(160, 430, 170, 30);
		btnOK.setFont(new Font("Arial", Font.BOLD, 24));
		btnOK.setBackground(new Color(0, 102, 102));
		btnOK.setForeground(new Color(255, 255, 255));

		// Add parameters button OK
		btnBack.setBounds(160, 470, 170, 30);
		btnBack.setFont(new Font("Arial", Font.BOLD, 24));
		btnBack.setBackground(new Color(0, 102, 102));
		btnBack.setForeground(new Color(255, 255, 255));

		// Add Components
		add(lblNick);
		add(txtNick);
		add(lblLetters);
		add(letterChoice);
		add(btnOK);
		add(btnBack);

		setTitle("New Game");
		setSize(495, 570);
		setLocationRelativeTo(null);
		setResizable(false);

		tool = getToolkit();
		backgroundImage = tool.getImage("img/NewGameGreen.jpg");

		dlgAvisoNick.setSize(370, 90);
		dlgAvisoNick.setLayout(new FlowLayout());
		dlgAvisoNick.setLocationRelativeTo(null);
		dlgAvisoNick.setResizable(false);
		lblAvisoNick.setFont(new Font("Arial", Font.PLAIN, 15));
		dlgAvisoNick.add(lblAvisoNick);
		
		setVisible(true);

	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(backgroundImage, 8, 15, this);
	}
}
