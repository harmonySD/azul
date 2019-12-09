public class Mur extends Plateau {
  public int taille=5;

  public Mur(){
    super(5,5);
    remplirPlateauVide();
  }
  public void remplirPlateauVide(){
		for (int i=0;i<taille;i++){
			for (int j=0;j<taille;j++){
        String s="";
        if(i==j) s="bleu";
        else if(i==j+1%taille) s="orange";
        else if(i==j+2%taille) s="rouge";
        else if(i==j+3%taille) s="noir";
        else if(i==j+4%taille) s="blanc";
				getPlateau()[i][j]=new CaseCouleur(s);
			}
		}
	}

}
