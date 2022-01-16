package dad.calculadorafxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private Controller controlador;

	@Override
	public void start(Stage primaryStage) throws Exception {

		controlador = new Controller();
		//controlador.getView().getStylesheets().add("/css/clasica.css");
		controlador.getView().getStylesheets().add("/css/moderna.css");
		Scene scene = new Scene(controlador.getView());
		primaryStage.setScene(scene);
		primaryStage.setTitle("CalculadoraFXML");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
