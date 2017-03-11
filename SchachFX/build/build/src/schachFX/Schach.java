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

public class Schach extends Application {

	// Fenster
	Stage primaryStage;
	// Fensterinhalt
	Scene scene;

	public static void main(String[] args) {
		Application.launch(Schach.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;

		mainWindow();

	}

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
				@Override
				public void handle(MouseEvent mouseEvent) {
					scene.startFullDrag();
				}
			});

			// Scene wid der Stage zugeordnet
			primaryStage.setScene(scene);
			// Stage wird angezeigt
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
