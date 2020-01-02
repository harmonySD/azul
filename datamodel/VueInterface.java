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
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
//import java.awt.event.MouseEvent;
import javax.swing.undo.*;
//import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.border.*;
//import javax.swing.border.EtchedBorder;
//import javax.swing.border.TitledBorder;


public class VueInterface extends JFrame implements VueGeneral{

	public ModelJeu modele; 
	private PlateauFabrique plateauFabrique;
	private PlateauCentre plateauCentre;
	private PlateauJoueur plateauJoueur;

	private Jeu jeu;
	private Joueur joueur;

	public Joueur getJoueur(){
		return joueur;
	}
	public void setJoueur(Joueur j){
		joueur=j;
	}

	public VueInterface(ModelJeu m){
		modele=m;
		jeu=modele.getJeu();
		joueur=jeu.getJoueur()[0];
		plateauFabrique=new PlateauFabrique();
		plateauCentre=new PlateauCentre();
		plateauJoueur=new PlateauJoueur(joueur.getNum());
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(0,1));
		p1.add(plateauFabrique);
		p1.add(plateauCentre);

		getContentPane().setLayout(new GridLayout(0,1));
		
    	getContentPane().add(p1);
    	getContentPane().add(plateauJoueur);

		setTitle("Azul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void partie(){
		modele.partie();
	}

	public void fin(){
		JLabel text;
		JPanel p=new JPanel();
		Joueur j=jeu.getJoueur()[0];
		for(int i=0;i<jeu.getJoueur().length;i++){
			JLabel t=new JLabel(jeu.getJoueur()[i].getNom()+" : "+jeu.getJoueur()[i].getScore()+", ");
			p.add(t);
			if(j.getScore()<jeu.getJoueur()[i].getScore()) j=jeu.getJoueur()[i];
		}
		text=new JLabel("-> "+j.getNom()+" a gagné avec un score de "+ j.getScore(), JLabel.CENTER);
		p.add(text);
		this.getContentPane().add(p);
	}

	// IMAGEPANE
    class PlateauFabrique extends JPanel{
    	int xDepart=0;
		int numFab=0; // coordonnee de la tuile de depart 
		Paneau[][] paneaux;

	    public PlateauFabrique(){
	    	int taille=jeu.getFabrique().length;
	    	paneaux=new Paneau[taille][jeu.getFabrique()[0].getNbTuile()];
	    	JPanel[] tabPanel=new JPanel[taille];
	    	for(int i=0;i<taille;i++){
	    		tabPanel[i]=new JPanel();
	    		tabPanel[i].setLayout(new GridLayout(2,2));
	    		for(int j=0;j<paneaux[i].length;j++){
	    			if(!jeu.getFabrique()[i].tasVide()){ 
	    				paneaux[i][j]=new Paneau(j,jeu.getFabrique()[i].getTas()[j].getCouleur(),i);
	    				tabPanel[i].add(paneaux[i][j]);
	    			}
	    		}
	    	}
	        setBorder(new TitledBorder(new EtchedBorder(), "Fabrique"));
	        setLayout(new GridLayout(1,0,20,20));
	    	//setLayout(new BorderLayout(20,20));
	    	for(int i=0;i<tabPanel.length;i++){
	    		if(paneaux[i]!=null) this.add(tabPanel[i],BorderLayout.WEST);
	    	}    
	    	
	    	addMouseListener(new MouseAdapter(){
	    		public void mouseClicked(MouseEvent e){
			    }
	    	});
	    }
	    public void enregistrerTuile(Paneau p){
	    	xDepart=p.colone;
	    	this.numFab=p.numFab;
	    	modele.enregistrerTuile(xDepart,numFab);
	    }

