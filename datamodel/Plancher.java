public class Plancher extends Plateau{

  public int taille=7;

  public Plancher(){
    super(1,7);
    remplirPlateauVide();
  }

  public int getTaille(){
    return taille;
  }

  public void addPlancher(ArrayList<Tuile> t){
  	if(this[0][6] !=null){
  		System.out.println("Plancher plein");
  	}else{
  		int j=0;
  		for(int i=0; i<taille;i++){
  			if(this[0][i]=null){
  				this.plateau[0][i]=t.get(j);
  				//floor[i]=t.get(j);  // cest quoi floor
  				j++;
  			}
  		}
  	}
  }


}
