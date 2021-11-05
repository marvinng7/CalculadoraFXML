package dad.calculadorafxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {

	
	private Controller controlador;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		controlador = new Controller();
		Scene scene = new Scene(controlador.getView(),400,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CalculadoraFXML");
		primaryStage.show();
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
