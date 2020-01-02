

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
	  	vue=new VueInterface(this);
	  	partie();
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

	public void enregistrerTuile(int x,int numFab){
		tuileChoisi=jeu.getFabrique()[numFab].take(jeu.getFabrique()[numFab].getTas()[x].getCouleur(),jeu.getCentre());
		
	}

	public void deplacementTuileLigne(int line){
		boolean b=vue.getJoueur().getLigne().add(tuileChoisi,line);
		System.out.println(line);
		for(int i=0;i<tuileChoisi.size();i++){
			System.out.println(tuileChoisi.get(i));
		}
		if(!b){
			if(!vue.getJoueur().getPlancher().addPlancher(tuileChoisi)) {
				for(int a=0;a<tuileChoisi.size();a++){
					jeu.getDefausse().add(tuileChoisi.get(a));
				}
			}
		}
		vue.repaint();
		nextJoueur();
		vue.repaint();
	}

	public void nextJoueur(){
		vue.setJoueur(jeu.getJoueur()[vue.getJoueur().getNum()+1%jeu.getJoueur().length]);
	}

}
