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
	// Metode for å registrere ny gauper
	public void nyGauper(String Kjønn, int lengde, int vekt, int øretusteneLengde, String tid, String sted) {
		int ID = nesteledig;
		String identitet = "G" + ID;
		dyr.add(new Gauper(identitet, Kjønn, lengde, vekt, øretusteneLengde, tid, sted));
	}
	// Metode for å registrere ny harer
	public void nyHarer(String Kjønn, int lengde, int vekt, String type, String farge, String tid, String sted) {
		int Id = nestNumber;
		String identitet = "H" + Id;
		dyr.add(new Harer(identitet, Kjønn, lengde, vekt, type, farge, tid, sted));
	}

	public ArrayList<Dyr> getDyr() {
		return dyr;
	}

	public void tøm() {
		dyr.clear();
	}
	//Metode for å registrere gjenfangste gauper
	public void nyJGauper(String identitet, int lengde, int vekt, int øretusteneLengde, int tid, String sted) {
		Dyr dyr = finnIdentitet(identitet);
		jgauper.add(new JGauper(identitet, dyr, dyr.getKjønn(), lengde, vekt, øretusteneLengde, tid, sted));
	}
	// Loop for å finne referanse
	public Dyr finnIdentitet(String identitet) {
		Collections.sort(dyr);
		for (int i = 0; i < dyr.size(); i++) {
			Dyr Skjø = dyr.get(i);
			if (Skjø.getIdentitet().equals(identitet))
				return Skjø;
		}
		return null;
	}

	public ArrayList<JGauper> getJGauper() {
		return jgauper;
	}
	// Metode for å registrere gjenfangste harer
	public void nyJHarer(String identitet, int lengde, int vekt, String farge, int tid, String sted) {
		Harer dyr = (Harer) finnIdentitet(identitet);
		jharer.add(new JHarer(identitet, dyr, dyr.getKjønn(), lengde, vekt, farge, dyr.getType(), tid, sted));
	}

	public ArrayList<JHarer> getJHarer() {
		return jharer;
	}

	// Skriveforbindelse for å skrive fil til txt
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
					String Kjønn = innhold.nextToken();
					int lengde = Integer.parseInt(innhold.nextToken());
					int vekt = Integer.parseInt(innhold.nextToken());
					String tid = innhold.nextToken();
					String sted = innhold.nextToken();
					int øretusteneLengde = Integer.parseInt(innhold.nextToken());
					ng = Integer.parseInt(Character.toString(identitet.charAt(1)));
					dyr.add(new Gauper(identitet, Kjønn, lengde, vekt, øretusteneLengde, tid, sted));
				}
				if (ID.equals("H")) {
					String Kjønn = innhold.nextToken();
					int lengde = Integer.parseInt(innhold.nextToken());
					int vekt = Integer.parseInt(innhold.nextToken());
					String tid = innhold.nextToken();
					String sted = innhold.nextToken();
					String type = innhold.nextToken();
					String farge = innhold.nextToken();
					nh = Integer.parseInt(Character.toString(identitet.charAt(1)));
					dyr.add(new Harer(identitet, Kjønn, lengde, vekt, type, farge, tid, sted));
				}
				linje = innfil.readLine();
			} // løkke
			innfil.close();
			nesteledig = ++ng;
			nestNumber = ++nh;
		} catch (Exception e) {
		}
	}
	// Metode for å søke gjennom arraylist
	public ArrayList<String> Søk(String identitet) {
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
	// Metode for å vise oversikten
	public String[] DyrRaport() {
		String[] l = new String[dyr.size()];
		for (int i = 0; i < dyr.size(); i++) {
			Dyr d = dyr.get(i);
			l[i] = d.toString();
		}
		return l;
	}


}
