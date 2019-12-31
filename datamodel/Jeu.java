package datamodel;

import java.util.*;

public class Jeu {
	private final Joueur[] joueurs;
	private final Fabrique[] fabriques;
	private ArrayList<Tuile> centre;
	private ArrayList<Tuile> sac;
	private ArrayList<Tuile> defausse;

	public Jeu(int n){
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
	public Joueur getJoueur(int i){
		return joueurs[i];
	}
	public Joueur[] getJoueur(){
		return joueurs;
	}
	public Fabrique[] getFabrique(){
		return fabriques;
	}
	public ArrayList<Tuile> getCentre(){
		return centre;
	}
	public void setCentre(ArrayList<Tuile> c){
		centre=c;
	}
	public ArrayList<Tuile> getSac(){
		return sac;
	}
	public void setSac(ArrayList<Tuile> c){
		sac=c;
	}
	public ArrayList<Tuile> getDefausse(){
		return defausse;
	}
	public void setDefausse(ArrayList<Tuile> c){
		defausse=c;
	}

	public void partie(){
		while(isFullLine()){
			preparation();
			offre();
			decoration();
		}
		fin();
	}

	public boolean isFullLine(){
		for(int i=0;i<joueurs.length;i++){
			if(joueurs[i].isFullLine()) return true;
		}
		return false;
	}

	public void preparation(){
		centre.add(new Tuile("vert"));  // vert=tuile -1
		for(int i=0;i<fabriques.length;i++){
			fabriques[i].remplirFabrique(sac);
		}
	}
	public void offre(){

	}
	public void decoration(){

	}
	public void fin(){
		Joueur j=joueurs[0];
		for(int i=0;i<joueurs.length;i++){
			System.out.println(joueurs[i].getNom()+" : "+joueurs[i].getScore());
			if(j.getScore()<joueurs[i].getScore()) j=joueurs[i];
		}
		System.out.println(j.getNom()+"a gagné avec un score de "+ j.getScore());
	}
	public boolean isSacEmpty(){
		if(this.sac.size()==0){
			return true; //il faut donc remplir le sac grace a la defausse 
		}else{
			return false;
		}
	}
	public void remplirSac(){
		for(int i=0;i<this.defausse.size();i++){
				sac=defausse;
				defausse=new ArrayList<Tuile>();
		}
	}

	public void remplirFabriques(){
		if(this.sac.size()!=0){
			for (int i=0; i<fabriques.length;i++){
				fabriques[i].remplirFabrique(this.sac);
				System.out.println("fabrique["+i+"] ok");
			}
		}else{
			remplirSac();
			remplirFabriques();
		}
		

	}

}
