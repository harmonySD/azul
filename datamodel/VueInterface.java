package vue;

import java.util.*;
import datamodel.Jeu;
import datamodel.Fabrique;
import datamodel.Tuile;
import datamodel.Joueur;
import datamodel.Case;
import datamodel.Plateau;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class VueInterface implements VueGeneral extends JFrame{

	public ModelJeu modele; 
	private JPanel p1,p2;
	private JLabel text;

	public VueInterface(int n){



		getContentPane().setLayout(new GridLayout(0,2));
	    getContentPane().add(p2);
	    getContentPane().add(panel1);
		setTitle("Azul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}