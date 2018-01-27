package schachFX;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import schachFX.Spiel;

/**
 * Class Schachbrett_controller
 * 
 * @author ColBlair
 * @version 1.0
 */
public class Schachbrett_controller {

	// FXML Variablen:
	/**
	 * Für die Textausgabe auf der Textarea.
	 */
	@FXML
	private TextArea statusAusgabe;
	/**
	 * Für die Textausgabe auf der Textarea.
	 */
	@FXML
	private TextArea notation;
	/**
	 * Für die Textausgabe auf das jeweilige Label.
	 */
	@FXML
	private Label startposition;
	/**
	 * Für die Textausgabe auf das jeweilige Label.
	 */
	@FXML
	private Label position;
	/**
	 * Für die Textausgabe auf das jeweilige Label.
	 */
	@FXML
	private Label endposition;

	// Felder
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a1;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b1;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c1;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d1;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e1;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f1;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g1;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h1;

	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a2;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b2;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c2;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d2;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e2;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f2;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g2;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h2;

	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a3;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b3;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c3;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d3;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e3;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f3;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g3;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h3;

	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a4;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b4;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c4;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d4;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e4;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f4;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g4;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h4;

	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a5;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b5;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c5;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d5;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e5;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f5;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g5;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h5;

	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a6;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b6;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c6;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d6;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e6;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f6;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g6;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h6;

	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a7;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b7;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c7;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d7;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e7;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f7;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g7;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h7;

	/**
	 * Schachfeld
	 */
	@FXML
	private Pane a8;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane b8;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane c8;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane d8;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane e8;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane f8;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane g8;
	/**
	 * Schachfeld
	 */
	@FXML
	private Pane h8;

	/**
	 * Felder als Array für Offsetzugriff 1 hoch = offset+8
	 */
	public Pane[] gameBoard = { null, null, null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, a1, b1, c1, d1, e1, f1, g1, h1, null, null, a2, b2, c2, d2,
			e2, f2, g2, h2, null, null, a3, b3, c3, d3, e3, f3, g3, h3, null, null, a4, b4, c4, d4, e4, f4, g4, h4,
			null, null, a5, b5, c5, d5, e5, f5, g5, h5, null, null, a6, b6, c6, d6, e6, f6, g6, h6, null, null, a7, b7,
			c7, d7, e7, f7, g7, h7, null, null, a8, b8, c8, d8, e8, f8, g8, h8, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };

	// Private Variablen des Controllers:

	/**
	 * Das Hauptfenster
	 */
	private Schach schach;
	/**
	 * Das laufende Spiel
	 */
	private Spiel spiel = new Spiel(this);
	/**
	 * Der wievielte Zug
	 */
	int ZuegeAnzahl = 0;

	/**
	 * Die Figur mit der etwas gemacht werden soll.
	 */
	private ImageView figur = new ImageView();

	/**
	 * Ist der Bewegungsvorgang gestartet worden?
	 */
	private boolean bewegeFigur = false;

	/**
	 * Das Feld aus dem die Figur gelöscht werden soll.
	 */
	private Pane quellfeld = new Pane();
	/**
	 * Das Feld über dem sich der Bewegungsvorgang gerade befindet.
	 */
	private Pane feld = new Pane();
	/**
	 * Das Feld in das die Figur eingefügt werden soll.
	 */
	private Pane zielfeld = new Pane();
	/**
	 * Das Feld in das die zu löschende Figur eingefügt werden soll.
	 */
	private Pane löschfeld = new Pane();

	/**
	 * Der Punkt von dem aus der Bewegungsvorgang gestartet wurde.
	 */
	private Point2D startpunkt = new Point2D(0, 0);
	/**
	 * Der Punkt über dem sich der Bewegungsvorgang gerade befindet.
	 */
	private Point2D aktuelleposition = new Point2D(0, 0);
	/**
	 * Der Punkt an dem der Bewegungsvorgang beendet wurde.
	 */
	private Point2D endpunkt = new Point2D(0, 0);

	/**
	 * @param schach
	 */
	public void setMain(Schach schach) {
		this.schach = schach;
	}

	/**
	 * 
	 */
	public void neuesSpiel() {

		schach.mainWindow();
		ausgabe("neues Spiel");
	}

	/**
	 * @param ausgabeText
	 */
	public void ausgabe(String ausgabeText) {

		statusAusgabe.appendText(ausgabeText);
	}

