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
  	if(this[6] !=null){
  		System.out.println("Plancher plein");
  	}else{
  		int j=0;
  		for(int i=0; i<6;i++){
  			if(this[i] =null){
  				floor[i]=t[j];
  				j++;
  			}
  		}
  	}
  }


}
