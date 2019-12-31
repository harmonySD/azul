import java.util.*;

public class Plancher extends Plateau{

  public int taille=7;

  public Plancher(){
    super(1,7);
    remplirPlateauVide();
  }

  public int getTaille(){
    return taille;
  }

  public boolean addPlancher(ArrayList<Tuile> t){
  	if(this.plateau[0][6] !=null){
  		System.out.println("Plancher plein");
  	}else{
  		int j=0;
  		for(int i=0; i<taille;i++){
  			if(this.plateau[0][i]==null){
  				this.plateau[0][i].setTuile(t.get(j));
  				plateau[0][i].setTuileDessus(true);
  				t.remove(plateau[0][i].getTuile());
  				j++;
  			}
  		}
  	}
  	if(!t.isEmpty()) return false;  // permet de rajouter les tuile en trop dans la defausse si cest faux
  	else return true;
  }


}
