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
  public void addMur(Lignes li){//dans ligne il faudra regarder si la couleur n'est pas deja sur le mur
    for(int i=0;i<taille;i++){
      if(li.isFull(i)){
        String couleur=li[0][0].getCouleur();
        for(int j=0;j<taille;j++){
          for(int k=0;k<taille;k++){
            if(i==j){
              //regarde  si la case a la position k est de a meme couleur qeu couleur
              //si oui setcouleur de la case a la position k

            }
          }
        }
      }
    }

    //pour toutes les lignes 
    //if isfull(i)
    //regarder la couler de la tuile 
    //changer la couleur avec setcouleur en ok 


  }

}
