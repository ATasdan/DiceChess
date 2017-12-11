/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicechess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MERVEk
 */


import static dicechess.GUI.blackTimer;
import static dicechess.GUI.whiteTimer;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable{
    
    @FXML
    private Button startGameButton,rulesButton,mainMenuButton,modeSelectionButton,normalModeButton,timedModeButton,tenMinButton,fifteenMinButton,thirtyMinButton,fortyMinButton;
    private TextField whiteTextField,blackTextField;
    private Label player1Label,player2Label;
    private static Button newGameButton,resignButton,rollButton;
    protected static int result1,result2;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        whiteTextField = new TextField();
        blackTextField = new TextField();
        player1Label = new Label();
        player2Label = new Label();
        newGameButton = new Button("New Game");
        resignButton = new Button("Resign");
        newGameButton.setPrefSize(150,68);
        resignButton.setPrefSize(150,68);
        newGameButton.setFont(new Font("Baskerville New Face",30));
        resignButton.setFont(new Font("Baskerville New Face",23));
        rollButton = new Button("Roll");
        rollButton.setPrefSize(150,68);
        rollButton.setFont(new Font("Baskerville New Face",30));
        
        newGameButton.setOnAction(e -> {
            try{
               handleButtonClick(e);
            }
            catch(IOException ex){}
            });  
        newGameButton.setOnAction(e -> {
            try{
               handleButtonClick(e);
            }
            catch(IOException ex){}
            });  
        rollButton.setOnAction(e -> {
            try{
               handleButtonClick(e);
            }
            catch(IOException ex){}
            });  
        GUI.right = new GridPane();
        GUI.whiteTimer = new TurnTimer(0);
        GUI.blackTimer = new TurnTimer(1);
        GUI.dice1 = new Dice(0);
        GUI.dice2 = new Dice(0);
    }
    
    @FXML
    public void handleButtonClick(ActionEvent event) throws IOException{
        if(event.getSource() == startGameButton){
            GUI.getPrimaryStage().setScene(GUI.getNameScene());
        }
        else if(event.getSource() == rulesButton){
            GUI.getPrimaryStage().setScene(GUI.getRulesScene());
        }
        else if(event.getSource() == mainMenuButton){
            GUI.getPrimaryStage().setScene(GUI.getOpeningScene());
        }
        else if(event.getSource() == modeSelectionButton){
            GUI.getPrimaryStage().setScene(GUI.getModeScene());
            player1Label.setText(GUI.getP1Name());
            player2Label.setText(GUI.getP2Name());
        }
        else if(event.getSource() == normalModeButton){
            GUI.setGameMode(0);
            GUI.getPrimaryStage().setScene(GUI.getGameScene());
            GUI.right.getChildren().addAll(GUI.dice1,GUI.dice2,rollButton);
            GUI.right.setConstraints(GUI.dice1,0,0);
            GUI.right.setConstraints(GUI.dice2,1,0);
            GUI.right.setConstraints(rollButton,0,1);
        }
        else if(event.getSource() == timedModeButton){
            GUI.setGameMode(1);
            GUI.getPrimaryStage().setScene(GUI.getTimerScene());
        }
        else if(event.getSource() == tenMinButton){
            GUI.whiteTimer.setTimerMode(1);
            GUI.blackTimer.setTimerMode(1);
            GUI.getPrimaryStage().setScene(GUI.getGameScene());
            GUI.right.getChildren().addAll(blackTimer,GUI.whiteTimer,GUI.dice1,GUI.dice2,Controller.getRollButton());
            GUI.right.setConstraints(GUI.blackTimer,0,0);
            GUI.right.setConstraints(GUI.whiteTimer,0,1);
            whiteTimer.running = true;
            GUI.right.setConstraints(GUI.dice1,0,2);
            GUI.right.setConstraints(GUI.dice2,1,2);
            GUI.right.setConstraints(rollButton,0,3);
        }
        else if(event.getSource() == fifteenMinButton){
            GUI.whiteTimer.setTimerMode(2);
            GUI.blackTimer.setTimerMode(2);
            GUI.getPrimaryStage().setScene(GUI.getGameScene());            
            GUI.right.getChildren().addAll(blackTimer,GUI.whiteTimer,GUI.dice1,GUI.dice2,Controller.getRollButton());
            GUI.right.setConstraints(GUI.blackTimer,0,0);
            GUI.right.setConstraints(GUI.whiteTimer,0,1);
            whiteTimer.running = true;
            GUI.right.setConstraints(GUI.dice1,0,2);
            GUI.right.setConstraints(GUI.dice2,1,2);
            GUI.right.setConstraints(rollButton,0,3);
        }
        else if(event.getSource() == thirtyMinButton){
            GUI.whiteTimer.setTimerMode(3);
            GUI.blackTimer.setTimerMode(3);
            GUI.getPrimaryStage().setScene(GUI.getGameScene());            
            GUI.right.getChildren().addAll(blackTimer,GUI.whiteTimer,GUI.dice1,GUI.dice2,Controller.getRollButton());
            GUI.right.setConstraints(GUI.blackTimer,0,0);
            GUI.right.setConstraints(GUI.whiteTimer,0,1);
            whiteTimer.running = true;
            GUI.right.setConstraints(GUI.dice1,0,2);
            GUI.right.setConstraints(GUI.dice2,1,2);
            GUI.right.setConstraints(rollButton,0,3);
        }
        else if(event.getSource() == fortyMinButton){
            GUI.whiteTimer.setTimerMode(4);
            GUI.blackTimer.setTimerMode(4);
            GUI.getPrimaryStage().setScene(GUI.getGameScene());
            GUI.right.getChildren().addAll(blackTimer,GUI.whiteTimer,GUI.dice1,GUI.dice2,Controller.getRollButton());
            GUI.right.setConstraints(GUI.blackTimer,0,0);
            GUI.right.setConstraints(GUI.whiteTimer,0,1);
            whiteTimer.running = true;
            GUI.right.setConstraints(GUI.dice1,0,2);
            GUI.right.setConstraints(GUI.dice2,1,2);
            GUI.right.setConstraints(rollButton,0,3);
        }
        else if(event.getSource() == resignButton){
            ConfirmBox box = new ConfirmBox(0);
            box.display();
        }
        else if(event.getSource() == newGameButton){
            ConfirmBox box = new ConfirmBox(1);
            box.display();
        }
        else if(event.getSource() == rollButton){
            result1 = GUI.dice1.roll();
            result2 = GUI.dice2.roll();
        }
    }
    
    @FXML
    public void handleTextField(ActionEvent event) throws IOException{
        GUI.setP1Name(whiteTextField.getText());
        //System.out.println(GUI.getP1Name());
        GUI.setP2Name(blackTextField.getText());
    }

    public static Button getNewGameButton() {
        return newGameButton;
    }

    public static Button getResignButton() {
        return resignButton;
    }

    public static Button getRollButton() {
        return rollButton;
    }
}