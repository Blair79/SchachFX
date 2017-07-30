package schachFX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Spiel {
	private Schachbrett_controller schachbrett_controller;
	private BitBoard bitboard = new BitBoard();

	public Spiel(Schachbrett_controller schachbrett_controller) {
		this.schachbrett_controller = schachbrett_controller;
	}

	public void notiere(int quelle, int ziel) {
		// TODO Speichern der Notation
		// System.out.println(quelle+","+ziel);
	}

	/*
	 * public void ziehe(String quelle, String ziel) {
	 * schachbrett_controller.ziehe(quelle, ziel); }
	 */

	public boolean istZugerlaubt(String figur, String zielfarbe, int quelle, int ziel) {

		System.out.println(figur + " " + quelle + " " + ziel + " " + zielfarbe);

		boolean grundlinie = false;
		boolean erlaubt = false;

		int differenz = Math.abs(ziel - quelle);

		String figurname = figur.substring(0, figur.indexOf('_'));
		boolean figurfarbe = figur.contains("_w");

		switch (figurname) {
		case "Bauer":
			System.out.println("Bauer " + Arrays.toString(bitboard.berechneBauer(quelle, figurfarbe)));
			bitboard.ausgeben(figurname, figurfarbe);

			if (quelle > 30 && quelle < 39)
				grundlinie = true;
			else if (quelle > 80 && quelle < 89)
				grundlinie = true;

			if (figurfarbe) {
				if ((ziel == quelle + 9) && (zielfarbe.contains("_s")))
					erlaubt = true;
				if ((ziel == quelle + 10) && (zielfarbe == ""))
					erlaubt = true;
				if ((ziel == quelle + 11) && (zielfarbe.contains("_s")))
					erlaubt = true;
			} else {
				if ((ziel == quelle - 9) && (zielfarbe.contains("_w")))
					erlaubt = true;
				if ((ziel == quelle - 10) && (zielfarbe == ""))
					erlaubt = true;
				if ((ziel == quelle - 11) && (zielfarbe.contains("_w")))
					erlaubt = true;
			}

			// 2Felder mehr von der Grundlinie
			if (grundlinie && differenz == 20)
				erlaubt = true;

			break;
		case "Turm":
			System.out.println("Turm " + Arrays.toString(bitboard.berechneGerade(quelle)));
			bitboard.ausgeben(figurname, figurfarbe);
			if (differenz % 10 == 0)
				erlaubt = true;
			if (Math.abs(ziel / 10 - quelle / 10) < 1)
				erlaubt = true;
			break;
		case "Springer":
			System.out.println("Springer " + Arrays.toString(bitboard.berechneSpringer(quelle)));
			bitboard.ausgeben(figurname, figurfarbe);

			/*
			 * if (ziel == quelle + 21) erlaubt = true; if (ziel == quelle + 19) erlaubt =
			 * true; if (ziel == quelle + 8) erlaubt = true; if (ziel == quelle + 12)
			 * erlaubt = true; if (ziel == quelle - 21) erlaubt = true; if (ziel == quelle -
			 * 19) erlaubt = true; if (ziel == quelle - 8) erlaubt = true; if (ziel ==
			 * quelle - 12) erlaubt = true;
			 */

			break;
		case "Laeufer":
			System.out.println("Laeufer " + Arrays.toString(bitboard.berechneDiagonale(quelle)));
			bitboard.ausgeben(figurname, figurfarbe);
			if (differenz % 9 == 0)
				erlaubt = true;
			if (differenz % 11 == 0)
				erlaubt = true;
			break;
		case "Dame":
			bitboard.berechneDame(quelle);
			bitboard.ausgeben(figurname, figurfarbe);
			if (differenz % 10 == 0)
				erlaubt = true;
			if (Math.abs(ziel / 10 - quelle / 10) < 1)
				erlaubt = true;
			if (differenz % 9 == 0)
				erlaubt = true;
			if (differenz % 11 == 0)
				erlaubt = true;
			break;
		case "Koenig":
			System.out.println("Koenig " + Arrays.toString(bitboard.berechneKoenig(quelle)));
			bitboard.ausgeben(figurname, figurfarbe);
			if (quelle + 10 == ziel)
				erlaubt = true;
			if (quelle - 10 == ziel)
				erlaubt = true;
			if (quelle + 1 == ziel)
				erlaubt = true;
			if (quelle - 1 == ziel)
				erlaubt = true;
			if (quelle + 9 == ziel)
				erlaubt = true;
			if (quelle - 9 == ziel)
				erlaubt = true;
			if (quelle + 11 == ziel)
				erlaubt = true;
			if (quelle - 11 == ziel)
				erlaubt = true;
			break;

		}

		if (zielfarbe.contains("_w") && figur.contains("_w"))
			return false;
		if (zielfarbe.contains("_s") && figur.contains("_s"))
			return false;

		return erlaubt;

	}

}
