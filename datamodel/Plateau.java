public class Plateau{
	protected Case[][] plateau;
	private final int largeur,longueur;

	//public Plateau(){}
	public Plateau(int n,int m){
		largeur=m;
		longueur=n;
		plateau =new Case[n][m];
	}
	public Case[][] getPlateau(){
		return plateau;
	}
	public Case getPlateau(int i,int j){
		return plateau[i][j];
	}
	public void setPlateau(Case[][] c){
		plateau=c;
	}
	public int getLargeur(){
		return largeur;
	}
	public int getLongeur(){
		return largeur;
	}
	public void remplirPlateauVide(){
		for (int i=0;i<longueur;i++){
			for (int j=0;j<plateau[i].length;j++){
				plateau[i][j]=new Case();
			}
		}
	}
	public String toString(){ 
		String s="";
		for(int i=0; i<longueur;i++){
			for(int j=0;j<plateau[i].length;j++){
				if(plateau[i][j].getTuileDessus()) s+= plateau[i][j].getTuile();
				else s+=plateau[i][j].toString();	
			}
			s+="\n";
		}
		return s;
	}

}
