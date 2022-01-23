package dad.calculadorafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

	private Calculadora calculadora = new Calculadora();

	@FXML
	private Button borrarAll;

	@FXML
	private Button buttonBorrar;

	@FXML
	private Button buttonCero;

	@FXML
	private Button buttonCinco;

	@FXML
	private Button buttonComa;

	@FXML
	private Button buttonCuatro;

	@FXML
	private Button buttonDivision;

	@FXML
	private Button buttonDos;

	@FXML
	private Button buttonIgual;

	@FXML
	private Button buttonNueve;

	@FXML
	private Button buttonOcho;

	@FXML
	private Button buttonProducto;

	@FXML
	private Button buttonResta;

	@FXML
	private Button buttonSeis;

	@FXML
	private Button buttonSiete;

	@FXML
	private Button buttonSumar;

	@FXML
	private Button buttonTres;

	@FXML
	private Button buttonUno;

	@FXML
	private GridPane view;

	@FXML
	private TextField viewText;

	private StringProperty viewProperty = new SimpleStringProperty();

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Cal.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewText.textProperty().bind(viewProperty);

		buttonCero.setOnAction(e -> onActionNumber(buttonCero.getText()));
		buttonUno.setOnAction(e -> onActionNumber(buttonUno.getText()));
		buttonDos.setOnAction(e -> onActionNumber(buttonDos.getText()));
		buttonTres.setOnAction(e -> onActionNumber(buttonTres.getText()));
		buttonCuatro.setOnAction(e -> onActionNumber(buttonCuatro.getText()));
		buttonCinco.setOnAction(e -> onActionNumber(buttonCinco.getText()));
		buttonSeis.setOnAction(e -> onActionNumber(buttonSeis.getText()));
		buttonSiete.setOnAction(e -> onActionNumber(buttonSiete.getText()));
		buttonOcho.setOnAction(e -> onActionNumber(buttonOcho.getText()));
		buttonNueve.setOnAction(e -> onActionNumber(buttonNueve.getText()));

		buttonSumar.setOnAction(e -> onOperacionesAction("suma", '+'));
		buttonResta.setOnAction(e -> onOperacionesAction("resta", '-'));
		buttonProducto.setOnAction(e -> onOperacionesAction("multiplicacion", '*'));
		buttonDivision.setOnAction(e -> onOperacionesAction("division", '/'));
		buttonIgual.setOnAction(e -> onOperacionesAction("igual", '='));
		buttonComa.setOnAction(e -> onOperacionesAction("coma", '.'));
		borrarAll.setOnAction(e -> onOperacionesAction("borrarAll", '0'));
		buttonBorrar.setOnAction(e -> onOperacionesAction("borrar", '0'));

		
		MenuItem clasicoItem = new MenuItem("Clásico");
		clasicoItem.setOnAction(e -> {
			view.getStylesheets().setAll("/css/clasica.css");
		});
		
		MenuItem modernoItem = new MenuItem("Moderno");
		modernoItem.setOnAction(e -> {
			view.getStylesheets().setAll("/css/moderna.css");
		});
		
		ContextMenu menu = new ContextMenu(clasicoItem, modernoItem);
		
		view.setOnContextMenuRequested(e -> {
			menu.show(view, e.getScreenX(), e.getScreenY());
		});
		
	}

	private void onOperacionesAction(String string, char c) {
		switch (string) {
		case "suma":
		case "resta":
		case "multiplicacion":
		case "igual":
		case "division":

			calculadora.operar(c);
			break;

		case "coma":
			calculadora.insertarComa();
			break;

		case "borrarAll":
			calculadora.borrarTodo();

		case "borrar":
			calculadora.borrar();

		default:
			break;
		}
		viewProperty.set(calculadora.getPantalla());
	}

	private void onActionNumber(String text) {
		calculadora.insertar(text.charAt(0));
		viewProperty.set(calculadora.getPantalla());
	}

	public GridPane getView() {
		return view;
	}

}
