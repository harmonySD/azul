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

  public ArrayList<Tuile> take(String c){
  	ArrayList<Tuile> sameColor =new ArrayList<Tuile>();
  	for(int i=0;i<tas.size();i++){
  		if(tas[i].getCouleur().equals(c)){
  			sameColor.add(tas[i]);
  		}
  	}
  }


}
