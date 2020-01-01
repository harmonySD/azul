package datamodel;

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
	public void setTuile(Tuile t){
	  	tuile=t;
	}
	public String toString(){
      	String s="";
    		
    	if (this.tuileDessus==false){
    		s+="* ";
    	}
    	else{
    		s+=tuile.toString();    					
    	}
    	
    	return s;
	}


}