	/**
	 * @param quelle
	 * @param ziel
	 * @param notationsText
	 */
	public void notiere(int quelle, int ziel, String notationsText) {

		notation.appendText(++ZuegeAnzahl + ". " + notationsText + "\n");
		spiel.notiere(quelle, ziel);

	}

	/*
	 * public void ziehe(String quelle, String ziel) {
	 * System.out.println("ich ziehe " + quelle + " " + ziel); //
	 * zielfeld.getChildren().add(figur); // quellfeld.getChildren().remove(figur);
	 * 
	 * quellfeld = feldsuche(quelle); if (quellfeld.getChildren().get(0) instanceof
	 * ImageView) { figur = (ImageView) quellfeld.getChildren().get(0); } zielfeld =
	 * //feldsuche(ziel); zielfeld.getChildren().add(figur);
	 * 
	 * String hilfsstring = figur.getId(); notiere(quellfeld.getId(),
	 * zielfeld.getId(), "Ziehe " + hilfsstring.substring(0,
	 * hilfsstring.indexOf('_')) + " von " + quellfeld.getId() + " nach " +
	 * zielfeld.getId()); }
	 */

	/*
	 * public Pane feldsuche(String feld) { Pane gesuchtesFeld = null; switch (feld)
	 * { case "0": gesuchtesFeld = a1; break; case "1": gesuchtesFeld = a2; break;
	 * case "2": gesuchtesFeld = a3; break; case "3": gesuchtesFeld = a4; break;
	 * case "4": gesuchtesFeld = a5; break; case "5": gesuchtesFeld = a6; break;
	 * case "6": gesuchtesFeld = a7; break; case "7": gesuchtesFeld = a8; break;
	 * 
	 * case "8": gesuchtesFeld = b1; break; case "9": gesuchtesFeld = b2; break;
	 * case "10": gesuchtesFeld = b3; break; case "11": gesuchtesFeld = b4; break;
	 * case "12": gesuchtesFeld = b5; break; case "13": gesuchtesFeld = b6; break;
	 * case "14": gesuchtesFeld = b7; break; case "15": gesuchtesFeld = b8; break;
	 * 
	 * case "16": gesuchtesFeld = c1; break; case "17": gesuchtesFeld = c2; break;
	 * case "18": gesuchtesFeld = c3; break; case "19": gesuchtesFeld = c4; break;
	 * case "20": gesuchtesFeld = c5; break; case "21": gesuchtesFeld = c6; break;
	 * case "22": gesuchtesFeld = c7; break; case "23": gesuchtesFeld = c8; break;
	 * 
	 * case "24": gesuchtesFeld = d1; break; case "25": gesuchtesFeld = d2; break;
	 * case "26": gesuchtesFeld = d3; break; case "27": gesuchtesFeld = d4; break;
	 * case "28": gesuchtesFeld = d5; break; case "29": gesuchtesFeld = d6; break;
	 * case "30": gesuchtesFeld = d7; break; case "31": gesuchtesFeld = d8; break;
	 * 
	 * case "32": gesuchtesFeld = e1; break; case "33": gesuchtesFeld = e2; break;
	 * case "34": gesuchtesFeld = e3; break; case "35": gesuchtesFeld = e4; break;
	 * case "36": gesuchtesFeld = e5; break; case "37": gesuchtesFeld = e6; break;
	 * case "38": gesuchtesFeld = e7; break; case "39": gesuchtesFeld = e8; break;
	 * 
	 * case "40": gesuchtesFeld = f1; break; case "41": gesuchtesFeld = f2; break;
	 * case "42": gesuchtesFeld = f3; break; case "43": gesuchtesFeld = f4; break;
	 * case "44": gesuchtesFeld = f5; break; case "45": gesuchtesFeld = f6; break;
	 * case "46": gesuchtesFeld = f7; break; case "47": gesuchtesFeld = f8; break;
	 * 
	 * case "48": gesuchtesFeld = g1; break; case "49": gesuchtesFeld = g2; break;
	 * case "50": gesuchtesFeld = g3; break; case "51": gesuchtesFeld = g4; break;
	 * case "52": gesuchtesFeld = g5; break; case "53": gesuchtesFeld = g6; break;
	 * case "54": gesuchtesFeld = g7; break; case "55": gesuchtesFeld = g8; break;
	 * 
	 * case "56": gesuchtesFeld = h1; break; case "57": gesuchtesFeld = h2; break;
	 * case "58": gesuchtesFeld = h3; break; case "59": gesuchtesFeld = h4; break;
	 * case "60": gesuchtesFeld = h5; break; case "61": gesuchtesFeld = h6; break;
	 * case "62": gesuchtesFeld = h7; break; case "63": gesuchtesFeld = h8; break;
	 * default: System.out.println("Fehlerhafte Feldbezeichnung"); } return
	 * gesuchtesFeld; }
	 */

