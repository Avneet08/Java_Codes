package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Student extends Application{
	public	static	void	main(String[]	args)	{	
		launch(args);	
}
	@Override
	public void start(Stage stage) {
		//primaryStage.setTitle("JavaFX Welcome");
		MenuBar menuBar = new MenuBar();
        
        // Create menus
        Menu RoomsMenu = new Menu("Rooms");
        Menu CoursesMenu = new Menu("Courses");
        Menu TimetableMenu = new Menu("TimeTable");
        Menu helpMenu = new Menu("Help");
        
        // Create MenuItems
        MenuItem ViewRooms = new MenuItem("ViewRooms");
        MenuItem RequestRoom = new MenuItem("RequestRoom");
        MenuItem exitItem = new MenuItem("Exit");
        
        MenuItem viewCourses= new MenuItem("viewCourses");
        MenuItem RegisterCourses = new MenuItem("Register");
        
        MenuItem GenerateTT=new MenuItem("Generate TT");
        
        // Add menuItems to the Menus
        RoomsMenu.getItems().addAll(ViewRooms, RequestRoom, exitItem);
        CoursesMenu.getItems().addAll(viewCourses, RegisterCourses);
        TimetableMenu.getItems().add(GenerateTT);
        
        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(RoomsMenu, CoursesMenu, TimetableMenu,helpMenu);
        
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene scene = new Scene(root, 350, 200);
        stage.setTitle("JavaFX Menu (o7planning.org)");
        stage.setScene(scene);
        stage.show();
		 //primaryStage.show();
		}
}
