package vue;

import java.util.*;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class VueInterface implements VueGeneral extends JFrame{

	public ModelJeu modele; 
	private PlateauJeu plateauJeu;
	private JPanel p1,p2;
	private JLabel text;

	public VueInterface(int n){
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


		getContentPane().setLayout(new GridLayout(0,2));
	    getContentPane().add(p2);
	    getContentPane().add(panel1);
		setTitle("Azul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	// IMAGEPANE
  class PlateauJeu extends JPanel{
    Selection selection=new Selection();

    public void paintComponent(Graphics g){
      super.paintComponent(g);
      int n=fabriques.length;
   	  int x=0;
   	  int y=0;
      for(int i=0;i<n;i++){
      	g.
      }
      g.drawImage(modele.getImage(),0,0,this);
      
    }

    public PlateauJeu(){
      this.setPreferredSize(new Dimension(model.getImage().getWidth(),model.getImage().getHeight()));
      addMouseListener(selection);
      addMouseMotionListener(selection);
    }

    // SELECTION   https://www.daniweb.com/programming/software-development/threads/342036/how-to-select-images-by-using-a-rectangular-area
    class Selection extends MouseAdapter implements MouseMotionListener{
      private int x1,y1,x2,y2;

      public Selection(){
        x1=0;
        y1=0;
        x2=0;
        y2=0;
      }

      public void mousePressed(MouseEvent e){
        x1=e.getX();
        y1=e.getY();
        x2=e.getX();
        y2=e.getY();
        plateauJeu.repaint();
      }
      public void mouseDragged(MouseEvent e){
        x2=e.getX();
        y2=e.getY();
        if(x1!=x2 && y1!=y2){
          //cutButton.setEnabled(true);
        }
        plateauJeu.repaint();
      }
      public void mouseMoved(MouseEvent e){

      }

    }

  }


}