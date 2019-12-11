import java.util.*;


public class Jeu{
	private Joueur[] joueur;
	private ArrayList<Tuile>centre;
	private Fabrique[] fabrique;
	private ArrayList<Tuile> sac;
	private ArrayList<Tuile> defausse;

	public Jeu(int n){
		joueur=new Joueur[n];
		for (int i=0; i<n; i++){
			joueur[i]=new Joueur();
		}
		centre=new ArrayList<Tuile>();
		defausse=new ArrayList<Tuile>();
		if(n==2) fabrique=new Fabrique[5];
		else if(n==3) fabrique=new Fabrique[7];
		else if(n==4) fabrique=new Fabrique[9];
		for(int i=0;i<fabrique.length;i++){
			fabrique[i]=new Fabrique();
		}
		for (int i=0;i<100;i++){
			sac.add(new Tuile("bleu"));
		}

	}

}
