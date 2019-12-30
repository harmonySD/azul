public class Lignes extends Plateau{
  private int taille=5;


  public Lignes(){
  	 super(5,5);
  	 remplirPlateauVide();
  }
  	public String toString(){ 
		String s="";
		for(int i=0; i<taille;i++){
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

  public boolean isEmpty(int line){
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

  public void add(ArrayList<Tuile> t, int line){
    if (isFull(line)){
      addPlancher(t);
    }
    if () {
      
    }

  }



 

}
