// SUbklassen gjenfanget harer
public class JHarer  implements Comparable<JHarer> {
	private String identitet;
	private Dyr dyr;
	private String Kjønn;
	private int lengde;
	private int vekt;
	private String type;
	private String farge;
	private int tid;
	private String sted;
	// Konstruktør
	public JHarer(String identitet, Dyr dyr, String Kjønn, int lengde, int vekt, String farge, String type, int tid,
			String sted) {
		this.identitet = identitet;
		this.dyr = dyr;
		this.Kjønn = Kjønn;
		this.lengde = lengde;
		this.vekt = vekt;
		this.type = type;
		this.farge = farge;
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

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getSted() {
		return sted;
	}
	//Metode for å  Sammenligne
	@Override
	public int compareTo(JHarer detandre) {
		return this.identitet.compareTo(detandre.getIdentitet());
	}
	//Metode for å aktivere toString
	@Override
	public String toString() {
		return "identitet=" + identitet + ", Kjønn=" + Kjønn + ", lengde=" + lengde + ", vekt=" + vekt + "type=" + type + ", farge=" + farge
				+ ", tid=" + tid + ", Sted=" + sted;
	}

}

