

import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.imageio.ImageIO;

public class ModelJeu{
	//private Image image;
    private Jeu jeu;
  	private boolean start=false;
  	private VueInterface vue;
  	private ArrayList<Tuile> tuileChoisi =new ArrayList<Tuile>();

    public ModelJeu(int n) {
	  	jeu=new Jeu(n); 
	  	jeu.preparation();
	  	start=true;
	  	vue=new VueInterface(this);
	}
	public VueInterface getVue(){
	  	return vue;
	}
	public Jeu getJeu(){
	  	return jeu;
	}
	public boolean getStart(){
		return start;
	}

	public void partie(){
		while(jeu.isFullLine()){
			jeu.preparation();
			vue.repaint();
			offre();
			jeu.decoration();
			vue.repaint();
		}
		//vue.fin();
	}

	public void offre(){
		while(jeu.isTuileInGame()){
			start=true;
		}
		start=false;
	}

	public void enregistrerTuileFabrique(String c,int numFab){
		tuileChoisi=jeu.getFabrique()[numFab].take(c,jeu.getCentre());
	}
	public void enregistrerTuileCentre(String c){
		tuileChoisi=jeu.take(c);
		if(!jeu.getCentre().isEmpty() && jeu.getCentre().get(0).getCouleur().equals("vert")){
			tuileChoisi.add(jeu.getCentre().get(0));
			jeu.getCentre().remove(0);
		}
	}

	public void deplacementTuileLigne(int line){
		if(!tuileChoisi.isEmpty()){
			boolean b=vue.getJoueur().getLigne().add(tuileChoisi,line);
			if(!b){
				if(!vue.getJoueur().getPlancher().addPlancher(tuileChoisi)) {
					for(int a=0;a<tuileChoisi.size();a++){
						jeu.getDefausse().add(tuileChoisi.get(a));
					}
				}
			}
			if(!jeu.isTuileInGame()){
				start=false;
				decoration();
			}
		}
	}

	public void decoration(){
		jeu.decoration();
		jeu.preparation();
		vue.nouvelAffichage();
		if(jeu.isFullLine()) start=true;
		else vue.fin();
	}

	public void nextJoueur(){
		vue.setJoueur(jeu.getJoueur()[(vue.getJoueur().getNum()+1)%(jeu.getJoueur().length)]);
	}

}
