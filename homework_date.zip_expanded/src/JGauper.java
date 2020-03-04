// Subklassen gjenfanget gauper
public class JGauper implements Comparable<JGauper> {
	private String identitet;
	private Dyr dyr;
	private String Kj�nn;
	private int lengde;
	private int vekt;
	private int �retusteneLengde;
	private int tid;
	private String sted;
	//Konstrukt�r
	public JGauper(String identitet, Dyr dyr, String Kj�nn, int lengde, int vekt, int �retusteneLengde, int tid,
			String sted) {
		this.identitet = identitet;
		this.Kj�nn = Kj�nn;
		this.dyr = dyr;
		this.lengde = lengde;
		this.vekt = vekt;
		this.�retusteneLengde = �retusteneLengde;
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

	public String getKj�nn() {
		return Kj�nn;
	}

	public void setKj�nn(String Kj�nn) {
		Kj�nn = Kj�nn;
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

	public int get�retusteneLengde() {
		return �retusteneLengde;
	}

	public void set�retusteneLengde(int �retusteneLengde) {
		this.�retusteneLengde = �retusteneLengde;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	// Metoden for � sammenligne
	@Override
	public int compareTo(JGauper detandre) {
		return this.identitet.compareTo(detandre.getIdentitet());
	}
	//Metode for � aktiverer toString
	@Override
	public String toString() {
		return "identitet=" + identitet + ", Kj�nn=" + Kj�nn + ", lengde=" + lengde + ", vekt=" + vekt + ", �retusteneLengde="
				+ �retusteneLengde + ", tid=" + tid + ", Sted=" + sted;
	}
	

}
