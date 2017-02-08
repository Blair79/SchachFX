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

public class Schachbrett_controller {

	// FXML Variablen
	// für die Textausgabe auf der Textarea
	@FXML
	private TextArea actiontarget;
	// für die Textausgabe auf das jeweilige Label
	@FXML
	private Label startposition;
	@FXML
	private Label position;
	@FXML
	private Label endposition;

	// Private Variablen des Controllers
	// die Figur mit der etwas gemacht werden soll
	private ImageView figur = new ImageView();

	// ist der Bewegungsvorgang gestartet worden?
	private boolean bewegeFigur = false;
	// das Feld aus dem die Figur gelöscht werden soll
	private Pane quellfeld = new Pane();
	// das Feld über dem sich der Bewegungsvorgang gerade befindet
	private Pane feld = new Pane();
	// das Feld in das die Figur eingefügt werden soll
	private Pane zielfeld = new Pane();

	// der Punkt von dem aus der Bewegungsvorgang gestartet wurde
	private Point2D startpunkt = new Point2D(0, 0);
	// der Punkt über dem sich der Bewegungsvorgang gerade befindet
	private Point2D aktuelleposition = new Point2D(0, 0);
	// der Punkt an dem der Bewegungsvorgang beendet wurde
	private Point2D endpunkt = new Point2D(0, 0);

	// FXML Funktionen
	// eine Figur bemerkt das sie bewegt werden soll
	@FXML
	protected void onDragDetected(MouseEvent event) {

		// sicherstellen das die Quelle des ausgelösten Events von einer Figur
		// stammt um gültigen Typecast durchzuführen
		if (event.getSource() instanceof ImageView) {

			// festhalten welche Figur bewegt werden soll
			figur = (ImageView) event.getSource();

			// sicherstellen das die Quelle des ausgelösten Events von einem
			// Feld stammt um gültigen Typecast durchzuführen
			if (figur.getParent() instanceof Pane)
				// festhalten von welchem Feld die Figur bewegt werden soll
				quellfeld = (Pane) (figur.getParent());

			// die Figur mit einem Schlagschatten markieren
			figur.setEffect(new DropShadow());

			// Speichern der Bilddatei der Figur im ClipboardContent um bewegt
			// anzuzeigen
			Dragboard dragBoard = ((Node) figur).startDragAndDrop(TransferMode.ANY);
			ClipboardContent content = new ClipboardContent();
			content.putImage(figur.getImage());
			dragBoard.setContent(content);

			// Anzeige des Startpunktes der Bewegung zu Debug zwecken
			startpunkt = new Point2D(event.getSceneX(), event.getSceneY());
			actiontarget.appendText("pressed; ");
			String hilfsstring = startpunkt.toString();
			startposition.setText("StartPunkt" + hilfsstring.substring(hilfsstring.lastIndexOf('D') + 1));

			// der Bewegungsvorgang ist gestartet worden
			bewegeFigur = true;

		}

		// event.consume(); ??
	}

	// ein Feld bemerkt das eine Figur das Feld betritt
	@FXML
	protected void onDragEntered(DragEvent event) {

		// sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde
		if (bewegeFigur) {

			// sicherstellen das die Quelle des ausgelösten Events von einem
			// Feld stammt um gültigen Typecast durchzuführen
			if (event.getSource() instanceof Pane)
				// feststellen welches Feld für das auslösen des Events betreten
				// wurde
				feld = (Pane) event.getSource();

			// das Feld mit einem InnerenSchatten markieren
			feld.setEffect(new InnerShadow());

			// event.acceptTransferModes(TransferMode.MOVE); ??

			// Anzeige das ein Wechsel des Feldes beim betreten und verlassen
			// erfolgt
			actiontarget.appendText("moved;");
		}
		// event.consume(); ??
	}

	// ein Feld bemerkt das eine Figur das Feld verlässt
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

	// ein Feld bemerkt das eine Figur das Feld überquert
	@FXML
	protected void onDragOver(DragEvent event) {

		// sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde
		if (bewegeFigur) {

			// festlegen ob die Figur bewegt werden soll oder kopiert
			event.acceptTransferModes(TransferMode.MOVE);

			// Anzeige des aktuellen Position der Bewegung zu Debug zwecken
			aktuelleposition = new Point2D(event.getSceneX(), event.getSceneY());
			String hilfsstring = aktuelleposition.toString();
			position.setText("Position" + hilfsstring.substring(hilfsstring.lastIndexOf('D') + 1));
		}
		// event.consume(); ??
	}

	// ein Feld bemerkt das eine Figur auf dem Feld fallen gelassen wird
	@FXML
	protected void onDragDropped(DragEvent event) {

		// sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde
		if (bewegeFigur) {
			// sicherstellen das die Quelle des ausgelösten Events von einer
			// Figur stammt um gültigen Typecast durchzuführen
			if ((ImageView) event.getGestureSource() instanceof ImageView)
				quellfeld = (Pane) ((ImageView) event.getGestureSource()).getParent();

			// sicherstellen das die Quelle des ausgelösten Events von einer
			// Figur stammt um gültigen Typecast durchzuführen
			if ((ImageView) event.getGestureSource() instanceof ImageView)
				zielfeld = (Pane) event.getGestureTarget();

			// Anzeige des von Quell- und Zielfeld auf der Konsole zu Debug
			// zwecken
			System.out.println(quellfeld + " drop " + zielfeld);

			// sollten Quellfeld und Zielfeld ungleich sein die Figur dem
			// Zielfeld hinzufügen
			if ((quellfeld != zielfeld))
				zielfeld.getChildren().add(figur);

			// Anzeige des Endposition der Bewegung zu Debug zwecken
			endpunkt = new Point2D(event.getSceneX(), event.getSceneY());
			actiontarget.appendText("released\n");
			String hilfsstring = endpunkt.toString();
			endposition.setText("EndPunkt" + hilfsstring.substring(hilfsstring.lastIndexOf('D') + 1));

		}
		// event.consume(); ??
	}

	// abschliessende Arbeiten nach Bewegung der Figur ins Zielfeld
	@FXML
	protected void onDragDone(DragEvent event) {

		// sicherstellen ob das Event durch eine Figurbewegung ausgelöst wurde
		if (bewegeFigur) {

			// Gleichsetzung von Zielfeld und Quellfeld um bei einer fehlenden
			// Zuweisung (ausgelöst durch ein verlassen des Mauscursors aus dem
			// gültigen Schachbrett) die Ausführung der folgenden IF-Abfrage zu
			// verhindern
			zielfeld = quellfeld;
			
			// Anzeige des von Quell- und Zielfeld auf der Konsole zu Debug
			// zwecken
			System.out.println(quellfeld + " done " + zielfeld);
			
			// sollten Quellfeld und Zielfeld ungleich sein die Figur aus dem
			// Quellfeld entfernen
			if ((quellfeld != zielfeld))
				quellfeld.getChildren().remove(figur);
			
			// sollte das Startfeld mit einem InnerenSchatten markiert sein
			// diese Markierung entfernen
			if (quellfeld.getEffect() != null)
				quellfeld.setEffect(null);

			// der Schlagschatten der Figur wird entfernt
			figur.setEffect(null);
			// Reinitialisierung aller Klassenvariablen
			figur = new ImageView();
			quellfeld = new Pane();
			feld = new Pane();
			zielfeld = new Pane();
			startpunkt = new Point2D(0, 0);
			aktuelleposition = new Point2D(0, 0);
			endpunkt = new Point2D(0, 0);

			// der Bewegungsvorgang ist beendet worden
			bewegeFigur = false;
		}

		// event.consume(); ??
	}
}