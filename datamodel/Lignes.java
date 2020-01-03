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

  public boolean isFull(int line){
    for (int i=0;i<line+1; i++) {
      if (!plateau[line][i].getTuileDessus()) {
        return false;
      }
    }
    return true;
  }

  public boolean isEmptyLine(int line){
    for (int i=0;i<line+1; i++) {
      if (getPlateau(line,i).getTuileDessus()) {
        return false;
      }
    }
    return true;
  }

  public boolean add(ArrayList<Tuile> t, int line){
    if (isFull(line)){
      System.out.println("Ligne complete");
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
    	if (t.get(0).getCouleur().equals(plateau[line][0].getTuile().getCouleur())){// je voudrais dire si ce n'est pas vide et que la couleur de t n'est pas la meme qeu la couleur deja presente sur la ligne 
        int i=0;
        while(plateau[line][i].getTuileDessus()){
          i++;
        }
        int n=Math.min(line+1,t.size()+i);
        for(int j=i;j<n;j++){
            this.plateau[line][j].setTuile(t.get(0));
            plateau[line][j].setTuileDessus(true);
            t.remove(this.plateau[line][j].getTuile());
        }
      }
    }

    if(!t.isEmpty()){
      //si t n'est paqs vide ajouter le reste   au plancher 
      return false;
      
    }else{
      return true;
    } // permet dajouter au plancher le reste qui n'a pas ete ajouter
    
  }

  public int removeLine(int line, ArrayList<Tuile> defausse, int score,Mur m){
    int n=m.addMur(this,plateau[line][0].getTuile(), line , score);
    for(int i=0;i<taille;i++){
      defausse.add(plateau[line][i].getTuile());
      plateau[line][i].setTuileDessus(false);
      plateau[line][i].setTuile(null);
    }
    return n;
  }

 

}
