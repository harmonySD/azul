import java.util.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.*;
//import java.io.File;
//import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.imageio.ImageIO;
//import java.awt.event.MouseEvent;
import javax.swing.undo.*;
//import javax.swing.undo.AbstractUndoableEdit;


public class VueInterface extends JFrame implements VueGeneral{

	public ModelJeu modele; 
	private PlateauFabrique plateauFabrique;
	private PlateauJoueur plateauJoueur;
	private JLabel text;

	private Jeu jeu;

	public VueInterface(ModelJeu m){
		modele=m;

		plateauFabrique=new PlateauFabrique();
		plateauJoueur=new PlateauJoueur();
		getContentPane().setLayout(new GridLayout(2,0));
    	setContentPane(plateauFabrique);
    	setContentPane(plateauJoueur);

		setTitle("Azul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void partie(){
		modele.partie();
	}

	// IMAGEPANE
    class PlateauFabrique extends JPanel{
    	int x1,y1,x2,y2;  //x1,y1 coordonnee de la tuile de depart et x2,y2 coordonnee de la tuile en mouvement

	    public void paintComponent(Graphics g){
	      super.paintComponent(g);
	      int n=modele.getJeu().getFabrique().length;
	   	  int x=0;
	   	  int y=0;
	   	  Fabrique[] fabriques=modele.getJeu().getFabrique();
	      for(int i=0;i<n;i++){
	      	g.fillOval(x+i*200,y,200,200);
	      	for(int j=0;j<4;j++){
	      		Tuile[] tas=fabriques[i].getTas();
	      		String couleur="bleu";
	      		if(tas[j]!=null){
	      			couleur=tas[j].getCouleur();
	      			System.out.println(couleur);
	      		}
	      		try{
	      			Image image=ImageIO.read(new File("Images/"+couleur+".png"));
	      			if(x>x1 && x+60>x1 && y<y1 && y+60>y1){
	      				System.out.println("coucou6");
	    				g.drawImage(image,x2,y2,this);
	    			}
		      		else{
		      			g.drawImage(image,x+i*200,y,this);  // mettre en carre
		      		}
	      		}
	      		catch(IOException e){
      				System.out.println("Image non trouvé");
    			}
	      	}
	      }	      
	    }

	    public PlateauFabrique(){
	    	addMouseListener(new MouseAdapter(){
	    		public void mousePressed(MouseEvent e){
			      	if(modele.getStart()){
				        x1=e.getX();
				        y1=e.getY();
				        x2=e.getX();
				        y2=e.getY();
				        plateauFabrique.repaint();
				    }
			    }
			    public void mouseDragged(MouseEvent e){
			      	if(modele.getStart()){
				        plateauFabrique.repaint();
				    }
			    }
	    	});
	    }
	}

	class PlateauJoueur extends JPanel{
		int x,y; 

	    public void paintComponent(Graphics g){
		    super.paintComponent(g);
		    int n=modele.getJeu().getFabrique().length;
		   	int x=0;
		   	int y=0;
		   	Fabrique[] fabriques=modele.getJeu().getFabrique();
		    for(int i=0;i<n;i++){
		    	g.drawOval(x+i*200,y,200,200);
		      	for(int j=0;j<fabriques.length;j++){

		      	}
	        }
	      //g.drawImage(modele.getImage(),selection.x,selection.y,this);
	      
	    }

	    public PlateauJoueur(){
	      //this.setPreferredSize(new Dimension(model.getImage().getWidth(),model.getImage().getHeight()));
	      addMouseListener(new MouseAdapter(){
	      	
	      });
	      //addMouseMotionListener(selection);
	    }

	    public void deplacementTuileLigne(Paneau p){
	    	x=p.colone*60;
	    	y=p.ligne*60;
	    	plateauJoueur.repaint();
	    }


		class Paneau extends JPanel{
			int ligne,colone;
			
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(int l,int c){
				ligne=l;
				colone=c;
				setSize(60,60);
				setBackground(Color.lightGray);
				
				// Ajoute un MouseListener (écouteur de souris) qui va
				// intercepter les clicks sur le Paneau
				addMouseListener(new MouseAdapter(){
						public void mouseReleased(MouseEvent e){
							deplacementTuileLigne((Paneau)e.getSource());
						}
					});
			}
			
			// Méthode qui est appelé à la création d'un Paneau et
			// dès que l'on fait un Paneau.repaint()
			
			public void paintComponent(Graphics g){
				// Appel de la méthode paintComponent de la classe parente
				super.paintComponent(g);
				
				
			}
			
		}

	}

    // SELECTION   https://www.daniweb.com/programming/software-development/threads/342036/how-to-select-images-by-using-a-rectangular-area

}