

public class Tuile{
	private final String couleur;

	public Tuile(String c){
		couleur=c;
	}

	public String getCouleur(){
		return couleur;
	}

	public String toString(){
		if(couleur=="orange"){
    			return "🔶";
		}
		else if(couleur=="rouge") {
			return "🔴";
		}
		else if(couleur=="noir") {
			return "🔳";
		}
		else if(couleur=="blanc"){
			return "🔲";
		}
		else if(couleur=="bleu"){
			return "🔵";
		}
		else if (couleur=="vert"){
			return "-1";
		}
		else{
			return "erreur";
		}

	}


}
