

import java.util.*;


public class VueTerminale implements VueGeneral{
	private Jeu jeu;

	public VueTerminale(int n){
		jeu=new Jeu(n);
	}

	public void partie(){
		jeu.partie();
	}
	public void offre(){

	}
	public void decoration(){

	}
	public void fin(){

	}


}