import java.util.*;

public class Test{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrez le nombre de joueur");
		int n=sc.nextInt();
		Jeu jeu=new Jeu(n);
		//System.out.println(j.getJoueur(0).getMur());
		//System.out.println(j.getJoueur(0).getLigne());
		//System.out.println(j.getJoueur(0).getPlancher());
		//Fabrique []f=j.getFabrique();
	//	for(int i=0;i<f.length;i++){
			//f[i].remplirFabrique(j.getSac());
			//System.out.println(f[i]);
		//}
		//j.partie();
		Joueur j1=jeu.getJoueur()[0];
		Joueur j2=jeu.getJoueur()[1];
		j1.getLigne().getPlateau()[0][0].setTuile(new Tuile("orange"));
		j1.getLigne().getPlateau()[0][0].setTuileDessus(true);
		j1.getLigne().getPlateau()[1][0].setTuile(new Tuile("rouge"));
		j1.getLigne().getPlateau()[1][0].setTuileDessus(true);
		j1.getLigne().getPlateau()[1][1].setTuile(new Tuile("rouge"));
		j1.getLigne().getPlateau()[1][1].setTuileDessus(true);

		j2.getLigne().getPlateau()[0][0].setTuile(new Tuile("rouge"));
		j2.getLigne().getPlateau()[0][0].setTuileDessus(true);
		j2.getLigne().getPlateau()[1][0].setTuile(new Tuile("rouge"));
		j2.getLigne().getPlateau()[1][0].setTuileDessus(true);
		j2.getLigne().getPlateau()[1][1].setTuile(new Tuile("rouge"));
		j2.getLigne().getPlateau()[1][1].setTuileDessus(true);

		/*jeu.getCentre().remove(0);
		for (int i=0;i<jeu.getFabrique().length;i++){
			for(int j=0;j<jeu.getFabrique()[i].getTas().length;j++){
				jeu.getFabrique()[i].getTas()[j]=null;
			}
		}*/
		System.out.println(j1.getMur());
		System.out.println(j1.getLigne());
		System.out.println(j1.getPlancher());
		jeu.decoration();
		System.out.println(j1.getMur());
		System.out.println(j1.getLigne());
		System.out.println(j1.getPlancher());
		jeu.fin();

	}

}