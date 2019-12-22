public class Case{
	private boolean tuileDessus;
	private Tuile tuile;

	public Case(){
		tuileDessus=false;
	    tuile=null;
	}

	public boolean getTuileDessus(){
	  	return tuileDessus;
	}
	public void setTuileDessus(boolean b){
	  	tuileDessus=b;
	}
	public Tuile getTuile(){
	  	return tuile;
	}
	public void setCouleur(Tuile t){
	  	tuile=t;
	}

}


