package vue;

import java.util.*;
import datamodel.Jeu;
import datamodel.Fabrique;
import datamodel.Tuile;
import datamodel.Joueur;
import datamodel.Case;
import datamodel.Plateau;

public interface VueGeneral {
	private final Joueur[] joueurs;
	private final Fabrique[] fabriques;
	private ArrayList<Tuile> centre;
	private ArrayList<Tuile> sac;
	private ArrayList<Tuile> defausse;

	public default Joueur getJoueur(int i){
		return joueurs[i];
	}
	public default Joueur[] getJoueur(){
		return joueurs;
	}
	public default Fabrique[] getFabrique(){
		return fabriques;
	}
	public default ArrayList<Tuile> getCentre(){
		return centre;
	}
	public default void setCentre(ArrayList<Tuile> c){
		centre=c;
	}
	public default ArrayList<Tuile> getSac(){
		return sac;
	}
	public default void setSac(ArrayList<Tuile> c){
		sac=c;
	}
	public default ArrayList<Tuile> getDefausse(){
		return defausse;
	}
	public default void setDefausse(ArrayList<Tuile> c){
		defausse=c;
	}

	public default void partie(){
		while(isFullLine()){
			preparation();
			offre();
			decoration();
		}
		fin();
	}

	public default boolean isFullLine(){
		for(int i=0;i<joueurs.length;i++){
			if(joueurs[i].isFullLine()) return true;
		}
		return false;
	}

	public default void preparation(){
		centre.add(new Tuile("vert"));  // vert=tuile -1
		for(int i=0;i<fabriques.length;i++){
			fabriques[i].remplirFabrique(sac);
		}
	}

	public void offre();
	public void decoration();
	public void fin();

	public default boolean isSacEmpty(){
		if(this.sac.size()==0){
			return true; //il faut donc remplir le sac grace a la defausse 
		}else{
			return false;
		}
	}
	public default void remplirSac(){
		for(int i=0;i<this.defausse.size();i++){
				sac=defausse;
				defausse=new ArrayList<Tuile>();
		}
	}

	public default void remplirFabriques(){
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