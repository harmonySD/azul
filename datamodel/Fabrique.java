import java.util.*;

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

  public void remplirFabrique(ArrayList<Tuile> sac){
    for (int i=0; i<4;i++){
      Random r= new Random();
      int a =r.nextInt(sac.size());
      if(sac[a]!=null){
        tas[i]=sac[a];
        sac[a]=null;
      }
      
    }
    




}
