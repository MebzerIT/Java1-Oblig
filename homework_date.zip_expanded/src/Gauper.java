
public class Gauper extends Dyr implements Comparable<Dyr> {
    	 
   // private String identitet;
	private int  �retusteneLengde; 
	
	//Konstrukt�r
	public Gauper (String identitet,String Kj�nn, int lengde, int vekt, int �retusteneLengde, String tid, String sted) {
		super(identitet,Kj�nn, lengde,vekt,tid,sted);
	  this.�retusteneLengde = �retusteneLengde;
	
       }
	//Gettere og settere
    public int get�retusteneLengde() {
    	return �retusteneLengde;
    }
    public void set�retusteneLengde(int �retusteneLengde) {
    	this.�retusteneLengde = �retusteneLengde;
    }
   
    @Override
    public String toFile() {
		return  super.toFile() +  "," + �retusteneLengde;  
	}
	public String toString() {
		return super.toString() + ", �retusteneLengde=" + �retusteneLengde;
	}

	
	
    
}


