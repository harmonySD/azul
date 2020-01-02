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
  public int addMur(Lignes li,Tuile t,int line,int score){
    int compt =score;
    String couleur=li.plateau[line][0].getTuile().getCouleur();
    for(int j=0;j<taille;j++){
      if(((CaseCouleur)plateau[line][j]).getCouleur().equals(couleur)){
        plateau[line][j].setTuile(t);
        plateau[line][j].setTuileDessus(true);
        compt++;
        if(j>0 && plateau[line][j-1].getTuileDessus()) compt++;  // marche pas si la tuile a deux ou plus de voisins sur la droite, etc
        if(j<taille-1 && plateau[line][j+1].getTuileDessus()) compt++;
        if(line>0 && plateau[line-1][j].getTuileDessus()) compt++;
        if(line<taille-1 && plateau[line+1][j].getTuileDessus()) compt++;
      }
    }
    return compt;
  }
}
