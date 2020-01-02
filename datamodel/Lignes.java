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
    boolean b=true;
    for (int i=0;i<taille;i++){
      for (int j=0;j<i+1 ;j++ ) {
        if (i==line) {
          if(getPlateau(i,j).getTuileDessus()==false){
            b= false;
            return b;
          }else{
            b=true;
          }
          
        }
      }
    }
    return b;
  }

  public boolean isEmptyLine(int line){
    boolean b=false;
    for (int i=0;i<taille; i++) {
      for (int j=0; j<i+1; j++) {
        if (i==line){
          if (getPlateau(i,j).getTuileDessus()==true) {
              b=true;
              return b;
          }else{
            b=true;
          }
        }
      }
    }
    return b;
  }

  public boolean add(ArrayList<Tuile> t, int line){
    if (isFull(line)){
      System.out.println("Ligne complete");
      return false;
    } 
    if (isEmptyLine(line)){
      int n=line+1;
      System.out.println(t.size());
      if(n>t.size()) n=t.size();
      System.out.println(n);
    	for(int i=0;i<n;i++){
        if(t.get(i)!=null){
      		this.plateau[line][i].setTuile(t.get(i));
      		plateau[line][i].setTuileDessus(true);
      		t.remove(this.plateau[line][i].getTuile());
        }
    	}
    }	 
    else{
    	if (!t.get(0).getCouleur().equals(plateau[line][0])){// je voudrais dire si ce n'est pas vide et que la couleur de t n'est pas la meme qeu la couleur deja presente sur la ligne 
      	System.out.println("Mauvaise ligne, pas la bonne couleur");  // je pense il faut le gerer dans une exception
      }
      else{
        int i=0;
        while(plateau[line][i].getTuileDessus()){
          i++;
        }
        for(int j=i;j<line+1;j++){
          if(t.get(j)!=null){
            this.plateau[line][j].setTuile(t.get(j));
            plateau[line][j].setTuileDessus(true);
            t.remove(this.plateau[line][j].getTuile());
          }
        }
      }
    }

    if(!t.isEmpty()){
      //System.out.println("pb");
      //si t n'est paqs vide ajouter le reste   au plancher 
      return false;
      
    }else{
      return true;
    } // permet dajouter au plancher le reste qui n'a pas ete ajouter
    
  }

  public void removeLine(int line, ArrayList<Tuile> defausse, int score,Mur m){
    m.addMur(this,plateau[line][0].getTuile(), line , score);
    for(int i=1;i<taille;i++){
      defausse.add(plateau[line][i].getTuile());
    }
  }

 

}
