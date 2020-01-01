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
  	if(this.plateau[0][6].getTuileDessus()){
  		System.out.println("Plancher plein");
  	}else{
  		int j=0;
  		for(int i=0;i<t.size();i++){
  			if(t.get(i)!=null){
  				while (plateau[0][j].getTuileDessus()){
  					j++;
  				}
  				Tuile tuile=t.get(i);
  				plateau[0][j].setTuile(tuile);
  				t.remove(tuile);
  				j++;
  			}
  		}
  		/*int j=0;
  		for(int i=0; i<taille;i++){
  			if(!this.plateau[0][i].getTuileDessus()){
  				while(t.get(j)==null){
					j++;
				}
  				this.plateau[0][i].setTuile(t.get(j));
  				plateau[0][i].setTuileDessus(true);
  				t.remove(plateau[0][i].getTuile());
  				j++;
  			}
  		}*/
  	}
  	if(!t.isEmpty()) return false;  // permet de rajouter les tuile en trop dans la defausse si cest faux
  	else return true;
  }

  public void remiseAZero(ArrayList<Tuile> defausse){
  	for(int i=0; i<taille;i++){
  		if(this.plateau[0][i].getTuileDessus()){
  			defausse.add(this.plateau[0][i].getTuile());
  		}
  	}
  }
  // ecrire fonction qui remet le plancher a 0 et met les tuiles dans la defausse


  public int totalPlancher(){
  	int compt=0;
  	for(int i=0;i<taille;i++){
  		if(this.plateau[0][i].getTuileDessus()==true){
  			if(((CaseCouleur)this.plateau[0][i]).getCouleur()=="vert"){
  				compt-=1;
  			}
  			if(i<2){
  				compt-=1;
  			}else if(i<5){
  				compt-=2;
  			}else if(i<7){
  				compt-=3;
  			}
  		}
  	}
  	return compt;
  }


}
