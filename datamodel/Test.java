import java.util.*;

public class Test{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrez le nombre de joueur");
		int n=sc.nextInt();
		Jeu j=new Jeu(n);
		//System.out.println(j.getJoueur(0).getMur());
		//System.out.println(j.getJoueur(0).getLigne());
		//System.out.println(j.getJoueur(0).getPlancher());
		//Fabrique []f=j.getFabrique();
	//	for(int i=0;i<f.length;i++){
			//f[i].remplirFabrique(j.getSac());
			//System.out.println(f[i]);
		//}
		j.partie();
		

	}

}