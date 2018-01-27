package schachFX;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Class Schach
 * 
 * @author ColBlair
 * @version 1.0
 */
public class Schach extends Application {

	/**
	 * Fenster
	 */
	Stage primaryStage;

	/**
	 * Fensterinhalt
	 */
	Scene scene;

	/**
	 * Hauptmethode
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(Schach.class, args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;

		mainWindow();

	}

	/**
	 * Hauptfenster
	 */
	public void mainWindow() {

		try {

			// View wird geladen
			FXMLLoader loader = new FXMLLoader(Schach.class.getResource("Schachbrett.fxml"));
			BorderPane pane = loader.load();

			// Attribute der Primary Stage werden gesetzt
			primaryStage.setTitle("Schach");
			primaryStage.setResizable(false);

			// Set the application icon.
			this.primaryStage.getIcons().add(new Image("file:resources/images/Chess-Game.png"));

			// Controller wird geladen
			Schachbrett_controller schachbrett_controller = loader.getController();
			schachbrett_controller.setMain(this);

			// Scene wird instanziiert
			scene = new Scene(pane);

			// Hinzufügen des Eventfilters, um alle Möglichkeiten des DragDetect
			// Eventhandlers zu nutzen.
			scene.addEventFilter(MouseEvent.DRAG_DETECTED, new EventHandler<MouseEvent>() {
				/* (non-Javadoc)
				 * @see javafx.event.EventHandler#handle(javafx.event.Event)
				 */
				@Override
				public void handle(MouseEvent mouseEvent) {
					scene.startFullDrag();
				}
			});

			// Scene wird der Stage zugeordnet
			primaryStage.setScene(scene);
			// Stage wird angezeigt
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
