public class Plateau{
	protected Case[][] plateau;
	private final int largeur,longueur;

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
	public int getLargeur(){
		retrun largeur;
	}
	public int getLongeur(){
		retrun largeur;
	}
	public void remplirPlateauVide(){
		for (int i=0;i<longueur;i++){
			for (int j=0;j<largeur;j++){
				plateau[i][j]=new Case();
			}
		}
	}

}
