package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Controller2048;
import model.Plateau;

public class VueGUI2048 extends Vue2048 implements KeyListener{

	int x = model.getDimension();
	Color couleurGris = new Color(180,180,180);

	private JFrame 	frame;
	private JPanel 	tuiles[][];
	private JLabel 	numeroCase[][];

	private JLabel 	labelTitre;
	private JLabel 	labelScore;
	private JLabel	labelTemps;
	private Timer	timer;
	private JLabel 	nombreCaseLabel;
	private JComboBox<Object> nombreCaseCombo;
	private JButton bouttonDemarrer;
	private JButton bouttonCredit;
	private JDialog fenetreCredit;

	private JButton bouttonHaut;
	private JButton bouttonBas;
	private JButton bouttonGauche;
	private JButton bouttonDroite;

	public VueGUI2048(Plateau model, Controller2048 controller) {
		super(model, controller);
		frame = new JFrame("Projet 2048");
		frame.setSize(680, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
		boiteDialogue("Comment jouer ?", "<html>D'abord choisissez le nombre de case pour jouer,"
				+ "ensuite vous pouvez cliquer sur '(Re)Initialiser' et jouer avec les fleches.</html>");

		panneauDroit();

		creditConsole();
	}

	@Override
	public void affiche() {
		x = model.getDimension();
		tuiles(x);
	}
	@Override
	public void update(Observable o, Object arg) {
		affiche();
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			System.out.println("Gauche");
			model.deplacement("G");

		}

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("Droite");
			model.deplacement("D");
		}

		if (key == KeyEvent.VK_UP) {
			System.out.println("Haut");
			model.deplacement("H");
		}

		if (key == KeyEvent.VK_DOWN) {
			System.out.println("Bas");
			model.deplacement("B");
		}
		if (key == KeyEvent.VK_NUMPAD2) {
			System.out.println("Initialisation 2X2 - Reset");
			model.initialisation(2);
		}
		if (key == KeyEvent.VK_NUMPAD3) {
			System.out.println("Initialisation 3X3 - Reset");
			model.initialisation(3);
		}
		if (key == KeyEvent.VK_NUMPAD4) {
			System.out.println("Initialisation 4X4 - Reset");
			model.initialisation(4);
		}
		if (key == KeyEvent.VK_NUMPAD5) {
			System.out.println("Initialisation 5X5 - Reset");
			model.initialisation(5);
		}
		if (key == KeyEvent.VK_NUMPAD6) {
			System.out.println("Initialisation 6X6 - Reset");
			model.initialisation(6);
		}
		if (key == KeyEvent.VK_NUMPAD7) {
			System.out.println("Initialisation 7X7 - Reset");
			model.initialisation(7);
		}
		if (key == KeyEvent.VK_NUMPAD8) {
			System.out.println("Initialisation 8X8 - Reset");
			model.initialisation(8);
		}
		if (key == KeyEvent.VK_NUMPAD9) {
			System.out.println("Initialisation 9X9 - Reset");
			model.initialisation(9);
		}

