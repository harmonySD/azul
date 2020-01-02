package vue;

import java.util.*;
import datamodel.Jeu;
import datamodel.Fabrique;
import datamodel.Tuile;
import datamodel.Joueur;
import datamodel.Case;
import datamodel.Plateau;

public class VueTerminale implements VueGeneral{

	public VueTerminale(int n){
		joueurs=new Joueur[n];
		for (int i=0; i<n; i++){
			joueurs[i]=new Joueur();
		}
		centre=new ArrayList<Tuile>();
		defausse=new ArrayList<Tuile>();
		sac=new ArrayList<Tuile>();
		if(n==2) fabriques=new Fabrique[5];
		else if(n==3) fabriques=new Fabrique[7];
		else if(n==4) fabriques=new Fabrique[9];
		else fabriques=new Fabrique[5];  // a gere dans exception
		for(int i=0;i<fabriques.length;i++){
			fabriques[i]=new Fabrique();
		}
		for (int i=0;i<20;i++){
			sac.add(new Tuile("bleu"));
			sac.add(new Tuile("orange"));
			sac.add(new Tuile("blanc"));
			sac.add(new Tuile("noir"));
			sac.add(new Tuile("rouge"));
		}
	}

	public void partie(){
		
	}
	public void offre(){

	}
	public void decoration(){

	}
	public void fin(){

	}


}