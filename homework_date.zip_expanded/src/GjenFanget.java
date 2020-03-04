// Superklassen gjenfanget
public abstract class GjenFanget implements Comparable<GjenFanget> {
	private String identitet;
	private Dyr Kj�nn;
	private int lengde;
	private int vekt;
	private int tid;
	private String sted;
	// Konstrukt�r
	public GjenFanget(String identitet, Dyr Kj�nn, int lengde, int vekt, int tid, String sted) {
		this.identitet = identitet;
		this.Kj�nn = Kj�nn;
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

	public Dyr getKj�nn() {
		return Kj�nn;
	}

	public void setKj�nn(Dyr Kj�nn) {
		this.Kj�nn = Kj�nn;
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
				+ "," + Kj�nn.toString();
	}

}
