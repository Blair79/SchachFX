/**
 * 
 */
package schachFX;

import java.util.ArrayList;
import java.util.List;

/**
 * Class BitBoard
 * 
 * @author ColBlair
 * @version 1.0
 */
public class BitBoard {
	long Bauern = 	0b00000000_11111111_00000000_00000000_00000000_00000000_11111111_00000000L;
	long Springer = 0b01000010_00000000_00000000_00000000_00000000_00000000_00000000_01000010L;
	long Laeufer = 	0b00100100_00000000_00000000_00000000_00000000_00000000_00000000_00100100L;
	long Tuerme = 	0b10000001_00000000_00000000_00000000_00000000_00000000_00000000_10000001L;
	long Damen = 	0b00010000_00000000_00000000_00000000_00000000_00000000_00000000_00010000L;
	long Koenige = 	0b00001000_00000000_00000000_00000000_00000000_00000000_00000000_00001000L;

	long Weisse = 	0b00000000_00000000_00000000_00000000_00000000_00000000_11111111_11111111L;
	long Schwarze = 0b11111111_11111111_00000000_00000000_00000000_00000000_00000000_00000000L;

	long aLinie = 	0b01111111_01111111_01111111_01111111_01111111_01111111_01111111_01111111L;
	long hLinie = 	0b11111110_11111110_11111110_11111110_11111110_11111110_11111110_11111110L;
	
	long verLinie = ~hLinie;
	long horLinie = 0b00000000_00000000_00000000_00000000_00000000_00000000_00000000_11111111L;
	long einzelfig =0b00000000_00000000_00000000_00000000_00000000_00000000_00000000_00000001L;

	Long[] lookupTableTurm = new Long[64];