	// FXML Funktionen:
	/**
	 * Eine Figur bemerkt, das sie bewegt werden soll.
	 * @param event
	 */
	@FXML
	protected void onDragDetected(MouseEvent event) {

		// Sicherstellen das die Quelle des ausgelösten Events von einer Figur
		// stammt, um gültigen Typecast durchzuführen.
		if (event.getSource() instanceof ImageView) {

			// Festhalten welche Figur bewegt werden soll.
			figur = (ImageView) event.getSource();

			// Sicherstellen das die Quelle des ausgelösten Events von einem
			// Feld stammt, um gültigen Typecast durchzuführen.
			if (figur.getParent() instanceof Pane)
				// Festhalten von welchem Feld die Figur bewegt werden soll.
				quellfeld = (Pane) (figur.getParent());

			// Die Figur mit einem Schlagschatten markieren.
			figur.setEffect(new DropShadow());

			// Speichern der Bilddatei der Figur im ClipboardContent, um deren
			// Bewegung
			// anzuzeigen.
			Dragboard dragBoard = ((Node) figur).startDragAndDrop(TransferMode.ANY);
			ClipboardContent content = new ClipboardContent();
			content.putImage(figur.getImage());
			dragBoard.setContent(content);

			// Anzeige des Startpunktes der Bewegung zu Debug Zwecken.
			startpunkt = new Point2D(event.getSceneX(), event.getSceneY());
			ausgabe("pressed; ");
			String hilfsstring = startpunkt.toString();
			startposition.setText("StartPunkt" + hilfsstring.substring(hilfsstring.lastIndexOf('D') + 1));

			// Der Bewegungsvorgang ist gestartet worden.
			bewegeFigur = true;

		}

		// event.consume(); ??
	}

	/**
	 * Ein Feld bemerkt, das eine Figur das Feld betritt.
	 * @param event
	 */
	@FXML
	protected void onDragEntered(DragEvent event) {

		// Sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde.
		if (bewegeFigur) {

			// Sicherstellen das die Quelle des ausgelösten Events von einem
			// Feld stammt, um gültigen Typecast durchzuführen.
			if (event.getSource() instanceof Pane)
				// Feststellen welches Feld für das auslösen des Events betreten
				// wurde.
				feld = (Pane) event.getSource();

			// Das Feld mit einem InnerenSchatten markieren.
			feld.setEffect(new InnerShadow());

			// event.acceptTransferModes(TransferMode.MOVE); ??

			// Anzeige das ein Wechsel des Feldes beim betreten und verlassen
			// erfolgt.
			ausgabe("moved;");
		}
		// event.consume(); ??
	}

	/**
	 * Ein Feld bemerkt, das eine Figur das Feld verlässt.
	 * @param event
	 */
	@FXML
	protected void onDragExited(DragEvent event) {

		// sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde
		if (bewegeFigur) {

			// sicherstellen das die Quelle des ausgelösten Events von einem
			// Feld stammt um gültigen Typecast durchzuführen
			if (event.getSource() instanceof Pane)
				// feststellen welches Feld beim auslösen des Events verlassen
				// wurde
				feld = (Pane) event.getSource();

			// den InnerenSchatten des Feldes das verlassen wird entfernen
			feld.setEffect(null);

			// sollte das Startfeld mit keinem InnerenSchatten markiert sein
			// diese Markierung setzen
			if (quellfeld.getEffect() == null)
				quellfeld.setEffect(new InnerShadow());
		}
		// event.consume(); ??
	}

	/**
	 * Ein Feld bemerkt das eine Figur das Feld überquert.
	 * @param event
	 */
	@FXML
	protected void onDragOver(DragEvent event) {

		// Sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde.
		if (bewegeFigur) {

			// Festlegen ob die Figur bewegt werden soll oder kopiert.
			event.acceptTransferModes(TransferMode.MOVE);

			// Anzeige des aktuellen Position der Bewegung zu Debug Zwecken.
			aktuelleposition = new Point2D(event.getSceneX(), event.getSceneY());
			String hilfsstring = aktuelleposition.toString();
			position.setText("Position" + hilfsstring.substring(hilfsstring.lastIndexOf('D') + 1));
		}
		// event.consume(); ??
	}

