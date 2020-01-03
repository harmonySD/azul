

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

  //remplir les fabriques de tuile piocher aleatoirement dans le sac
  public void remplirFabrique(ArrayList<Tuile> sac){
  	for (int i=0; i<nbTuile;i++){
      Random r= new Random();
      int a =r.nextInt(sac.size());
      tas[i]=sac.get(a);
      sac.remove(a);
    }
  }

  // prend toutes les tuiles d'une certaines couleur et retourne une ArrayList
  public ArrayList<Tuile> take(String c, ArrayList<Tuile> center){
  	ArrayList<Tuile> sameColor =new ArrayList<Tuile>();
  	for(int i=0;i<tas.length;i++){
  		if(tas[i].getCouleur().equals(c)){
  			sameColor.add(tas[i]);
  		}else{
  			center.add(tas[i]); //mettre au centre les autres tuiles
  		}
  		tas[i]=null;
  	}
  	return sameColor;
  }

  // regarde si le tas n'a que des tuiles null
  public boolean tasVide(){
    for (int i=0;i<tas.length;i++){
      if(tas[i]!=null) return false;
    }
    return true;
  }

  public String toString(){ 
		String s="";
		for(int i=0; i<nbTuile;i++){
			s+=tas[i].toString();
			if(i==1){
				s+="\n            ";
			}	
		}
		s+="\n";
		return s;
	}

}
