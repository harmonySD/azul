public class CaseCouleur extends Case{
	private String couleur;

  	public CaseCouleur(String c){
    	super();
    	couleur=c;
  	}

  	public String getCouleur(){
		return couleur;
	}

	public void setCouleur(String c){
		couleur=c;
	}

  public String toString(){
  	String s="";
	if(this.couleur=="orange"){
		s+="⏹ ";
	}
	if (this.couleur=="rouge") {
		s+="🆘";
	}
	if (this.couleur=="noir") {
		s+="✴️ ";
	}
	if(this.couleur=="blanc"){
		s+="☑️ ";
	}
	if(this.couleur=="bleu"){
		s+="🚹";
	}
	if(this.couleur=="ok"){
		s+="x";
	}
			
	return s;
	}

}
