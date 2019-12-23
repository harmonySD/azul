public class Case{
	private boolean tuileDessus;
	private Tuile tuile;

	public Case(){
		tuileDessus=false;
	    tuile=null;
	}

	public boolean getTuileDessus(){
	  	return tuileDessus;
	}
	public void setTuileDessus(boolean b){
	  	tuileDessus=b;
	}
	public Tuile getTuile(){
	  	return tuile;
	}
	public void setCouleur(Tuile t){
	  	tuile=t;
	}
	  public String toString(){
  	String s="";
		
	if (this.tuileDessus==false){
		s+="* ";
	}
	else{
		if(this.tuile.getCouleur()=="orange"){
			s+="🔶 ";
		}
		if (this.tuile.getCouleur()=="rouge") {
			s+="🔴 ";
		}
		if (this.tuile.getCouleur()=="noir") {
			s+="🔳 ";
		}
		if(this.tuile.getCouleur()=="blanc"){
			s+="🔲 ";
		}
		if(this.tuile.getCouleur()=="bleu"){
			s+="🔵 ";
		}
					
	}
	
	return s;
	}

	public String toString(){
		return "*";
	}

}


