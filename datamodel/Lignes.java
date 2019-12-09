public class Lignes extends Plateau{
  private int taille=5;

  public Lignes(){
    setPlateau(new Case[taille][]);
    for(int i=1;i<=taille;i++){
      getPlateau()[i]=new Case[i];
    }

  }

}
