package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;


public class ViewRoomStudent extends Application{
	public	static	void	main(String[]	args)	{	
		launch(args);	
}
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(500);
        stage.setHeight(500);
        GridPane grid =new GridPane();
        
        final Label label = new Label("Booked Rooms");
        
        label.setFont(new Font("Arial", 20));
        TableView table = new TableView();
 
        TableColumn RoomsNo = new TableColumn("Rooms No");
        TableColumn TimeSlot = new TableColumn("Time Slot");
        TableColumn Date = new TableColumn("Date");
        TableColumn Day = new TableColumn("Day");
        TableColumn Purpose = new TableColumn("Purpose");
        
        table.getColumns().addAll(RoomsNo, TimeSlot, Date,Day,Purpose);
        
        
        final Label label2 = new Label("Available Rooms");
        
        label.setFont(new Font("Arial", 20));
        TableView table2 = new TableView();
        
        table2.setEditable(true);
 
        TableColumn RoomsNo2 = new TableColumn("Rooms No");
        TableColumn TimeSlot2 = new TableColumn("Time Slot");
        TableColumn Date2 = new TableColumn("Date");
        TableColumn Day2 = new TableColumn("Day");
       // TableColumn Purpose = new TableColumn("Purpose");
        
        table2.getColumns().addAll(RoomsNo2, TimeSlot2, Date2,Day2);
        
        Button btn = new Button("Request booking");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		
		final Text actiontarget = new Text();
        //grid.add(actiontarget, 1, 6);
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
                /*if(Type.getText()=="Student"){
                	Main h=new Main();
                	h.setVisible(true);
                }*/
                
            }
        });
        
 
        final HBox vbox = new HBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 0));
        vbox.getChildren().addAll(label, table,label2,table2,btn);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
		
        stage.setScene(scene);
        stage.show();
	}
	}

