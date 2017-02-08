package schachFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Schach extends Application {
	
	Scene scene;

	public static void main(String[] args) {
		Application.launch(Schach.class, args);		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Schachbrett.fxml"));
        scene = new Scene(root);
        
        //hinzufügen des Eventfilters um alle Möglichkeiten des DragDetect Eventhandlers zu nutzen
        scene.addEventFilter(MouseEvent.DRAG_DETECTED , new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {
    	        scene.startFullDrag();
    	    }
    	});
        
        stage.setTitle("Schach");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
	
	
}