		class Paneau extends JPanel{
			int numFab;
			int colone;
			String couleur;
			
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(int c,String co,int n){
				colone=c;
				numFab=n;
				couleur=co;
				setPreferredSize(new Dimension(40,40));
				setBorder(BorderFactory.createLineBorder(Color.black));
				
				// Ajoute un MouseListener (écouteur de souris) qui va
				// intercepter les clicks sur le Paneau
				addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						enregistrerTuile((Paneau)e.getSource());
					}
				});
			}
			public void paintComponent(Graphics g){
				// Appel de la méthode paintComponent de la classe parente
				super.paintComponent(g);
				try{
	      			BufferedImage image=ImageIO.read(new File("Images/"+couleur+".png"));
	      			g.drawImage(image,0,0,this);
	      		}
	      		catch(IOException e){
      				System.out.println("Image non trouvé");
    			}
			}
		}
	}
	class PlateauCentre extends JPanel{
		int xDepart=0;
		int yDepart=0; // coordonnee de la tuile de depart 
		Paneau[] paneaux;

	    public PlateauCentre(){
	    	int taille=jeu.getCentre().size();
	    	paneaux=new Paneau[taille];
	    	JPanel[] tabPanel=new JPanel[taille];
	    	for(int i=0;i<taille;i++){
	    		tabPanel[i]=new JPanel();
	    		tabPanel[i].setLayout(new BoxLayout(tabPanel[i],BoxLayout.LINE_AXIS));
	    		paneaux[i]=new Paneau(i,jeu.getCentre().get(i).getCouleur());
	    		tabPanel[i].add(paneaux[i]);
	    	}
	    	setBorder(new TitledBorder(new EtchedBorder(), "Centre"));
	    	setLayout(new GridLayout(1,0));
	    	for(int i=0;i<tabPanel.length;i++){
	    		this.add(tabPanel[i]);
	    	}
	    	addMouseListener(new MouseAdapter(){
	    		public void mouseClicked(MouseEvent e){
			      	if(modele.getStart()){
				        xDepart=e.getX();
				        yDepart=e.getY();
				        //plateauCentre.repaint();
				    }
			    }
	    	});
	    }
	    public void deplacementTuileLigne(Paneau p){
	    	xDepart=p.colone;
	    	yDepart=0;
	    	
	    	this.repaint();
	    }

		class Paneau extends JPanel{
			int colone;
			String couleur;
			
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(int c,String co){
				colone=c;
				couleur=co;
				setPreferredSize(new Dimension(50,50));
				setBorder(BorderFactory.createLineBorder(Color.black));
				
				// Ajoute un MouseListener (écouteur de souris) qui va
				// intercepter les clicks sur le Paneau
				addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						//(Paneau)e.getSource()
					}
				});
			}
			public void paintComponent(Graphics g){
				// Appel de la méthode paintComponent de la classe parente
				super.paintComponent(g);
				try{
	      			BufferedImage image=ImageIO.read(new File("Images/"+couleur+".png"));
	      			g.drawImage(image,0,0,this);
	      		}
	      		catch(IOException e){
      				System.out.println("Image non trouvé");
    			}
			}
		}
	}

	class PlateauLigne extends JPanel{
		int xArrive=0;
		Paneau[][] paneaux;
		int numJoueur;

	    public PlateauLigne(int n){
	    	numJoueur=n;
	    	paneaux=new Paneau[5][];
	    	JPanel[] tabPanel=new JPanel[5];
	    	for(int i=0;i<5;i++){
	    		paneaux[i]=new Paneau[i+1];
	    		tabPanel[i]=new JPanel();
	    		tabPanel[i].setLayout(new BoxLayout(tabPanel[i],BoxLayout.LINE_AXIS));
	    		for(int j=0;j<i+1;j++){
	    			paneaux[i][j]=new Paneau(i);
	    			tabPanel[i].add(paneaux[i][j]);
	    		}
	    	}
	    	setBorder(new TitledBorder(new EtchedBorder(), "Ligne"));
	    	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    	for(int i=0;i<tabPanel.length;i++){
	    		this.add(tabPanel[i]);
	    	}
	    }

	    public void deplacementTuileLigne(Paneau p){
	    	xArrive=p.ligne;
	    	modele.deplacementTuileLigne(xArrive);
	    }


		class Paneau extends JPanel{
			int ligne;
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(int l){
				ligne=l;
				setPreferredSize(new Dimension(50,50));
				setBackground(Color.lightGray);
				setBorder(BorderFactory.createLineBorder(Color.black));
				
				// Ajoute un MouseListener (écouteur de souris) qui va
				// intercepter les clicks sur le Paneau
				addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						deplacementTuileLigne((Paneau)e.getSource());
					}
				});
			}
			
		}

	}
	class PlateauMur extends JPanel{
		Paneau[][] paneaux;
		int numJoueur;

	    public PlateauMur(int n){
	    	numJoueur=n;
	    	paneaux=new Paneau[5][5];
	    	JPanel[] tabPanel=new JPanel[5];
	    	for(int i=0;i<paneaux.length;i++){
	    		tabPanel[i]=new JPanel();
	    		tabPanel[i].setLayout(new BoxLayout(tabPanel[i],BoxLayout.LINE_AXIS));
		    	for(int j=0;j<paneaux[i].length;j++){
		    		CaseCouleur cas=(CaseCouleur)jeu.getJoueur()[numJoueur].getMur().getPlateau()[i][j];
		    		String couleur =cas.getCouleur();
		    		paneaux[i][j]=new Paneau(couleur,i,j);
		    		tabPanel[i].add(paneaux[i][j]);
		    	}
	        }
	        setBorder(new TitledBorder(new EtchedBorder(), "Mur"));
	    	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    	for(int i=0;i<tabPanel.length;i++){
	    		this.add(tabPanel[i]);
	    	}
	    }

	    class Paneau extends JPanel{
			String couleur;
			int ligne,colone;
			
			public Paneau(String co,int l,int c){
				couleur =co;
				ligne=l;
				colone=c;
				setPreferredSize(new Dimension(50,50));
				setBorder(BorderFactory.createLineBorder(Color.black));
				repaint();
			}

			
			public void paintComponent(Graphics g){
				// Appel de la méthode paintComponent de la classe parente
				super.paintComponent(g);
				try{
	      			BufferedImage image=ImageIO.read(new File("Images/"+couleur+"bis.png"));
	      			g.drawImage(image,0,0,this);
	      		}
	      		catch(IOException e){
      				System.out.println("Image non trouvé");
    			}
			}
		}
	}
	class PlateauPlancher extends JPanel{
		int xArrive=0;
		int yArrive=0; 
		Paneau[] paneaux;
		int numJoueur;

	    public PlateauPlancher(int n){
	    	numJoueur=n;
	    	int taille=jeu.getJoueur()[numJoueur].getPlancher().getTaille();
	    	paneaux=new Paneau[7];
	    	JPanel[] tabPanel=new JPanel[7];
	    	for(int i=0;i<7;i++){
	    		tabPanel[i]=new JPanel();
	    		if(i<2)	tabPanel[i].setBorder(new TitledBorder(new EtchedBorder(), "-1"));
	    		else if(i<5) tabPanel[i].setBorder(new TitledBorder(new EtchedBorder(), "-2"));
	    		else tabPanel[i].setBorder(new TitledBorder(new EtchedBorder(), "-3"));
	    		tabPanel[i].setLayout(new BoxLayout(tabPanel[i],BoxLayout.LINE_AXIS));
	    		paneaux[i]=new Paneau(i);
	    		tabPanel[i].add(paneaux[i]);
	    	}
	    	setBorder(new TitledBorder(new EtchedBorder(), "Plancher"));
	    	setLayout(new GridLayout(1,0));
	    	for(int i=0;i<tabPanel.length;i++){
	    		this.add(tabPanel[i]);
	    	}

		    //this.setPreferredSize(new Dimension(model.getImage().getWidth(),model.getImage().getHeight()));
		    addMouseListener(new MouseAdapter(){
		      	public void mouseClicked(MouseEvent e){
					deplacementTuilePlancher((Paneau)e.getSource());
				}
		    });
	    }

	    public void deplacementTuilePlancher(Paneau p){
	    	xArrive=p.colone;
	    	yArrive=0;

	    	this.repaint();
	    }

		class Paneau extends JPanel{
			int colone;
			
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(int c){
				colone=c;
				setPreferredSize(new Dimension(50,50));
				setBackground(Color.lightGray);
				setBorder(BorderFactory.createLineBorder(Color.black));
				
				// Ajoute un MouseListener (écouteur de souris) qui va
				// intercepter les clicks sur le Paneau
				addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						//deplacementTuilePlancher(this);
					}
				});
			}
			
		}

	}

	class PlateauJoueur extends JPanel{
		PlateauMur plateauMur;
		PlateauLigne plateauLigne;
		PlateauPlancher plateauPlancher;
		int numJoueur;

		public PlateauJoueur(int i){
			numJoueur=i;
			plateauMur=new PlateauMur(numJoueur);
			plateauLigne=new PlateauLigne(numJoueur);
			plateauPlancher=new PlateauPlancher(numJoueur);
			this.setLayout(new BorderLayout());
			this.add(plateauLigne,BorderLayout.WEST);
			this.add(plateauMur,BorderLayout.EAST);
			this.add(plateauPlancher,BorderLayout.SOUTH);
			
		}
		public void paintComponent(Graphics g){
			// Appel de la méthode paintComponent de la classe parente
			super.paintComponent(g);
			setBorder(new TitledBorder(new EtchedBorder(), jeu.getJoueur()[numJoueur].getNom()+ " score : "+jeu.getJoueur()[numJoueur].getScore()));
			plateauLigne.repaint();
			plateauPlancher.repaint();
			plateauMur.repaint();	
		}
	}
    // SELECTION   https://www.daniweb.com/programming/software-development/threads/342036/how-to-select-images-by-using-a-rectangular-area

}