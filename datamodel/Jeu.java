import java.util.*;

public class Jeu{
	private final Joueur[] joueur;
	private final Fabrique[] fabrique;
	private ArrayList<Tuile> centre;
	private ArrayList<Tuile> sac;
	private ArrayList<Tuile> defausse;

	public Jeu(int n){
		joueur=new Joueur[n];
		for (int i=0; i<n; i++){
			joueur[i]=new Joueur();
		}
		centre=new ArrayList<Tuile>();
		defausse=new ArrayList<Tuile>();
		sac=new ArrayList<Tuile>();
		if(n==2) fabrique=new Fabrique[5];
		else if(n==3) fabrique=new Fabrique[7];
		else if(n==4) fabrique=new Fabrique[9];
		else fabrique=new Fabrique[5];  // a gere dans exception
		for(int i=0;i<fabrique.length;i++){
			fabrique[i]=new Fabrique();
		}
		for (int i=0;i<100;i++){
			sac.add(new Tuile("bleu"));
		}

	}
	public Joueur getJoueur(int i){
		return joueur[i];
	}
	public Joueur[] getJoueur(){
		return joueur;
	}
	public Fabrique[] getFabrique(){
		return fabrique;
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
		for(int i=0;i<joueur.length;i++){
			if(joueur[i].isFullLine()) return true;
		}
		return false;
	}

	public void preparation(){
		centre.add(new Tuile("vert"));  // vert=tuile -1
		for(int i=0;i<fabrique.length;i++){
			fabrique[i].remplirFabrique(sac);
		}
	}
	public void offre(){

	}
	public void decoration(){

	}
	public void fin(){
		
	}
}
