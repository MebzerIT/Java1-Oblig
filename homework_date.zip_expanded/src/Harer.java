// subklasse harer
public class Harer extends Dyr implements Comparable<Dyr> {

	private String  type; 
	private String farge;
	
	//Konstruktør
	
	public Harer (String identitet,String Kjønn, int lengde, int vekt, String type, String farge, String tid, String sted) {
		super(identitet,Kjønn, lengde,vekt,tid,sted);
	  this.type = type;
	  this.farge = farge;
       }
	// Gettere og settere
    public String getType() {
    	return type;
    }
    public void setType(String type) {
    	this.type = type;
    }
    public String getFarge() {
    	return farge;
    }
    public void setFarge(String farge) {
    	this.farge = farge;
    }
    
   
    
    @Override
    public String toFile() {
    	return super.toFile() +  "," + type +  "," + farge ;
	}
    // Metode som aktiverer toString til type og farge
	public String toString() {
		return super.toString() + "type=" + type +  ", farge=" + farge ;
	}
	//Metode for å  Sammenligne
	@Override
	public int compareTo(Dyr detandre) {
		return this.getIdentitet().compareTo(detandre.getIdentitet());
	}
}


	
    



