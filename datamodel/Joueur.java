
import java.util.*;

public class Joueur{
	private final String nom;
	private int score;
	private final Mur mur;
	private final Lignes ligne;
	private final Plancher plancher;

	public Joueur(){
		score=0;
		mur =new Mur();
		ligne=new Lignes();
		plancher=new Plancher();
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrez votre nom");
		nom=sc.next();
	}

	public Mur getMur(){
		return mur;
	}
	public Lignes getLigne(){
		return ligne;
	}
	public Plancher getPlancher(){
		return plancher;
	}
	public String getNom(){
		return nom;
	}
	public int getScore(){
		return score;
	}
	public void setScore(int s){
		score=s;
	}

	//regarde si il y a une ligne complete dans le mur
	public boolean isFullLine(){
		for(int i=0;i<mur.getTaille();i++){
			boolean b=true;
			for(int j=0;j<mur.getTaille();j++){
				if(!mur.getPlateau(i,j).getTuileDessus()) b=false;
			}
			if(b) return true;
		}
		return false;
	}


}
