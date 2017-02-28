package schachFX;

public class Spiel {
	private Schachbrett_controller schachbrett_controller;

	public Spiel(Schachbrett_controller schachbrett_controller) {
		this.schachbrett_controller = schachbrett_controller;
	}

	public void notiere(String quelle, String ziel) {
		// TODO Speichern der Notation
		// System.out.println(quelle+","+ziel);
	}

	public void ziehe(String quelle, String ziel) {
		schachbrett_controller.ziehe(quelle, ziel);
	}

	public boolean istZugerlaubt(String figur, String quelle, String ziel) {

		System.out.println(figur + " " + quelle + " " + ziel);

		// true = rauf, false = runter
		boolean richtung;
		boolean erlaubt = false;

		if (figur.contains("_w"))
			richtung = true;
		else
			richtung = false;
		System.out.println(richtung);

		String ergebnis = "";
		char hilfsPosX = quelle.charAt(0);
		int hilfsPosY = quelle.charAt(1);
		// TODO Spielregeln
		switch (figur.substring(0, figur.indexOf('_'))) {
		case "Bauer":

			ergebnis = ergebnis + linksRauf(quelle, 1, richtung);
			ergebnis = ergebnis + (rauf(quelle, 1, richtung));
			if ((quelle.charAt(1) == '2') || (quelle.charAt(1) == '7'))
				ergebnis = ergebnis + (rauf(quelle, 2, richtung));
			ergebnis = ergebnis + rechtsRauf(hilfsPosX, hilfsPosY, 1, richtung);

			erlaubt = ergebnis.contains(ziel);

			 System.out.println(ergebnis);
			break;// 3 Richtungen 4 Felder
		case "Turm":
			if (quelle.charAt(1) < ziel.charAt(1)) {
				int anzahl = 1;
				for (int i = quelle.charAt(1); i < ziel.charAt(1); i++) {
					ergebnis = ergebnis + rauf(quelle, anzahl++, richtung);
				}
				anzahl = 1;
				for (int i = quelle.charAt(1); i < ziel.charAt(1); i++) {
					ergebnis = ergebnis + rauf(quelle, anzahl++, !richtung);
				}
			}
			if (quelle.charAt(1) > ziel.charAt(1)) {
				int anzahl = 1;
				for (int i = quelle.charAt(1); i > ziel.charAt(1); i--) {
					ergebnis = ergebnis + rauf(quelle, anzahl++, richtung);
				}
				anzahl = 1;
				for (int i = quelle.charAt(1); i > ziel.charAt(1); i--) {
					ergebnis = ergebnis + rauf(quelle, anzahl++, !richtung);
				}
			}

			erlaubt = ergebnis.contains(ziel);
			System.out.println(ergebnis);
			break;// 4 Richtungen
		case "Springer":
			System.out.println("Springer");
			break;// 8 Richtungen 8 Felder
		case "Lauefer":
			System.out.println("Lauefer");
			break;// 4 Richtungen um 45
		case "Dame":
			System.out.println("Dame");
			break;
		case "Koenig":
			System.out.println("Koenig");
			break;

		}

		return erlaubt;

	}

	private String rauf(String quelle, int anzahl, boolean richtung) {
		char hilfsPosX = quelle.charAt(0);
		int hilfsPosY = quelle.charAt(1);
		//int ausgangsstellung = 7;
		if (!richtung) {
			//ausgangsstellung = 2;
			anzahl *= -1;
		}

		String ergebnis = "";
		// Rauf
		//if (hilfsPosY != ausgangsstellung) {
			hilfsPosY += anzahl - 48;
				ergebnis = ergebnis + hilfsPosX + hilfsPosY;
		//}

		return ergebnis;

	}

	private String linksRauf(String quelle, int anzahl, boolean richtung) {
		char hilfsPosX = quelle.charAt(0);
		int hilfsPosY = quelle.charAt(1);
		int ausgangsstellung = 7;
		if (!richtung) {
			ausgangsstellung = 2;
			anzahl *= -1;
		}

		String ergebnis = "";
		// Links rauf
		if ((hilfsPosX != 'A')) {

			hilfsPosX -= (char) Math.abs(anzahl);//
			if (hilfsPosY != ausgangsstellung)
				hilfsPosY += anzahl - 48;
			ergebnis = ergebnis + hilfsPosX + hilfsPosY;

		}

		return ergebnis;

	}

	private String rechtsRauf(char hilfsPosX, int hilfsPosY, int anzahl, boolean richtung) {

		int ausgangsstellung = 7;
		if (!richtung) {
			ausgangsstellung = 2;
			anzahl *= -1;
		}

		String ergebnis = "";
		// Rechts rauf
		if ((hilfsPosX != 'H')) {
			hilfsPosX += (char) 1;//
			if (hilfsPosY != ausgangsstellung)
				hilfsPosY += anzahl - 48;
			ergebnis = ergebnis + hilfsPosX + hilfsPosY;
		}

		return ergebnis;

	}
}
