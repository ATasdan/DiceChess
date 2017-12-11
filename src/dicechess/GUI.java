package dicechess;




import java.io.IOException;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

public class GUI{
    
    private static Scene openingScene,rulesScene,nameScene,timerScene,gameScene,modeScene;
    private static Stage primaryStage;
    private static GridPane gameBoard;
    private Parent openingRoot,rulesRoot,nameRoot,timerRoot,modeRoot;
    private static String p1Name,p2Name;
    private static int gameMode,timerMode;
    protected static TurnTimer whiteTimer,blackTimer;
    protected static int turn;
    protected static Dice dice1,dice2;
    protected static GridPane right;
    protected static TextArea moveHistory;
    protected static ScrollPane deletedPiecesScroll;
    protected static HBox deletedPiecesPane;
    
    public static void initializeGUI(Stage defaultStage) throws IOException{
        p1Name = "";
        p2Name = "";
        primaryStage = defaultStage;
        primaryStage.setTitle("Dice Chess");
        primaryStage.setScene(openingScene);
        primaryStage.show();
    }
    
    public void initializeFXML() throws IOException{
        openingRoot = FXMLLoader.load(getClass().getResource("OpeningScene.fxml"));
        rulesRoot = FXMLLoader.load(getClass().getResource("RulesScene.fxml"));
        nameRoot = FXMLLoader.load(getClass().getResource("NameScene.fxml"));
        modeRoot = FXMLLoader.load(getClass().getResource("ModeScene.fxml"));
        timerRoot = FXMLLoader.load(getClass().getResource("TimerScene.fxml"));
        openingScene = new Scene(openingRoot,1280,800);
        openingScene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        rulesScene = new Scene(rulesRoot,1280,800);
        rulesScene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        nameScene = new Scene(nameRoot,1280,800);
        nameScene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        modeScene = new Scene(modeRoot,1280,800);
        modeScene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        timerScene = new Scene(timerRoot,1280,800);
        timerScene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        createGameScene();
        gameScene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
    }
    
    public static void createGameScene(){ 
        turn = 0;
        Cell[][] cells = Board.getBOARD();
        gameBoard = new GridPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1280,800);
        VBox left = new VBox();
        right.setPadding(new Insets(10,10,10,10));
        right.setVgap(10);
        right.setHgap(-50);
        HBox top = new HBox();
        HBox bottom = new HBox();
        top.setPrefSize(1280,80);
        bottom.setPrefSize(1280,80);
        left.setPrefSize(320,320);
        right.setPrefSize(320,320);
        left.setPadding(new Insets(30,30,30,30));
        borderPane.setLeft(left);
        borderPane.setRight(right);
        borderPane.setCenter(gameBoard);
        borderPane.setTop(top);
        borderPane.setBottom(bottom);
        gameBoard.setPrefSize(640,640);
        left.getChildren().add(Controller.getNewGameButton());
        left.getChildren().add(Controller.getResignButton());
        left.setMargin(Controller.getNewGameButton(),new Insets(30,30,30,30));
        left.setMargin(Controller.getResignButton(),new Insets(30,30,30,30));
        moveHistory = new TextArea();
        moveHistory.setEditable(false);
        //moveHistory.setFont(new Font(10));
        moveHistory.setPrefSize(150, 150);
        left.getChildren().add(moveHistory);
        deletedPiecesScroll = new ScrollPane();
        deletedPiecesPane = new HBox();
        deletedPiecesScroll.setContent(deletedPiecesPane);
        deletedPiecesScroll.setPrefSize(150,65);
        left.setMargin(deletedPiecesScroll,new Insets(30,30,30,30));
        left.getChildren().add(deletedPiecesScroll);
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Cell cell = cells[j][i];
                gameBoard.getChildren().add(cell);
                gameBoard.setConstraints(cell, i, j);
            }
        }
        gameScene = new Scene(borderPane,1280,800);
    }
    
    public static void addImageToScrollPane(int x,int y){
        ImageView temp = new ImageView(Board.BOARD[y][x].getPiece().getImage());
        temp.setFitHeight(45);
        temp.setFitWidth(45);
        deletedPiecesPane.getChildren().add(temp);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static Scene getOpeningScene() {
        return openingScene;
    }

    public static Scene getRulesScene() {
        return rulesScene;
    }

    public static Scene getNameScene() {
        return nameScene;
    }

    public static Scene getTimerScene() {
        return timerScene;
    }

    public static Scene getGameScene() {
        return gameScene;
    }

    public static Scene getModeScene() {
        return modeScene;
    }

    public static String getP1Name() {
        return p1Name;
    }

    public static String getP2Name() {
        return p2Name;
    }
    
    public static void setP1Name(String a) {
        GUI.p1Name = a;
    }

    public static void setP2Name(String a) {
        GUI.p2Name = a;
    }

    public static int getGameMode() {
        return gameMode;
    }

    public static void setGameMode(int a) {
        GUI.gameMode = a;
    }

    public static int getTimerMode() {
        return timerMode;
    }

    public static void setTimerMode(int a) {
        GUI.timerMode = a;
    }
}