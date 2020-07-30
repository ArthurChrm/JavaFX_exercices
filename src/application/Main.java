package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 600, 600);

			MenuBar menuBar = new MenuBar();
			MenuItem menuItem = new MenuItem("Fermer");
			// menuItem.setAccelerator(new KeyCodeCombination(KeyCode.F));
			menuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
			Menu menu1 = new Menu("Fichier", null, menuItem);
			menu1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.exit(0);
				}
			});
			menuBar.getMenus().add(menu1);
			root.setTop(menuBar);

			GridPane grid = new GridPane();

			Button button = new Button();
			button.setText("Ecrire : \"Hello, world !\"");
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("Hello, world !");

				}
			});
			grid.add(button, 0, 0);

			Rectangle rect2 = new Rectangle(60, 60, 200, 200);
			rect2.setFill(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.RED) }));
			rect2.setStroke(Color.GREEN);
			rect2.setStrokeWidth(10);
			grid.add(rect2, 1, 0);

			ImageView image = new ImageView();
			image.setImage(
					new Image("file:C:\\Users\\arthu\\exercices\\JavaFX\\resources\\chat.jpg", 100, 100, false, false));
			image.setEffect(new DropShadow(20, Color.BLACK));
			grid.add(image, 0, 1);

			ProgressBar progressBar = new ProgressBar();
			grid.add(progressBar, 1, 1);

			Task task = new Task<Void>() {
				@Override
				public Void call() {
					final int max = 1000000;
					for (int i = 1; i <= max; i++) {
						if (isCancelled()) {
							break;
						}
						System.out.println("Simulation d'une longue tâche...");
						updateProgress(i, max);
					}
					return null;
				}
			};
			ProgressBar bar = new ProgressBar();
			grid.add(bar, 1, 1);
			bar.progressProperty().bind(task.progressProperty());
			new Thread(task).start();

			TableView table = new TableView();
			table.setEditable(false);

			TableColumn prenomCol = new TableColumn("Prenom");
			TableColumn nomCol = new TableColumn("Nom");
			TableColumn numCol = new TableColumn("Numéro de téléphone");
			table.getColumns().addAll(prenomCol, nomCol, numCol);

			final ObservableList<Personne> data = FXCollections.observableArrayList(
					new Personne("Jacob", "Smith", "0202020202"), 
					new Personne("Isabella", "Johnson", "0398451123"),
					new Personne("Ethan", "Williams", "1234567890"));

			prenomCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
			nomCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
			numCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("numeroTelephone"));
			table.setItems(data);
			grid.add(table, 0, 2);
			
			SplitPane splitPane = new SplitPane();
			grid.add(splitPane, 1, 2);

			root.setCenter(grid);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
