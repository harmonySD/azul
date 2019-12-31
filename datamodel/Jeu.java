import java.util.*;

public class Jeu{
	private final Joueur[] joueurs;
	private final Fabrique[] fabriques;
	private ArrayList<Tuile> centre;
	private ArrayList<Tuile> sac;
	private ArrayList<Tuile> defausse;

	public Jeu(int n){
		joueurs=new Joueur[n];
		for (int i=0; i<n; i++){
			joueurs[i]=new Joueur();
		}
		centre=new ArrayList<Tuile>();
		defausse=new ArrayList<Tuile>();
		sac=new ArrayList<Tuile>();
		if(n==2) fabriques=new Fabrique[5];
		else if(n==3) fabriques=new Fabrique[7];
		else if(n==4) fabriques=new Fabrique[9];
		else fabriques=new Fabrique[5];  // a gere dans exception
		for(int i=0;i<fabriques.length;i++){
			fabriques[i]=new Fabrique();
		}
		for (int i=0;i<20;i++){
			sac.add(new Tuile("bleu"));
		}
		for(int i=0;i<40;i++){
			sac.add(new Tuile("orange"));
		}
		for(int i=0;i<60;i++){
			sac.add(new Tuile("rouge"));
		}
		for (int i=0;i<80;i++){
			sac.add(new Tuile("noir"));
		}
		for(int i=0;i<100;i++){
			sac.add(new Tuile("blanc"));
		}

	}
	public Joueur getJoueur(int i){
		return joueurs[i];
	}
	public Joueur[] getJoueur(){
		return joueurs;
	}
	public Fabrique[] getFabrique(){
		return fabriques;
	}
	public ArrayList<Tuile> getCentre(){
		return centre;
	}
	public void setCentre(ArrayList<Tuile> c){
		centre=c;
	}
	public ArrayList<Tuile> getSac(){
		return sac;
	}
	public void setSac(ArrayList<Tuile> c){
		sac=c;
	}
	public ArrayList<Tuile> getDefausse(){
		return defausse;
	}
	public void setDefausse(ArrayList<Tuile> c){
		defausse=c;
	}

	public void partie(){
		while(isFullLine()){
			preparation();
			offre();
			decoration();
		}
		fin();
	}

	public boolean isFullLine(){
		for(int i=0;i<joueurs.length;i++){
			if(joueurs[i].isFullLine()) return true;
		}
		return false;
	}

	public void preparation(){
		centre.add(new Tuile("vert"));  // vert=tuile -1
		for(int j=0;j<fabriques.length;j++){
			fabriques[j].remplirFabrique(sac);
			//System.out.println(fabrique[i]);
			
		}
	}
	
	public void offre(){
		while(isTuileInGame()){
			for(int i=0; i<joueurs.length;i++){
				for(int k=0;k<fabriques.length;k++){
					System.out.println("fabrique "+k+": "+fabriques[k].getTas());
				}
				afficherCentre();

				Scanner sc=new Scanner(System.in);
				System.out.println("indiquez le numero de la fabrique pour prendre une ou des tuiles :");
				int fab=sc.nextInt();
				Scanner sc2=new Scanner(System.in);
				System.out.println("indiquez la couleur de la tuile que vous voulez :");
				String tui=sc2.next();

				ArrayList<Tuile> t=fabriques[fab].take(tui,centre);
				System.out.println("ok");

				System.out.println("mur"+joueurs[i].getMur());
				System.out.println("ligne"+joueurs[i].getLigne());
				System.out.println("plancher"+joueurs[i].getPlancher());

				Scanner sc3=new Scanner(System.in);
				System.out.println("indiquez la ligne ou vous souhaitez posez vos tuiles :");
				int lig=sc3.nextInt();

				joueurs[i].getLigne().add(t,lig);

				System.out.println("mur"+joueurs[i].getMur());
				System.out.println("ligne"+joueurs[i].getLigne());
				System.out.println("plancher"+joueurs[i].getPlancher());



			}
		}
	}
	public void decoration(){

	}
	public void fin(){
		Joueur j=joueurs[0];
		for(int i=0;i<joueurs.length;i++){
			System.out.println(joueurs[i].getNom()+" : "+joueurs[i].getScore());
			if(j.getScore()<joueurs[i].getScore()) j=joueurs[i];
		}
		System.out.println(j.getNom()+"a gagné avec un score de "+ j.getScore());
	}
	public boolean isSacEmpty(){
		if(this.sac.size()==0){
			return true; //il faut donc remplir le sac grace a la defausse 
		}else{
			return false;
		}
	}

	public boolean isTuileInGame(){
		boolean b=true;
		boolean t=true;
		for(int i=0;i<fabriques.length;i++){
			if(fabriques[i].getTas().length==0){
				b=false;
			}else{
				b=true;
			}
			if (isSacEmpty()){
				t=false;
			}else{
				t=true;
			}
		}
		if(b==t && b==false){
			return false;
		}else{
			return true;
		}
		
	}
	public String afficherCentre(){
		String st="centre:";
		for (int i=0;i<centre.size() ; i++) {
			st+=centre.get(i).toString();
			if(i%3==0){
				st+="\n";
			}
			
		}
		return st;
	}


}