	public void initlookupTableRook() {
		Long[][] lookupHorTableTurm = new Long[8][8];
		Long[][] lookupVerTableTurm = new Long[8][8];

		// ungehindert horizontal
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				lookupHorTableTurm[i][j] = horLinie << i * 8;
			}
		}

		// ungehindert vertical
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				lookupVerTableTurm[j][i] = verLinie << i;
			}
		}
		
		// ungehindert hor mit ver verknüpft
		int count=0;
		lookupTableTurm = new Long[64];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				lookupTableTurm[count] = lookupHorTableTurm[i][j] | lookupVerTableTurm[i][j];
				count++;
			}
		}
		
		//anzeige
			for (int i = 0; i < 64; i++) {
				for (String part : getParts(
						String.format("%64s", Long.toBinaryString(lookupTableTurm[i])).replace(" ", "0"),
						8)) {
					System.out.println(part + " lookupTurm "+i);
				}
				System.out.println();
			}
		
	}

	/**
	 * @param figurname
	 * @param figurfarbe
	 */
	public void ausgeben(String figurname, boolean figurfarbe) {
		// TODO 20.01.2018 17:08:42 muss noch bearbeitet werden
		long WeisseBauern = Bauern & Weisse;
		long WeisseSpringer = Springer & Weisse;
		long WeisseLaeufer = Laeufer & Weisse;
		long WeisseTuerme = Tuerme & Weisse;
		long WeisseDamen = Damen & Weisse;
		long WeisseKoenige = Koenige & Weisse;

		long SchwarzeBauern = Bauern & Schwarze;
		long SchwarzeSpringer = Springer & Schwarze;
		long SchwarzeLaeufer = Laeufer & Schwarze;
		long SchwarzeTuerme = Tuerme & Schwarze;
		long SchwarzeDamen = Damen & Schwarze;
		long SchwarzeKoenige = Koenige & Schwarze;

		long WeisseBauernZüge = WeisseBauern << 8 & ~Weisse & ~Schwarze;
		long WeisseBauernSchlagZügelinks = WeisseBauern << 9 & hLinie & ~Weisse & Schwarze;
		long WeisseBauernSchlagZügerechts = WeisseBauern << 7 & aLinie & ~Weisse & Schwarze;

		long SchwarzeBauernZüge = SchwarzeBauern >> 8 & ~Weisse & ~Schwarze;
		long SchwarzeBauernSchlagZügelinks = SchwarzeBauern >> 7 & hLinie & Weisse & ~Schwarze;
		long SchwarzeBauernSchlagZügerechts = SchwarzeBauern >> 9 & aLinie & Weisse & ~Schwarze;

		initlookupTableRook();

		/*System.out.println(Long.toBinaryString(WeisseBauern)); // show full integer in binary
		for (int i = 63; i >= 0; i--) {
			long bit = (WeisseBauern >> i) & 1;
			System.out.println("Bit " + i + " : " + (bit == 1 ? "1" : "0"));
		}

		for (String part : getParts(String.format("%64s", Long.toBinaryString(WeisseBauern)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseBauern");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(WeisseSpringer)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseSpringer");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(WeisseLaeufer)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseLaeufer");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(WeisseTuerme)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseTuerme");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(WeisseDamen)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseDamen");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(WeisseKoenige)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseKoenige");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(WeisseBauernZüge)).replace(" ", "0"),
				8)) {
			System.out.println(part + " WeisseBauernZüge");
		}

		System.out.println();

		for (String part : getParts(
				String.format("%64s", Long.toBinaryString(WeisseBauernSchlagZügelinks)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseBauernSchlagZügelinks");
		}

		System.out.println();

		for (String part : getParts(
				String.format("%64s", Long.toBinaryString(WeisseBauernSchlagZügerechts)).replace(" ", "0"), 8)) {
			System.out.println(part + " WeisseBauernSchlagZügerechts");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(SchwarzeBauern)).replace(" ", "0"), 8)) {
			System.out.println(part + " SchwarzeBauern");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(SchwarzeSpringer)).replace(" ", "0"),
				8)) {
			System.out.println(part + " SchwarzeSpringer");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(SchwarzeLaeufer)).replace(" ", "0"), 8)) {
			System.out.println(part + " SchwarzeLaeufer");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(SchwarzeTuerme)).replace(" ", "0"), 8)) {
			System.out.println(part + " SchwarzeTuerme");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(SchwarzeDamen)).replace(" ", "0"), 8)) {
			System.out.println(part + " SchwarzeDamen");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(SchwarzeKoenige)).replace(" ", "0"), 8)) {
			System.out.println(part + " SchwarzeKoenige");
		}

		System.out.println();

		for (String part : getParts(String.format("%64s", Long.toBinaryString(SchwarzeBauernZüge)).replace(" ", "0"),
				8)) {
			System.out.println(part + " SchwarzeBauernZüge");
		}

		System.out.println();

		for (String part : getParts(
				String.format("%64s", Long.toBinaryString(SchwarzeBauernSchlagZügelinks)).replace(" ", "0"), 8)) {
			System.out.println(part + " SchwarzeBauernSchlagZügelinks");
		}

		System.out.println();

		for (String part : getParts(
				String.format("%64s", Long.toBinaryString(SchwarzeBauernSchlagZügerechts)).replace(" ", "0"), 8)) {
			System.out.println(part + " SchwarzeBauernSchlagZügerechts");
		}*/
	}

	private static List<String> getParts(String string, int partitionSize) {
		List<String> parts = new ArrayList<String>();
		int len = string.length();
		for (int i = 0; i < len; i += partitionSize) {
			parts.add(string.substring(i, Math.min(len, i + partitionSize)));
		}
		return parts;
	}

	/**
	 * @param quelle
	 * @param figurfarbe
	 * @return
	 */
	public long[] berechneBauer(int quelle, boolean figurfarbe) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param quelle
	 * @return
	 */
	public long[] berechneGerade(int quelle) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param quelle
	 * @return
	 */
	public long[] berechneSpringer(int quelle) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param quelle
	 * @return
	 */
	public long[] berechneKoenig(int quelle) {
		// TODO Auto-generated method stub
		return null;
	}

}
