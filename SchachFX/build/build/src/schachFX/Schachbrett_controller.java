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

public class Schachbrett_controller {

	// FXML Variablen:
	// Für die Textausgabe auf der Textarea.
	@FXML
	private TextArea statusAusgabe;
	@FXML
	private TextArea notation;
	// Für die Textausgabe auf das jeweilige Label.
	@FXML
	private Label startposition;
	@FXML
	private Label position;
	@FXML
	private Label endposition;

	// Felder
	@FXML
	private Pane a1;
	@FXML
	private Pane b1;
	@FXML
	private Pane c1;
	@FXML
	private Pane d1;
	@FXML
	private Pane e1;
	@FXML
	private Pane f1;
	@FXML
	private Pane g1;
	@FXML
	private Pane h1;

	@FXML
	private Pane a2;
	@FXML
	private Pane b2;
	@FXML
	private Pane c2;
	@FXML
	private Pane d2;
	@FXML
	private Pane e2;
	@FXML
	private Pane f2;
	@FXML
	private Pane g2;
	@FXML
	private Pane h2;

	@FXML
	private Pane a3;
	@FXML
	private Pane b3;
	@FXML
	private Pane c3;
	@FXML
	private Pane d3;
	@FXML
	private Pane e3;
	@FXML
	private Pane f3;
	@FXML
	private Pane g3;
	@FXML
	private Pane h3;

	@FXML
	private Pane a4;
	@FXML
	private Pane b4;
	@FXML
	private Pane c4;
	@FXML
	private Pane d4;
	@FXML
	private Pane e4;
	@FXML
	private Pane f4;
	@FXML
	private Pane g4;
	@FXML
	private Pane h4;

	@FXML
	private Pane a5;
	@FXML
	private Pane b5;
	@FXML
	private Pane c5;
	@FXML
	private Pane d5;
	@FXML
	private Pane e5;
	@FXML
	private Pane f5;
	@FXML
	private Pane g5;
	@FXML
	private Pane h5;

	@FXML
	private Pane a6;
	@FXML
	private Pane b6;
	@FXML
	private Pane c6;
	@FXML
	private Pane d6;
	@FXML
	private Pane e6;
	@FXML
	private Pane f6;
	@FXML
	private Pane g6;
	@FXML
	private Pane h6;

	@FXML
	private Pane a7;
	@FXML
	private Pane b7;
	@FXML
	private Pane c7;
	@FXML
	private Pane d7;
	@FXML
	private Pane e7;
	@FXML
	private Pane f7;
	@FXML
	private Pane g7;
	@FXML
	private Pane h7;

	@FXML
	private Pane a8;
	@FXML
	private Pane b8;
	@FXML
	private Pane c8;
	@FXML
	private Pane d8;
	@FXML
	private Pane e8;
	@FXML
	private Pane f8;
	@FXML
	private Pane g8;
	@FXML
	private Pane h8;

	// Private Variablen des Controllers:

	// Das Hauptfenster
	private Schach schach;
	// Das laufende Spiel
	private Spiel spiel = new Spiel(this);
	// Der wievielte Zug
	int ZuegeAnzahl = 0;

	// Die Figur mit der etwas gemacht werden soll.
	private ImageView figur = new ImageView();

	// Ist der Bewegungsvorgang gestartet worden?
	private boolean bewegeFigur = false;

	// Das Feld aus dem die Figur gelöscht werden soll.
	private Pane quellfeld = new Pane();
	// Das Feld über dem sich der Bewegungsvorgang gerade befindet.
	private Pane feld = new Pane();
	// Das Feld in das die Figur eingefügt werden soll.
	private Pane zielfeld = new Pane();

	// Der Punkt von dem aus der Bewegungsvorgang gestartet wurde.
	private Point2D startpunkt = new Point2D(0, 0);
	// Der Punkt über dem sich der Bewegungsvorgang gerade befindet.
	private Point2D aktuelleposition = new Point2D(0, 0);
	// Der Punkt an dem der Bewegungsvorgang beendet wurde.
	private Point2D endpunkt = new Point2D(0, 0);

	public void setMain(Schach schach) {
		this.schach = schach;
	}

	public void neuesSpiel() {

		schach.mainWindow();
		ausgabe("neues Spiel");
	}

	public void ausgabe(String ausgabeText) {

		statusAusgabe.appendText(ausgabeText);
	}

	public void notiere(String quelle, String ziel, String notationsText) {

		notation.appendText(++ZuegeAnzahl + ". " + notationsText + "\n");
		spiel.notiere(quelle, ziel);

	}

	public void ziehe(String quelle, String ziel) {
		System.out.println("ich ziehe " + quelle + " " + ziel);
		// zielfeld.getChildren().add(figur);
		// quellfeld.getChildren().remove(figur);

		quellfeld = feldsuche(quelle);
		if (quellfeld.getChildren().get(0) instanceof ImageView) {
			figur = (ImageView) quellfeld.getChildren().get(0);
		}
		zielfeld = feldsuche(ziel);
		zielfeld.getChildren().add(figur);

		String hilfsstring = figur.getId();
		notiere(quellfeld.getId(), zielfeld.getId(), "Ziehe " + hilfsstring.substring(0, hilfsstring.indexOf('_'))
				+ " von " + quellfeld.getId() + " nach " + zielfeld.getId());
	}

