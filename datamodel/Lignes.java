

public class Lignes extends Plateau{
  private int taille=5;
/*
  public Lignes(){

    this.plateau=new Case[taille][];

    for(int i=0;i<this.taille;i++){

      this.plateau[i]=new Case[i+1];
    }
    remplirPlateauVide();

  }
*/

  public Lignes(){
  	 super(5,5);
  	 remplirPlateauVide();
  }
  	public String toString(){ 
		String s="";
		for(int i=0; i<taille;i++){
			for(int j=0;j<i+1;j++){
				s+=plateau[i][j].toString();	
			}
			s+="\n";
		}
		return s;
	}

  public int getTaille(){
    return taille;
  }



 

}
