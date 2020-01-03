import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Jouer{

	public Jouer(int n){
	    ModelJeu modele=new ModelJeu(n);
	    VueInterface vue=modele.getVue();
	    vue.pack();
	    vue.setVisible(true);
  	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Voulez vous jouer sur le terminal (t) ou avec l'interface graphique (i)");  //exception a gerer
		String choix=sc.next();
		System.out.println("Entrez le nombre de joueur");
		int n=sc.nextInt();
		VueGeneral vue;
		if(choix.equals("t")){
			vue=new VueTerminale(n);
			vue.partie();
		}
		else {
			EventQueue.invokeLater( () -> {new Jouer(n);});
		}

	}

}