public class Plateau{
	private Case[][] plateau;
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

}
