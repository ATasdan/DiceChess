package dicechess;


import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Game extends Application{
    
    @Override
    public void start(Stage defaultStage) throws IOException{
        GUI gui = new GUI();
        gui.initializeFXML();
        gui.initializeGUI(defaultStage);
        defaultStage.setOnCloseRequest(e -> {
            e.consume();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        Board.initalizeBoard();
        launch(args);
    }
} // Class