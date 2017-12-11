/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicechess;

/**
 *
 * @author MERVEk
 */



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    private static int type;
    private static Stage window;
    private static Label label;
    private static FlowPane layout;
    private static Scene scene;
    
    public ConfirmBox(int type){
        this.type = type;
    }
    public static void display(){
        window = new Stage();
        layout = new FlowPane();
        layout.setAlignment(Pos.CENTER);
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        window.initModality(Modality.APPLICATION_MODAL);
        
        if(type == 0){
            window.setTitle("Resign?");
            label = new Label("Are you sure you want to resign?");
            noButton.setOnAction(e -> window.close());
            yesButton.setOnAction(e -> {
                window.close();
                GUI.getPrimaryStage().setScene(GUI.getOpeningScene());
            });
        }
        
        else if(type == 1){
            window.setTitle("New Game?");
            label = new Label("Are you sure you want to start a new game?");
            yesButton.setOnAction(e -> window.close());
            noButton.setOnAction(e -> window.close());
        }
        scene = new Scene(layout,240,240);
        layout.getChildren().addAll(label,yesButton,noButton);
        window.setScene(scene);
        window.showAndWait();
    }
    
}