public class Lignes extends Plateau{
  private int taille=5;

  public Lignes(){
    plateau=new Case[taille][];
    for(int i=0;i<taille;i++){
      plateau[i]=new Case[i+1];
    }

  }

}
