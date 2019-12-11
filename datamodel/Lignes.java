public class Lignes extends Plateau{
  private int taille=5;

  public Lignes(){
    this.plateau=new Case[taille][];
    for(int i=0;i<this.taille;i++){
      this.plateau[i]=new Case[i+1];
    }

  }

}
