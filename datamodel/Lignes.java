import java.util.*;

public class Lignes extends Plateau{
  private int taille=5;

  public Lignes(){
  	 super(5,5);
  	 remplirPlateauVide();
  }
  public String toString(){ 
		String s="";
		for(int i=0; i<taille;i++){
      s+=i+" : ";
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

  //regarder si la ligne (line) est pleine
  public boolean isFull(int line){
    for (int i=0;i<line+1; i++) {
      if (!plateau[line][i].getTuileDessus()) {
        return false;
      }
    }
    return true;
  }

  //regarder si la ligne (line) est vide
  public boolean isEmptyLine(int line){
    for (int i=0;i<line+1; i++) {
      if (getPlateau(line,i).getTuileDessus()) {
        return false;
      }
    }
    return true;
  }

  //ajoute t a la ligne (line) et gere si il y a trop de tuile ou pas assez ou 
  //s'il y a deja une tuile d'une couleur sur cette ligne
  public boolean add(ArrayList<Tuile> t, int line){
    if (isFull(line)){
      return false;
    } 
    if (isEmptyLine(line)){
      int n=Math.min(line+1,t.size());
    	for(int i=0;i<n;i++){
        Tuile tuile=t.get(0);
        if(!tuile.getCouleur().equals("vert")){
      		this.plateau[line][i].setTuile(tuile);
      		plateau[line][i].setTuileDessus(true);
      		t.remove(tuile); 
        }
    	}
    }	 
    else{
    	if (!t.get(0).getCouleur().equals(plateau[line][0].getTuile().getCouleur())){
      }
      else{
        int i=0;
        while(plateau[line][i].getTuileDessus()){
          i++;
        }
        int n=Math.min(line+1,t.size()+i);
        for(int j=i;j<n;j++){
          if(!t.get(0).getCouleur().equals("vert")){
            this.plateau[line][j].setTuile(t.get(0));
            plateau[line][j].setTuileDessus(true);
            t.remove(this.plateau[line][j].getTuile());
          }
        }
      }
    }

    if(!t.isEmpty()) return false; //si t n'est pas vide ajouter le reste   au plancher 
    else return true;    
  }

  //ajoute au mur si la ligne est pleine et vide cette ligne dans la defausse en rendant le plateau de ligne vide
  public int removeLine(int line, ArrayList<Tuile> defausse, int score,Mur m){
    int n=m.addMur(this,plateau[line][0].getTuile(), line , score);
    for(int i=0;i<plateau[line].length;i++){
      defausse.add(plateau[line][i].getTuile());
      plateau[line][i].setTuileDessus(false);
      plateau[line][i].setTuile(null);
    }
    return n;
  }
 

}
