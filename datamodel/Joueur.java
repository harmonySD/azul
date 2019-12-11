import java.util.*;

public class Joueur{
	private String nom;
	private int score;
	private Mur mur;
	private Lignes ligne;
	private Plancher plancher;

	public Joueur(){
		score=0;
		mur =new Mur();
		ligne=new Lignes();
		plancher=new Plancher();
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrez votre nom");
		nom=sc.next();
	}


}
