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
	private PlateauLigne plateauLigne;
	private JLabel text;

	private Jeu jeu;

	public VueInterface(ModelJeu m){
		modele=m;
		jeu=modele.getJeu();

		plateauFabrique=new PlateauFabrique();
		plateauLigne=new PlateauLigne();
		getContentPane().setLayout(new GridLayout(0,1));
    	getContentPane().add(plateauFabrique);
    	getContentPane().add(plateauLigne);

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
	      	g.fillOval(x+i*150,y,150,150);
	      	for(int j=0;j<4;j++){
	      		Tuile[] tas=modele.getJeu().getFabrique()[i].getTas();
	      		String couleur="bleu";
	      		if(tas[j]!=null){
	      			couleur=tas[j].getCouleur();
	      		}
	      		try{
	      			Image image=ImageIO.read(new File("Images/"+couleur+".png"));
	      			if(x>x1 && x+60>x1 && y<y1 && y+60>y1){
	    				g.drawImage(image,x2,y2,this);
	    			}
		      		else{
		      			int a=y+22;
		      			int b=x+i*150+22;
		      			if(j==2 || j==3) a+=50;
		      			if(j==1 || j==3) b+=50;   
		      			g.drawImage(image,b,a,this);  // mettre en carre
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

	class PlateauLigne extends JPanel{
		int x,y; 
		Paneau[][] paneaux;

	    public void paintComponent(Graphics g){
		    super.paintComponent(g);
		    Tuile tuile=jeu.getLigne().getPlateau

	      //g.drawImage(modele.getImage(),selection.x,selection.y,this);
	      
	    }

	    public PlateauLigne(){
	    	paneaux=new Paneau[5][];
	    	JPanel[] tabPanel=new JPanel[5];
	    	for(int i=0;i<5;i++){
	    		paneaux[i]=new Paneau[i+1];
	    		tabPanel[i]=new JPanel();
	    		tabPanel[i].setLayout(new BoxLayout(tabPanel[i],BoxLayout.LINE_AXIS));
	    		for(int j=0;j<i+1;j++){
	    			paneaux[i][j]=new Paneau(i,j);
	    			tabPanel[i].add(paneaux[i][j]);

	    		}
	    	}
	    	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    	for(int i=0;i<tabPanel.length;i++){
	    		this.add(tabPanel[i]);
	    	}

		    //this.setPreferredSize(new Dimension(model.getImage().getWidth(),model.getImage().getHeight()));
		    addMouseListener(new MouseAdapter(){
		      	
		    });
	    }

	    public void deplacementTuileLigne(Paneau p){
	    	x=p.colone*50;
	    	y=p.ligne*50;
	    	plateauLigne.repaint();
	    }


		class Paneau extends JPanel{
			int ligne,colone;
			
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(int l,int c){
				ligne=l;
				colone=c;
				setSize(50,50);
				setBackground(Color.lightGray);
				setBorder(BorderFactory.createLineBorder(Color.black));
				
				// Ajoute un MouseListener (écouteur de souris) qui va
				// intercepter les clicks sur le Paneau
				addMouseListener(new MouseAdapter(){
					public void mouseReleased(MouseEvent e){
						deplacementTuileLigne((Paneau)e.getSource());
					}
				});
			}
			
		}

	}

	class PlateauMur extends JPanel{

	    public void paintComponent(Graphics g){
		    super.paintComponent(g);

		    int n=jeu.getMur().length;
		   	int x=0;
		   	int y=0;
		    for(int i=0;i<n;i++){
		    	for(int j=0;j<n;j++){

		    	}
		      	
	        }
	      //g.drawImage(modele.getImage(),selection.x,selection.y,this);
	      
	    }

	    public PlateauMur(){
	    }

	    class Paneau extends JPanel{
			String couleur;
			int ligne,colone;
			
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(String c,int l,int c){
				couleur =c;
				setSize(50,50);
				setBackground(Color.lightGray);
				setBorder(BorderFactory.createLineBorder(Color.black));

			
			public void paintComponent(Graphics g){
				// Appel de la méthode paintComponent de la classe parente
				super.paintComponent(g);
				try{
	      			Image image=ImageIO.read(new File("Images/"+couleur+"bis.png"));
	      			g.drawImage(image,x,y,this);
	      		}
	      		catch(IOException e){
      				System.out.println("Image non trouvé");
    			}
			}
		}

	}

	class PlateauJoueur extends JPanel{
		PlateauMur plateauMur;
		PlateauLigne plateauLigne;
		PlateauPlancher plateauPlancher;

		public PlateauJoueur(){
			plateauMur=new PlateauMur();
			plateauLigne=new PlateauLigne();
			plateauPlancher=new PlateauPlancher();
		}
		public void paintComponent(Graphics g){
			// Appel de la méthode paintComponent de la classe parente
			super.paintComponent(g);
			plateauLigne.repaint();
			plateauPlancher.repaint();
			plateauMur.repaint();	
		}
	}

    // SELECTION   https://www.daniweb.com/programming/software-development/threads/342036/how-to-select-images-by-using-a-rectangular-area

}