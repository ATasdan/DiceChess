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



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishops extends Piece {

    public static final int[][] POSSIBLE_MOVES = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7},
    {-1, -1}, {-2, -2}, {-3, -3}, {-4, -4}, {-5, -5}, {-6, -6}, {-7, -7},
    {-1, 1}, {-2, 2}, {-3, 3}, {-4, 4}, {-5, 5}, {-6, 6}, {-7, 7},
    {1, -1}, {2, -2}, {3, -3}, {4, -4}, {5, -5}, {6, -6}, {7, -7}};
    public static final int NUMBER_OF_MOVEMENTS = 28;
    public static final int COLOR_OF_BLACK = 1;
    public static final int COLOR_OF_WHITE = 0;

    public Bishops(int color,int type, int posX, int posY, String name, String image_path){
        super(color,type,posX,posY,name);
        super.setImage(new Image(getClass().getResource(image_path).toExternalForm()));
    }

    //@Override
   public boolean move(int x2, int y2) {

        int initial_x = this.getPosX();
        int initial_y = this.getPosY();

        for (int i = 0; i < POSSIBLE_MOVES.length; i++) {
            for (int j = 0; j < POSSIBLE_MOVES[i].length; j++) {

                int go_x = initial_x + POSSIBLE_MOVES[i][0];
                
                int go_y = initial_y + POSSIBLE_MOVES[i][1];
             
                //boşşa gitti
                if (go_x == x2 && go_y == y2) {

                    if (Board.BOARD[y2][x2].getPiece() == null) {
                        this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        return true;
                        
                    } else {
                        //aynı renkte taş gitmedi
                        if (Board.BOARD[y2][x2].getPiece().getColor() == getColor()) {
                            return false;
                        } else {
                            //yiyicek
                            (Board.BOARD[y2][x2]).removePiece();
                            Board.BOARD[y2][x2].setPiece(this);
                            Board.BOARD[initial_y][initial_x].removePiece();
                            this.setPosX(x2);
                            this.setPosY(y2);
                            return true;
                        }
                    }

                }
            }
        }
        
        System.out.println("There is no possible movement");
        return false;
    }
/*public boolean move(int x2, int y2) {

        int initial_x = this.getPosX();
        int initial_y = this.getPosY();
        
        int x_dir = 1, y_dir = 1;
        if (y2-initial_y < 0)
            y_dir = -1;
        if (x2-initial_x < 0)
            x_dir = -1;
        */
        
}