	/**
	 * Ein Feld bemerkt, das eine Figur auf dem Feld fallen gelassen wird.
	 * @param event
	 */
	@FXML
	protected void onDragDropped(DragEvent event) {

		// Sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde.
		if (bewegeFigur) {
			// Sicherstellen das die Quelle des ausgelösten Events von einer
			// Figur stammt, um gültigen Typecast durchzuführen.
			if ((ImageView) event.getGestureSource() instanceof ImageView)
				quellfeld = (Pane) ((ImageView) event.getGestureSource()).getParent();

			// Sicherstellen das die Quelle des ausgelösten Events von einer
			// Figur stammt, um gültigen Typecast durchzuführen.
			if ((ImageView) event.getGestureSource() instanceof ImageView)
				zielfeld = (Pane) event.getGestureTarget();

			// Anzeige des von Quell- und Zielfeld auf der Konsole zu Debug
			// Zwecken.
			// System.out.println(quellfeld + " drop " + zielfeld);

			// Sollten Quellfeld und Zielfeld ungleich sein, die Figur dem
			// Zielfeld hinzufügen.
			int quelle = Integer.parseInt(quellfeld.getId());
			int ziel = Integer.parseInt(zielfeld.getId());

			// 0=leeres feld, 1=schlagen, -1=Figur eigener Farbe
			//String quellfarbe = figur.getId().substring(figur.getId().indexOf('_'), figur.getId().length() - 1);
			String zielfarbe = "";

			if (!zielfeld.getChildren().isEmpty())
				zielfarbe = zielfeld.getChildren().get(0).getId().substring(
						zielfeld.getChildren().get(0).getId().indexOf('_'),
						zielfeld.getChildren().get(0).getId().length() - 1);

			if ((quellfeld != zielfeld) && (spiel.istZugerlaubt(figur.getId(), zielfarbe, quelle, ziel))) {
				// Zu schlagende Figur wird ins löschfeld verschoben
				if (!zielfeld.getChildren().isEmpty())
					löschfeld.getChildren().add(zielfeld.getChildren().get(0));
				zielfeld.getChildren().add(figur);
				String hilfsstring = figur.getId();
				notiere(quelle, ziel, "Ziehe " + hilfsstring.substring(0, hilfsstring.indexOf('_')) + " von " + quelle
						+ " nach " + ziel);
				zielfarbe = "";

			}

			// Anzeige des Endposition der Bewegung zu Debug Zwecken.
			endpunkt = new Point2D(event.getSceneX(), event.getSceneY());
			ausgabe("released\n");
			String hilfsstring = endpunkt.toString();
			endposition.setText("EndPunkt" + hilfsstring.substring(hilfsstring.lastIndexOf('D') + 1));

		}
		// event.consume(); ??
	}

	/**
	 * Abschließende Arbeiten nach Bewegung der Figur ins Zielfeld.
	 * @param event
	 */
	@FXML
	protected void onDragDone(DragEvent event) {

		// Sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde.
		if (bewegeFigur) {

			// Gleichsetzung von Zielfeld und Quellfeld, um bei einer fehlenden
			// Zuweisung (ausgelöst durch ein verlassen des Mauscursors aus dem
			// gültigen Schachbrett) die Ausführung der folgenden IF-Abfrage zu
			// verhindern.
			// zielfeld = quellfeld;
			// Unnötig da folgende Abfrage obsolet

			// Anzeige des von Quell- und Zielfeld auf der Konsole zu Debug
			// Zwecken.
			// System.out.println(quellfeld + " done " + zielfeld);

			// Sollten Quellfeld und Zielfeld ungleich sein, die Figur aus dem
			// Quellfeld entfernen.
			// if ((quellfeld != zielfeld))
			// quellfeld.getChildren().remove(figur);
			// Unnötig da Implizit

			// Sollte das Startfeld mit einem InnerenSchatten markiert sein,
			// diese Markierung entfernen.
			if (quellfeld.getEffect() != null)
				quellfeld.setEffect(null);

			// Der Schlagschatten der Figur wird entfernt.
			figur.setEffect(null);
			// Reinitialisierung aller Klassenvariablen.
			figur = new ImageView();
			quellfeld = new Pane();
			feld = new Pane();
			zielfeld = new Pane();
			startpunkt = new Point2D(0, 0);
			aktuelleposition = new Point2D(0, 0);
			endpunkt = new Point2D(0, 0);

			// der Bewegungsvorgang ist beendet worden
			bewegeFigur = false;
			// TODO Computerspieler starten
			// spiel.ziehe("E7","E6");
		}

		// event.consume(); ??
	}
}