public class Plateau{
	protected Case[][] plateau;
	private int largeur,longueur;

	public Plateau(){}
	public Plateau(int n,int m){
		largeur=m;
		longueur=n;
		plateau =new Case[n][m];
	}
	public Case[][] getPlateau(){
		return plateau;
	}
	public void setPlateau(Case[][] c){
		plateau=c;
	}
	public void remplirPlateauVide(){
		for (int i=0;i<longueur;i++){
			for (int j=0;j<largeur;j++){
				plateau[i][j]=new Case();
			}
		}
	}

	public String toString(){ 
		String s="";
		for(int i=0; i<longueur;i++){
			for(int j=0;j<largeur;j++){
				s+=plateau[i][j].toString();// redefinir.toString dans case
				
			}
			s+="\n";

		}
		return s;
	}

}
