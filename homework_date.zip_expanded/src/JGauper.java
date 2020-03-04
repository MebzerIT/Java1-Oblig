// Subklassen gjenfanget gauper
public class JGauper implements Comparable<JGauper> {
	private String identitet;
	private Dyr dyr;
	private String Kjønn;
	private int lengde;
	private int vekt;
	private int øretusteneLengde;
	private int tid;
	private String sted;
	//Konstruktør
	public JGauper(String identitet, Dyr dyr, String Kjønn, int lengde, int vekt, int øretusteneLengde, int tid,
			String sted) {
		this.identitet = identitet;
		this.Kjønn = Kjønn;
		this.dyr = dyr;
		this.lengde = lengde;
		this.vekt = vekt;
		this.øretusteneLengde = øretusteneLengde;
		this.tid = tid;
		this.sted = sted;
	}
	// Gettere og settere
	public String getIdentitet() {
		return identitet;
	}

	public void setIdentitet(String identietet) {
		this.identitet = identietet;
	}

	public Dyr getDyr() {
		return dyr;
	}

	public void setDyr(Dyr dyr) {
		this.dyr = dyr;
	}

	public String getKjønn() {
		return Kjønn;
	}

	public void setKjønn(String Kjønn) {
		Kjønn = Kjønn;
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public int getLengde() {
		return lengde;
	}

	public void setLengde(int lengde) {
		this.lengde = lengde;
	}

	public int getVekt() {
		return vekt;
	}

	public void setVekt(int vekt) {
		this.vekt = vekt;
	}

	public int getØretusteneLengde() {
		return øretusteneLengde;
	}

	public void setØretusteneLengde(int øretusteneLengde) {
		this.øretusteneLengde = øretusteneLengde;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	// Metoden for å sammenligne
	@Override
	public int compareTo(JGauper detandre) {
		return this.identitet.compareTo(detandre.getIdentitet());
	}
	//Metode for å aktiverer toString
	@Override
	public String toString() {
		return "identitet=" + identitet + ", Kjønn=" + Kjønn + ", lengde=" + lengde + ", vekt=" + vekt + ", øretusteneLengde="
				+ øretusteneLengde + ", tid=" + tid + ", Sted=" + sted;
	}
	

}
