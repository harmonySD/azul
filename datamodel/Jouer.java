package vue;

import java.util.*;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Jouer{

	public Jouer(){
	    ModelJeu model =new ModelJeu();
	    VueInterface vue=new VueInterface(model);
	    vue.pack();
	    vue.setVisible(true);
  	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Voulez vous jouer sur le terminal (t) ou avec l'interface graphique (i)");  //exception a gerer
		String n=sc.next();
		VueGeneral vue;
		if(n.equals("t")){
			vue=new VueTerminale();
			vue.partie();
		}
		else {
			EventQueue.invokeLater( () -> {new Jouer();});
		}

	}

}