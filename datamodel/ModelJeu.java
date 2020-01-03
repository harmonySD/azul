import java.util.*;
import java.util.concurrent.TimeUnit;
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
  	private ArrayList<Tuile> tuileChoisi;

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

	public void enregistrerTuileFabrique(String c,int numFab){
		tuileChoisi=new ArrayList<Tuile>();
		tuileChoisi=jeu.getFabrique()[numFab].take(c,jeu.getCentre());
	}
	public void enregistrerTuileCentre(String c){
		tuileChoisi=new ArrayList<Tuile>();
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
	public void deplacementTuilePlancher(int colone){
		if(!tuileChoisi.isEmpty()){
			if(!vue.getJoueur().getPlancher().addPlancher(tuileChoisi)){
				for(int a=0;a<tuileChoisi.size();a++){
					jeu.getDefausse().add(tuileChoisi.get(a));
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
		vue.nouvelAffichage();
		try{
    		TimeUnit.SECONDS.sleep(1);
    	}
    	catch (InterruptedException e) {
            e.printStackTrace();
        }
		if(!jeu.isFullLine()){
			start=true;
			jeu.preparation();
			vue.nouvelAffichage();
		}
		else {
			vue.fin();
		}
	}

	public void nextJoueur(){
		vue.setJoueur(jeu.getJoueur()[(vue.getJoueur().getNum()+1)%(jeu.getJoueur().length)]);
	}

}
