
import java.util.*;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Jouer{

	public Jouer(int n){
	    ModelJeu modele=new ModelJeu(n);
	    VueInterface vue=new VueInterface(modele);
	    vue.pack();
	    vue.setVisible(true);
  	}

  	// class principal qui lance le jeu
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Voulez vous jouer sur le terminal (t) ou avec l'interface graphique (i)");  //exception a gerer
		String choix=sc.next();
		while (!choix.equals("t") && !choix.equals("i")){
			System.out.println("Erreur, mauivaise lettre \n Voulez vous jouer sur le terminal (t) ou avec l'interface graphique (i)");  //exception a gerer
			choix=sc.next();
		}
		System.out.println("Entrez le nombre de joueur");
		int n=sc.nextInt();
		while (n>4 || n<2){
			System.out.println("Erreur, vous ne pouvez jouer qu'à 2,3 ou 4 joueurs. \n Entrez le nombre de joueur");
			n=sc.nextInt();
		}
		VueGeneral vue;
		if(choix.equals("t")){
			vue=new VueTerminale(n);
			vue.partie();
		}
		else if(choix.equals("i")) {
			EventQueue.invokeLater( () -> {new Jouer(n);});
		}

	}

}