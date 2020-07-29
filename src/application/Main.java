package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,600,600);
			
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().add(new Menu("Premier menu"));
			menuBar.getMenus().add(new Menu("Deuxième menu"));
			root.setTop(menuBar);
			

			GridPane grid = new GridPane();
			
			Text text = new Text();
			text.setText("Hello, world !");
			text.setFont(Font.font("Cambria", FontPosture.ITALIC, 45));
			grid.add(text, 0, 1);			
			
			Rectangle rect2 = new Rectangle(60, 60, 200, 200);
            rect2.setFill(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.RED)}));
            rect2.setStroke(Color.GREEN);
            rect2.setStrokeWidth(10);
            grid.add(rect2, 1,1);
            
            root.setCenter(grid);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
