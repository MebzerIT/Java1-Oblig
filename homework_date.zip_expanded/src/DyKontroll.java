import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DyKontroll {
	private ArrayList<JGauper> jgauper = new ArrayList<>();
	private ArrayList<JHarer> jharer = new ArrayList<>();
	private ArrayList<Dyr> dyr = new ArrayList<>();
	private final String FILNAVN = "dyr.txt";
	static int nesteledig = 1;
	static int nestNumber = 1;
	// Metode for � registrere ny gauper
	public void nyGauper(String Kj�nn, int lengde, int vekt, int �retusteneLengde, String tid, String sted) {
		int ID = nesteledig;
		String identitet = "G" + ID;
		dyr.add(new Gauper(identitet, Kj�nn, lengde, vekt, �retusteneLengde, tid, sted));
	}
	// Metode for � registrere ny harer
	public void nyHarer(String Kj�nn, int lengde, int vekt, String type, String farge, String tid, String sted) {
		int Id = nestNumber;
		String identitet = "H" + Id;
		dyr.add(new Harer(identitet, Kj�nn, lengde, vekt, type, farge, tid, sted));
	}

	public ArrayList<Dyr> getDyr() {
		return dyr;
	}

	public void t�m() {
		dyr.clear();
	}
	//Metode for � registrere gjenfangste gauper
	public void nyJGauper(String identitet, int lengde, int vekt, int �retusteneLengde, int tid, String sted) {
		Dyr dyr = finnIdentitet(identitet);
		jgauper.add(new JGauper(identitet, dyr, dyr.getKj�nn(), lengde, vekt, �retusteneLengde, tid, sted));
	}
	// Loop for � finne referanse
	public Dyr finnIdentitet(String identitet) {
		Collections.sort(dyr);
		for (int i = 0; i < dyr.size(); i++) {
			Dyr Skj� = dyr.get(i);
			if (Skj�.getIdentitet().equals(identitet))
				return Skj�;
		}
		return null;
	}

	public ArrayList<JGauper> getJGauper() {
		return jgauper;
	}
	// Metode for � registrere gjenfangste harer
	public void nyJHarer(String identitet, int lengde, int vekt, String farge, int tid, String sted) {
		Harer dyr = (Harer) finnIdentitet(identitet);
		jharer.add(new JHarer(identitet, dyr, dyr.getKj�nn(), lengde, vekt, farge, dyr.getType(), tid, sted));
	}

	public ArrayList<JHarer> getJHarer() {
		return jharer;
	}

	// Skriveforbindelse for � skrive fil til txt
	public PrintWriter lagSkrivefil(String FILNAVN) {
		PrintWriter skriver = null;
		try {
			FileWriter forbindelse = new FileWriter(FILNAVN, false);
			BufferedWriter skriverBuffer = new BufferedWriter(forbindelse);
			skriver = new PrintWriter(skriverBuffer);

		} catch (Exception e) {
		}
		return skriver;
	}

	// Leseforbindelse fra txt fil
	public BufferedReader lagLesefil(String filnavn) {
		BufferedReader innfil = null;
		try {
			FileReader forbindelse = new FileReader(filnavn);
			innfil = new BufferedReader(forbindelse);
		} catch (Exception e) {
		}
		return innfil;
	}

	// Gauper
	public void skrivData() {
		try {
			PrintWriter utfil = lagSkrivefil(FILNAVN);
			for (Dyr d : dyr) {
				utfil.println(d.toFile());

			}
			utfil.close();
		} catch (Exception e) {
		}
	}

	public void lese() {
		dyr.clear();
		try {
			BufferedReader innfil = lagLesefil(FILNAVN);
			String linje = innfil.readLine();
			int ng = 0;
			int nh = 0;
			while (linje != null) {
				StringTokenizer innhold = new StringTokenizer(linje, ",");
				String identitet = innhold.nextToken();
				String ID = Character.toString(identitet.charAt(0));
				if (ID.equals("G")) {
					String Kj�nn = innhold.nextToken();
					int lengde = Integer.parseInt(innhold.nextToken());
					int vekt = Integer.parseInt(innhold.nextToken());
					String tid = innhold.nextToken();
					String sted = innhold.nextToken();
					int �retusteneLengde = Integer.parseInt(innhold.nextToken());
					ng = Integer.parseInt(Character.toString(identitet.charAt(1)));
					dyr.add(new Gauper(identitet, Kj�nn, lengde, vekt, �retusteneLengde, tid, sted));
				}
				if (ID.equals("H")) {
					String Kj�nn = innhold.nextToken();
					int lengde = Integer.parseInt(innhold.nextToken());
					int vekt = Integer.parseInt(innhold.nextToken());
					String tid = innhold.nextToken();
					String sted = innhold.nextToken();
					String type = innhold.nextToken();
					String farge = innhold.nextToken();
					nh = Integer.parseInt(Character.toString(identitet.charAt(1)));
					dyr.add(new Harer(identitet, Kj�nn, lengde, vekt, type, farge, tid, sted));
				}
				linje = innfil.readLine();
			} // l�kke
			innfil.close();
			nesteledig = ++ng;
			nestNumber = ++nh;
		} catch (Exception e) {
		}
	}
	// Metode for � s�ke gjennom arraylist
	public ArrayList<String> S�k(String identitet) {
		ArrayList<String> l = new ArrayList<>(); 
		for (Dyr d : dyr) {
			if (d.getIdentitet().equals(identitet)) {
				l.add(d.toString() + '\n');
				break;
			}
		}
		for (JGauper d : jgauper) {
			if (d.getIdentitet().equals(identitet)) {
				l.add(d.toString() + '\n');
			}
		}
		for (JHarer d : jharer) {
			if (d.getIdentitet().equals(identitet)) {
				l.add(d.toString() + '\n');
			}
		}
		return l;
	}
	// Metode for � vise oversikten
	public String[] DyrRaport() {
		String[] l = new String[dyr.size()];
		for (int i = 0; i < dyr.size(); i++) {
			Dyr d = dyr.get(i);
			l[i] = d.toString();
		}
		return l;
	}


}
