// Superklassen dyr som implementerer sammenligning
public abstract class Dyr implements Comparable<Dyr> {
	private String identitet;
	private String Kj�nn;
	private int lengde;
	private int vekt;
	private String tid;
	private String sted;
	// Konstrukt�r 
	public Dyr(String identitet, String Kj�nn, int lengde, int vekt, String tid, String sted) {
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

	public void setIdentitet(String identitet) {
		this.identitet = identitet;
	}

	public String getKj�nn() {
		return Kj�nn;
	}

	public void setKj�nn(String Kj�nn) {
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

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public int compareTo(Gauper detandre) {
		return this.identitet.compareTo(detandre.getIdentitet());
	}

	public int compareTo(Harer detandre) {
		return this.identitet.compareTo(detandre.getIdentitet());
	}

	public String toFile() {
		return (identitet + "," + Kj�nn + "," + lengde + "," + vekt + "," + tid + "," + sted);
	}

	@Override
	public String toString() {
		return "Dyr [Identitet=" + identitet + ", Kj�nn=" + Kj�nn + ", lengde=" + lengde + ", vekt=" + vekt + ", tid="
				+ tid + ", Sted=" + sted + "]";
	}
	// Sammenligning metode
	public int compareTo(Dyr detandre) {
		return this.identitet.compareTo(detandre.getIdentitet());
	}
}
