public class Case{
  private boolean tuileDessus;
  protected Tuile tuile;

  public Case(){
    tuileDessus=false;
    tuile=null;
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
}