		else {
			System.setErr(null);
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	public void boiteDialogue(String titre, String texte) {
		fenetreCredit = new JDialog();
        fenetreCredit.setTitle(titre);
        fenetreCredit.setSize(240, 200);
        fenetreCredit.setLocationRelativeTo(null);
        fenetreCredit.setLayout(new GridBagLayout());
        fenetreCredit.setResizable(false);
        fenetreCredit.add(new JLabel(texte));
        fenetreCredit.setVisible(true);
	}
	public void tuiles(int x) {
		int valeur;
		tuiles = new JPanel[x][x];
		numeroCase = new JLabel[x][x];
		for (int i = 0; i < x; i++) {
			for (int e = 0; e < x; e++) {
				valeur = model.getTableau(e, i);
				tuiles[i][e] = new JPanel();
				tuiles[i][e].setBackground(Color.LIGHT_GRAY);
				
				numeroCase[i][e] = new JLabel();
				switch (x) {
				case 2:
					
					tuiles[i][e].setSize(200, 200);
					tuiles[i][e].setLocation(210 * i + 30, 210 * e + 30);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN,170));
					numeroCase[i][e].setSize(200, 200);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 3:
					tuiles[i][e].setSize(130, 130);
					tuiles[i][e].setLocation(140 * i + 25, 140 * e + 25);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 110));
					numeroCase[i][e].setSize(130, 130);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 4:
					tuiles[i][e].setSize(100, 100);
					tuiles[i][e].setLocation(110 * i + 20, 110 * e + 20);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 80));
					numeroCase[i][e].setSize(100, 100);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 5:
					tuiles[i][e].setSize(80, 80);
					tuiles[i][e].setLocation(90 * i + 20, 90 * e + 20);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 60));
					numeroCase[i][e].setSize(80, 80);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 6:
					tuiles[i][e].setSize(65, 65);
					tuiles[i][e].setLocation(75 * i + 15, 75 * e + 15);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 50));
					numeroCase[i][e].setSize(65, 65);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 7:
					tuiles[i][e].setSize(55, 55);
					tuiles[i][e].setLocation(62 * i + 10, 62 * e + 10);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 40));
					numeroCase[i][e].setSize(55, 55);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 8:
					tuiles[i][e].setSize(46, 46);
					tuiles[i][e].setLocation(53 * i + 12, 53 * e + 12);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 30));
					numeroCase[i][e].setSize(46, 46);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 9:
					tuiles[i][e].setSize(42, 42);
					tuiles[i][e].setLocation(50 * i + 12, 50 * e + 12);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 28));
					numeroCase[i][e].setSize(42, 42);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				}
				switch (valeur) {
				case 2 : 
					tuiles[i][e].setBackground(new Color(0xeee4da));
					break;
				case 4 : 
					tuiles[i][e].setBackground(new Color(0xede0c8));
					break;
				case 8 : 
					tuiles[i][e].setBackground(new Color(0xf2b179));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 16 : 
					tuiles[i][e].setBackground(new Color(0xf59563));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 32 : 
					tuiles[i][e].setBackground(new Color(0xf67c5f));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 64 : 
					tuiles[i][e].setBackground(new Color(0xf65e3b));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 128 : 
					tuiles[i][e].setBackground(new Color(0xedcf72));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;					
				}
			}
		}
	}
	public void timer() {
		 timer = new Timer(10, new ActionListener() {
	        	private int miliseconde = 0, seconde = 0, minute = 0;
				private int couleurMin = 0;
				private int couleurMax = 255;
				
				@Override 
				public void actionPerformed(ActionEvent e) {
					miliseconde++;
					if(miliseconde == 60)
					{
						miliseconde = 0;
						seconde++;
					}
					if(seconde == 60)
					{
						seconde = 0;
						minute++;
					}
					if(minute == 60)
					{
						miliseconde = 0;
						seconde = 0;
						minute = 0;
						boiteDialogue("Message","Vous avez perdu");
					}
					labelScore.setText("Score: " + model.getScore());
					labelTemps.setText("Temps: " + minute + ":" + seconde + ":" + miliseconde);
					
					if(couleurMin < 255 && couleurMax > 0) {
						Color rain = new Color(couleurMin++,couleurMin++/2,couleurMax--/2);
						labelTitre.setForeground(rain);
					}
					else {
						labelTitre.setForeground(Color.orange);
					}
					
				}
			});
	}
	
	public void panneauDroit() {

		labelTitre = new JLabel("2048");
		labelTitre.setSize(180, 60);
		labelTitre.setLocation(490, 20);
		labelTitre.setFont(new Font("Arial", Font.BOLD, 70));
		frame.add(labelTitre);

        labelScore = new JLabel("Score: ");
        labelScore.setForeground(couleurGris);
        labelScore.setSize(180,60);
        labelScore.setLocation(490, 71);
        labelScore.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(labelScore);

        timer();
	
        labelTemps = new JLabel();
        labelTemps.setText("Temps: ");
        labelTemps.setForeground(Color.RED);
        labelTemps.setSize(180,60);
        labelTemps.setLocation(490, 105);
        labelTemps.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(labelTemps);	
        
        nombreCaseLabel = new JLabel("Nombre de case:");
		nombreCaseLabel.setSize(180, 60);
		nombreCaseLabel.setLocation(490, 150);
		nombreCaseLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.add(nombreCaseLabel);
		
		
		String valeurNombreCase[] = {"2","3","4","5","6","7","8","9"};
		nombreCaseCombo = new JComboBox<Object>(valeurNombreCase);
		nombreCaseCombo.setLocation(590, 170);
		nombreCaseCombo.setSelectedIndex(2);
		nombreCaseCombo.setSize(50, 20);
		nombreCaseCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nombreCaseLabel.setText("Nombre de case: ");
				
			model.setDimension(Integer.valueOf((String)nombreCaseCombo.getSelectedItem()));
			}
		});
		frame.add(nombreCaseCombo);

		bouttonDemarrer = new JButton("(Re)Initialiser");
		bouttonDemarrer.setSize(150, 40);
		bouttonDemarrer.setLocation(490,225);
		bouttonDemarrer.setBackground(Color.LIGHT_GRAY);
		bouttonDemarrer.addActionListener(actionDemarrer);
		bouttonDemarrer.addKeyListener(this);
		frame.add(bouttonDemarrer);

		bouttonCredit = new JButton("Credit");
		bouttonCredit.setSize(150, 40);
		bouttonCredit.setLocation(490, 275);
		bouttonCredit.setBackground(Color.LIGHT_GRAY);
		bouttonCredit.addActionListener(actionCredit);
		frame.add(bouttonCredit);

		bouttonHaut = new JButton("\u21e7");
        bouttonHaut.setSize(45, 35);
        bouttonHaut.setLocation(542, 330);
		bouttonHaut.addActionListener(actionHaut);
		bouttonHaut.setBackground(Color.LIGHT_GRAY);
		bouttonHaut.setForeground(Color.BLUE);
		frame.add(bouttonHaut);

		bouttonBas = new JButton("\u21e9");
        bouttonBas.setSize(45, 35);
        bouttonBas.setLocation(542, 370);
		bouttonBas.addActionListener(actionBas);
		bouttonBas.setBackground(Color.LIGHT_GRAY);
		bouttonBas.setForeground(Color.BLUE);
		frame.add(bouttonBas);

		bouttonGauche = new JButton("\u21e6");
        bouttonGauche.setSize(46, 35);
        bouttonGauche.setLocation(490, 370);
		bouttonGauche.addActionListener(actionGauche);
		bouttonGauche.setBackground(Color.LIGHT_GRAY);
		bouttonGauche.setForeground(Color.BLUE);
		frame.add(bouttonGauche);

		bouttonDroite = new JButton("\u21e8");
        bouttonDroite.setSize(46, 35);
        bouttonDroite.setLocation(592, 370);
		bouttonDroite.addActionListener(actionDroite);
		bouttonDroite.setBackground(Color.LIGHT_GRAY);
		bouttonDroite.setForeground(Color.BLUE);
		frame.add(bouttonDroite);
	}

	public String texte() {
		return "<html><center>Bienvenue dans notre Projet 2048" + "<br>en JAVA !" + "<br> Tristan Pestiaux"
				+ "<br> Robin Paquet" + "<br> Ludo Van Den Dorpe</center></html>";
	}
	public void creditConsole() {
		System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n" + " Â©Tristan Pestiaux\n" + "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "appuyer sur 2,3,4,5,6,7,8 ou 9 pour choisir la dimension du plateau et demarrer le 2048\n");
	}

	AbstractAction actionDemarrer = new AbstractAction() {

		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {
			model.initialisation(x);
            timer.start();
		}
	};
	AbstractAction actionCredit = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			boiteDialogue("Credit ©",texte());
		}
	};

	AbstractAction actionHaut = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Haut");
			model.deplacement("H");
		}
	};
	AbstractAction actionBas = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Bas");
			model.deplacement("B");
		}
	};
	AbstractAction actionGauche = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Gauche");
			model.deplacement("G");
		}
	};
	AbstractAction actionDroite = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Droite");
			model.deplacement("D");
		}
	};


}
