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
import javax.swing.border.*;
//import javax.swing.border.EtchedBorder;
//import javax.swing.border.TitledBorder;


public class VueInterface extends JFrame implements VueGeneral{

	public ModelJeu modele; 
	private PlateauFabrique plateauFabrique;
	private PlateauCentre plateauCentre;
	private PlateauJoueur plateauJoueur;
	private JLabel text;

	private Jeu jeu;

	public VueInterface(ModelJeu m){
		modele=m;
		jeu=modele.getJeu();
		plateauFabrique=new PlateauFabrique();
		plateauCentre=new PlateauCentre();
		plateauJoueur=new PlateauJoueur(0);
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

	// IMAGEPANE
    class PlateauFabrique extends JPanel{
    	int x1,y1;  //x1,y1 coordonnee de la tuile de depart et x2,y2 coordonnee de la tuile en mouvement

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
	      			int a=y+22;
	      			int b=x+i*150+22;
	      			if(j==2 || j==3) a+=50;
	      			if(j==1 || j==3) b+=50;   
	      			g.drawImage(image,b,a,this);  
		      		
	      		}
	      		catch(IOException e){
      				System.out.println("Image non trouvé");
    			}
	      	}
	      }	      
	    }

	    public PlateauFabrique(){
	    	addMouseListener(new MouseAdapter(){
	    		public void mouseClicked(MouseEvent e){
			      	if(modele.getStart()){
				        x1=e.getX();
				        y1=e.getY();
				        //plateauFabrique.repaint();
				    }
			    }
	    	});
	    }
	}
	class PlateauCentre extends JPanel{
		int x,y;
		
	    public void paintComponent(Graphics g){
	      	super.paintComponent(g);
	        int n=jeu.getCentre().size();

	   	    ArrayList<Tuile> centre=jeu.getCentre();
	        for(int i=0;i<n;i++){
	      		Tuile tuile=centre.get(i);
	      		String couleur=tuile.getCouleur();
	      		try{
	      			Image image=ImageIO.read(new File("Images/"+couleur+".png"));
	      			g.drawImage(image,i*50,i*50,this);  
	      		}
	      		catch(IOException e){
	  				System.out.println("Image non trouvé");
				}
		    }	      
	    }

	    public PlateauCentre(){
	    	addMouseListener(new MouseAdapter(){
	    		public void mouseClicked(MouseEvent e){
			      	if(modele.getStart()){
				        x=e.getX();
				        y=e.getY();
				        //plateauCentre.repaint();
				    }
			    }
	    	});
	    }
	}

	class PlateauLigne extends JPanel{
		int x,y; 
		Paneau[][] paneaux;
		int numJoueur;

	    public void paintComponent(Graphics g){
		    super.paintComponent(g);
		    

	      //g.drawImage(modele.getImage(),selection.x,selection.y,this);
	      
	    }

	    public PlateauLigne(int n){
	    	numJoueur=n;
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
	    	setBorder(new TitledBorder(new EtchedBorder(), "Ligne"));
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
	    	this.repaint();
	    }


		class Paneau extends JPanel{
			int ligne,colone;
			
			// Constructeur de Paneau
			// Reçoit une référence à la partie et son indice
			public Paneau(int l,int c){
				ligne=l;
				colone=c;
				setPreferredSize(new Dimension(50,50));
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
		Paneau[][] paneaux;
		int numJoueur;

	    public void paintComponent(Graphics g){
		    super.paintComponent(g);
			/*for(int i=0;i<paneaux.length;i++){
				for(int j=0;j<paneaux[i].length;j++){
					CaseCouleur cas=(CaseCouleur)jeu.getJoueur()[numJoueur].getMur().getPlateau()[i][j];
					String couleur =(cas).getCouleur();
					try{
						Image image=ImageIO.read(new File("Images/"+couleur+"bis.png"));
		      			g.drawImage(image,i*50,j*50,this);
		      		}
		      		catch(IOException e){
		  				System.out.println("Image non trouvé");
					}
				}
			}*/	
	    }

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
					int x=ligne*50;
					int y=colone*50;
	      			Image image=ImageIO.read(new File("Images/"+couleur+"bis.png"));
	      			g.drawImage(image,x,y,this);
	      		}
	      		catch(IOException e){
      				System.out.println("Image non trouvé");
    			}
			}
		}
	}
	class PlateauPlancher extends JPanel{
		//int x,y; 
		Paneau[] paneaux;
		int numJoueur;

	    public void paintComponent(Graphics g){
		    super.paintComponent(g);
		    

	      //g.drawImage(modele.getImage(),selection.x,selection.y,this);
	      
	    }

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
		      	
		    });
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