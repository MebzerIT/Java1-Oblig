// Superklassen gjenfanget
public abstract class GjenFanget implements Comparable<GjenFanget> {
	private String identitet;
	private Dyr Kjønn;
	private int lengde;
	private int vekt;
	private int tid;
	private String sted;
	// Konstruktør
	public GjenFanget(String identitet, Dyr Kjønn, int lengde, int vekt, int tid, String sted) {
		this.identitet = identitet;
		this.Kjønn = Kjønn;
		this.lengde = lengde;
		this.vekt = vekt;
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

	public Dyr getKjønn() {
		return Kjønn;
	}

	public void setKjønn(Dyr Kjønn) {
		this.Kjønn = Kjønn;
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

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}
	//Sammenligning metode
	@Override
	public int compareTo(GjenFanget detandre) {
		return this.identitet.compareTo(detandre.getIdentitet());
	}
	// Metode som aktiverer toString
	@Override
	public String toString() {
		return "identitet=" + identitet + ", lengde=" + lengde + ", vekt=" + vekt + ", tid=" + tid + ", Sted=" + sted
				+ "," + Kjønn.toString();
	}

}
