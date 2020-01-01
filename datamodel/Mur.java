import java.util.*;

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
        else if(i==j+1%taille) s="blanc";
        else if(i==j+2%taille) s="noir";
        else if(i==j+3%taille) s="rouge";
        else if(i==j+4%taille) s="orange";
        else if(i+1%taille==j) s="orange";
        else if(i+2%taille==j) s="rouge";
        else if(i+3%taille==j) s="noir";
        else if(i+4%taille==j) s="blanc";
        getPlateau()[i][j]=new CaseCouleur(s);
      }
    }
  }

  public int getTaille(){
    return taille;
  }
  public void addMur(Lignes li,Tuile t,int i,int score){
    int compt =score;
    String couleur=li.plateau[i][0].getCouleur();
      for(int j=0;j<taille;j++){
        if(plateau[i][j].getCouleur()==couleur){
          plateau[i][j].setCouleur("ok");
          compt++;
          if(plateau[i][j-1].getTuileDessus) compt++;
          if(plateau[i][j+1].getTuileDessus) compt++;
          if(plateau[i-1][j].getTuileDessus) compt++;
          if(plateau[i+1][j].getTuileDessus) compt++;
        }
      }
  }
}
