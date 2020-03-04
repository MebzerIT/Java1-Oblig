
public class Gauper extends Dyr implements Comparable<Dyr> {
    	 
   // private String identitet;
	private int  øretusteneLengde; 
	
	//Konstruktør
	public Gauper (String identitet,String Kjønn, int lengde, int vekt, int øretusteneLengde, String tid, String sted) {
		super(identitet,Kjønn, lengde,vekt,tid,sted);
	  this.øretusteneLengde = øretusteneLengde;
	
       }
	//Gettere og settere
    public int getØretusteneLengde() {
    	return øretusteneLengde;
    }
    public void setØretusteneLengde(int øretusteneLengde) {
    	this.øretusteneLengde = øretusteneLengde;
    }
   
    @Override
    public String toFile() {
		return  super.toFile() +  "," + øretusteneLengde;  
	}
	public String toString() {
		return super.toString() + ", øretusteneLengde=" + øretusteneLengde;
	}

	
	
    
}