	public Pane feldsuche(String feld) {
		Pane gesuchtesFeld = null;
		switch (feld) {
		case "A1":
			gesuchtesFeld = a1;
			break;
		case "A2":
			gesuchtesFeld = a2;
			break;
		case "A3":
			gesuchtesFeld = a3;
			break;
		case "A4":
			gesuchtesFeld = a4;
			break;
		case "A5":
			gesuchtesFeld = a5;
			break;
		case "A6":
			gesuchtesFeld = a6;
			break;
		case "A7":
			gesuchtesFeld = a7;
			break;
		case "A8":
			gesuchtesFeld = a8;
			break;

		case "B1":
			gesuchtesFeld = b1;
			break;
		case "B2":
			gesuchtesFeld = b2;
			break;
		case "B3":
			gesuchtesFeld = b3;
			break;
		case "B4":
			gesuchtesFeld = b4;
			break;
		case "B5":
			gesuchtesFeld = b5;
			break;
		case "B6":
			gesuchtesFeld = b6;
			break;
		case "B7":
			gesuchtesFeld = b7;
			break;
		case "B8":
			gesuchtesFeld = b8;
			break;

		case "C1":
			gesuchtesFeld = c1;
			break;
		case "C2":
			gesuchtesFeld = c2;
			break;
		case "C3":
			gesuchtesFeld = c3;
			break;
		case "C4":
			gesuchtesFeld = c4;
			break;
		case "C5":
			gesuchtesFeld = c5;
			break;
		case "C6":
			gesuchtesFeld = c6;
			break;
		case "C7":
			gesuchtesFeld = c7;
			break;
		case "C8":
			gesuchtesFeld = c8;
			break;

		case "D1":
			gesuchtesFeld = d1;
			break;
		case "D2":
			gesuchtesFeld = d2;
			break;
		case "D3":
			gesuchtesFeld = d3;
			break;
		case "D4":
			gesuchtesFeld = d4;
			break;
		case "D5":
			gesuchtesFeld = d5;
			break;
		case "D6":
			gesuchtesFeld = d6;
			break;
		case "D7":
			gesuchtesFeld = d7;
			break;
		case "D8":
			gesuchtesFeld = d8;
			break;

		case "E1":
			gesuchtesFeld = e1;
			break;
		case "E2":
			gesuchtesFeld = e2;
			break;
		case "E3":
			gesuchtesFeld = e3;
			break;
		case "E4":
			gesuchtesFeld = e4;
			break;
		case "E5":
			gesuchtesFeld = e5;
			break;
		case "E6":
			gesuchtesFeld = e6;
			break;
		case "E7":
			gesuchtesFeld = e7;
			break;
		case "E8":
			gesuchtesFeld = e8;
			break;

		case "F1":
			gesuchtesFeld = f1;
			break;
		case "F2":
			gesuchtesFeld = f2;
			break;
		case "F3":
			gesuchtesFeld = f3;
			break;
		case "F4":
			gesuchtesFeld = f4;
			break;
		case "F5":
			gesuchtesFeld = f5;
			break;
		case "F6":
			gesuchtesFeld = f6;
			break;
		case "F7":
			gesuchtesFeld = f7;
			break;
		case "F8":
			gesuchtesFeld = f8;
			break;

		case "G1":
			gesuchtesFeld = g1;
			break;
		case "G2":
			gesuchtesFeld = g2;
			break;
		case "G3":
			gesuchtesFeld = g3;
			break;
		case "G4":
			gesuchtesFeld = g4;
			break;
		case "G5":
			gesuchtesFeld = g5;
			break;
		case "G6":
			gesuchtesFeld = g6;
			break;
		case "G7":
			gesuchtesFeld = g7;
			break;
		case "G8":
			gesuchtesFeld = g8;
			break;

		case "H1":
			gesuchtesFeld = h1;
			break;
		case "H2":
			gesuchtesFeld = h2;
			break;
		case "H3":
			gesuchtesFeld = h3;
			break;
		case "H4":
			gesuchtesFeld = h4;
			break;
		case "H5":
			gesuchtesFeld = h5;
			break;
		case "H6":
			gesuchtesFeld = h6;
			break;
		case "H7":
			gesuchtesFeld = h7;
			break;
		case "H8":
			gesuchtesFeld = h8;
			break;
		default:
			System.out.println("Fehlerhafte Feldbezeichnung");
		}
		return gesuchtesFeld;
	}

	// FXML Funktionen:
	// Eine Figur bemerkt, das sie bewegt werden soll.
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

	// Ein Feld bemerkt, das eine Figur das Feld betritt.
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

	// Ein Feld bemerkt, das eine Figur das Feld verlässt.
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

	// Ein Feld bemerkt das eine Figur das Feld überquert.
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

	// Eein Feld bemerkt, das eine Figur auf dem Feld fallen gelassen wird.
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
			if ((quellfeld != zielfeld) && (spiel.istZugerlaubt(figur.getId(), quellfeld.getId(), zielfeld.getId()))) {
				zielfeld.getChildren().add(figur);
				String hilfsstring = figur.getId();
				notiere(quellfeld.getId(), zielfeld.getId(),
						"Ziehe " + hilfsstring.substring(0, hilfsstring.indexOf('_')) + " von " + quellfeld.getId()
								+ " nach " + zielfeld.getId());
			}

			// Anzeige des Endposition der Bewegung zu Debug Zwecken.
			endpunkt = new Point2D(event.getSceneX(), event.getSceneY());
			ausgabe("released\n");
			String hilfsstring = endpunkt.toString();
			endposition.setText("EndPunkt" + hilfsstring.substring(hilfsstring.lastIndexOf('D') + 1));

		}
		// event.consume(); ??
	}

	// Abschließende Arbeiten nach Bewegung der Figur ins Zielfeld.
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
			//spiel.ziehe("E7","E6");
		}

		// event.consume(); ??
	}
}