public class Fabrique{
	private Tuile [] tas;
	private final int nbTuile=4;

	public Fabrique(){
		tas=new Tuile[nbTuile];
	}

	public Tuile[] getTas(){
  		return tas;
  	}
  	public void setTas(Tuile[] t){
  		tas=t;
  	}
  	public int getNbTuile(){
  		return nbTuile;
  	}

}
