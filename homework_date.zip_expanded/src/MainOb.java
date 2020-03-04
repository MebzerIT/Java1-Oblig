import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
//Hoved vindu
public class MainOb {

	public static void main(String[] args) {
		MainOb MainOb = new MainOb();
		MainOb.meny();
	}

	DyKontroll kontroll = new DyKontroll();
	private final int RegDyr = 0;
	private final int GjenF = 1;
	private final int S�k = 2;
	private final int AlleD = 3;
	private final int AVSLUTT = 4;
	private final String[] ALTERNATIVER = { "RegNyDyr", "RegGjenfanget", "S�kDyr", "AlleDyr", "Avslutt" };

	public void meny() {
		boolean fortsett = true;
		kontroll.lese();
		while (fortsett) {
			int valg = JOptionPane.showOptionDialog(null, "Gj�r et valg:", // Ledetekst over knappene
					"OmDyrmeny", // navn p� vinduet1
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ALTERNATIVER, // ARRAYEN MED
																								// alternativer
					ALTERNATIVER[0]); // Default alternativ
			switch (valg) {
			case RegDyr:
				RgeNyDyr(); // Kaller en RegNy dyr class
				break;
			case GjenF:
				RegGjenfanget();// Kaller en gjenfangste dyr class
				break;
			case S�k:
				S�kDyr(); // Kaller en s�ke funksjon
				break;
			case AlleD:
				DyrRaport();// Kaller en rapport funkson
				break;
			default:
				fortsett = false;
			}
		}
	}
	// Register ny dyr vinduet
	public void RgeNyDyr() {
		int GauHar = Integer.parseInt(JOptionPane.showInputDialog("Er det Gauper tast 1. Er det Harer tast 2 :"));
		switch (GauHar) {
		case 1:
			RegGauper();
			break;
		case 2:
			RegHarer();
			break;
		default:
			JOptionPane.showMessageDialog(null,"Feil inndata: ");
		}
	}
	// Register ny gauper
	public void RegGauper() {
		String Kj�nn = JOptionPane.showInputDialog("Skriv Kj�nn:");
		int lengde = Integer.parseInt(JOptionPane.showInputDialog("Skriv lengde [kun tall]:"));
		int vekt = Integer.parseInt(JOptionPane.showInputDialog("Skriv vekt [kun tall]:"));
		int �retusteneLengde = Integer.parseInt(JOptionPane.showInputDialog("Skriv �retusteneLengde [kun tall]:"));
		String tid = JOptionPane.showInputDialog("Skriv tid (dd/mm/yy hh:mm):");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy hh:mm");
		Date date = null;
		try {
			date = dateFormat.parse(tid);
		} catch (ParseException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Wrong DateTime format", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String sted = JOptionPane.showInputDialog("Skriv sted:");
		kontroll.nyGauper(Kj�nn, lengde, vekt, �retusteneLengde, tid, sted);
		ArrayList<Dyr> dyr = kontroll.getDyr();
		for (Dyr d : dyr) {
			System.out.println(d.toString());
		}
		System.out.println();
		System.out.println("Skriver til fil");
		kontroll.skrivData();
		System.out.println();
		System.out.println("T�mmer arraylisten");
		// kontroll.t�m();
		System.out.println();
		dyr = kontroll.getDyr();
		for (Dyr d : dyr) {
			System.out.println(d.toString());
		}
		System.out.println("N� skulle det v�re tomt");
		System.out.println();
		System.out.println("Leser fra fil og skriver ut");
		kontroll.lese();
		dyr = kontroll.getDyr();
		for (Dyr d : dyr) {
			System.out.println(d.toString());
		}
	}
	// Register ny harer
	public void RegHarer() {
		String Kj�nn = JOptionPane.showInputDialog("Skriv Kj�nn:");
		int lengde = Integer.parseInt(JOptionPane.showInputDialog("Skriv lengde [kun tall]:"));
		int vekt = Integer.parseInt(JOptionPane.showInputDialog("Skriv vekt [kun tall]:"));
		String type = JOptionPane.showInputDialog("Skriv V for  Vanlig eller S for S�r :");
		String farge = JOptionPane.showInputDialog("Skriv farge :");
		String tid = JOptionPane.showInputDialog("Skriv tid (dd/mm/yy hh:mm):");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy hh:mm");
		Date date = null;
		try {
			date = dateFormat.parse(tid);
		} catch (ParseException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Feil dato formater", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sted = JOptionPane.showInputDialog("Skriv sted:");
		kontroll.nyHarer(Kj�nn, lengde, vekt, type, farge, tid, sted);
		ArrayList<Dyr> Hdyr = kontroll.getDyr();
		for (Dyr d : Hdyr) {
			System.out.println(d.toString());
		}
		System.out.println();
		System.out.println("Skriver til fil");
		kontroll.skrivData();
		System.out.println();
		System.out.println("T�mmer arraylisten");
		// kontroll.t�m();
		System.out.println();
		Hdyr = kontroll.getDyr();
		for (Dyr d : Hdyr) {
			System.out.println(d.toString());
		}
		System.out.println("N� skulle det v�re tomt");
		System.out.println();
		System.out.println("Leser fra fil og skriver ut");
		kontroll.lese();
		Hdyr = kontroll.getDyr();
		for (Dyr d : Hdyr) {
			System.out.println(d.toString());
		}
	}
	// Register gjenfangste dyr
	public void RegGjenfanget() {
		String identitet = JOptionPane.showInputDialog("Angi gjenfanget Identitet: ");
		String ID = Character.toString(identitet.charAt(0));
		if (ID.equals("G")) {
			int lengde = Integer.parseInt(JOptionPane.showInputDialog("Skriv lengde [kun tall]:"));
			int vekt = Integer.parseInt(JOptionPane.showInputDialog("Skriv vekt [kun tall]:"));
			int �retusteneLengde = Integer.parseInt(JOptionPane.showInputDialog("Skriv �retusteneLengde [kun tall]:"));
			int tid = Integer.parseInt(JOptionPane.showInputDialog("Skriv tid [kun tall]:"));
			String sted = JOptionPane.showInputDialog("Skriv sted:");
			kontroll.nyJGauper(identitet, lengde, vekt, �retusteneLengde, tid, sted);
			ArrayList<JGauper> jgauper = kontroll.getJGauper();
			for (JGauper jg : jgauper) {
				System.out.println(jg.toString());
			}
		} else if (ID.equals("H")) {
			int lengde = Integer.parseInt(JOptionPane.showInputDialog("Skriv lengde [kun tall]:"));
			int vekt = Integer.parseInt(JOptionPane.showInputDialog("Skriv vekt [kun tall]:"));
			String farge = JOptionPane.showInputDialog("Skriv farge :");
			int tid = Integer.parseInt(JOptionPane.showInputDialog("Skriv tid [kun tall]:"));
			String sted = JOptionPane.showInputDialog("Skriv sted:");
			kontroll.nyJHarer(identitet, lengde, vekt, farge, tid, sted);
			ArrayList<JHarer> jharer = kontroll.getJHarer();
			for (JHarer jg : jharer) {
				System.out.println(jg.toString());
			}
		}
	}
	// S�ke funksjon
	public void S�kDyr() {
		kontroll.lese();
		String identitet = JOptionPane.showInputDialog("Angi gjenfanget Identitet e.g G1, H2: ");
		ArrayList<String> l = kontroll.S�k(identitet);
		JOptionPane.showMessageDialog(null, l, "Report", JOptionPane.INFORMATION_MESSAGE);
	}
	// Oversikt over alle registerte dyr
	public void DyrRaport() {
		kontroll.lese();
		String[] l = kontroll.DyrRaport();
		JOptionPane.showMessageDialog(null, l, "Report", JOptionPane.INFORMATION_MESSAGE);
	}
}
