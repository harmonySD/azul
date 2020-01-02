

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

    public ModelJeu(int n) {
	  	jeu=new Jeu(n);
	  	jeu.preparation();
	    /*try{
	      image=ImageIO.read(new File(chemin));
	    }
	    catch(IOException e){
	      System.out.println("Image non trouvé");
	    }*/
	}

	    /*public Image getImage(){
	   		return this.image;
	    }*/
	public Jeu getJeu(){
	  	return jeu;
	}
	public boolean getStart(){
		return start;
	}

	public void partie(){
		while(jeu.isFullLine()){
			jeu.preparation();
			offre();
			decoration();
		}
		fin();
	}

	public void offre(){
		start=true;

		start=false;
	}
	public void decoration(){

	}
	public void fin(){
		
	}

}
