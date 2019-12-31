import java.util.*;

public class Fabrique{
	private Tuile [] tas;
	private final int nbTuile=4;

	public Fabrique(){
		tas=new Tuile[nbTuile];
	}

	public Tuile[] getTas(){
  		return tas;
  }
	public void setTas(Tuile[] t){
 		tas=t;
 	}
 	public int getNbTuile(){
 		return nbTuile;
 	}

  public void remplirFabrique(ArrayList<Tuile> sac){

  }
  // prend toutes les tuiles d'une certaines couleur et retourne une ArrayList
  public ArrayList<Tuile> take(String c){
  	ArrayList<Tuile> sameColor =new ArrayList<Tuile>();
  	for(int i=0;i<tas.length;i++){
  		if(tas[i].getCouleur().equals(c)){
  			sameColor.add(tas[i]);
  		}
  	}
  	return sameColor;
  }

  	public String toString(){ 
		String s="";
		for(int i=0; i<nbTuile;i++){
			System.out.println("coucou");
			s+=tas[i].getCouleur().toString();
			if(i==1){
				s+="\n";
			}
			
		}
		return s;
	}



}
