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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author MERVEk
 */
public class Pawns extends Piece {
    public static int[][] POSSIBLE_MOVES_W = {{1,-1},{-1,-1},{0, -1},{0,0}};
    public static int[][] POSSIBLE_MOVES_B = {{-1,1},{1, 1},{0, 1},{0,0}};
       
    public static final int NUMBER_OF_MOVEMENTS = 4;
    public static final int COLOR_OF_BLACK = 1;
    public static final int COLOR_OF_WHITE = 0;

    public Pawns(int color,int type, int posX, int posY, String name, String image_path) {
        super(color,type, posX, posY, name);
        super.setImage(new Image(getClass().getResource(image_path).toExternalForm()));
        
    }

    @Override
    public boolean move(int x2, int y2) {

        int initial_x = this.getPosX();
        int initial_y = this.getPosY();
        if (getColor() == 0){
            
            if(initial_y == 6){
                System.out.println("beyaz piyon 6. satırda");
            POSSIBLE_MOVES_W[3][1] = -2;
            System.out.println("koordinat eklendi");
            }
            System.out.println("6 değil normal devam");
        for (int i = 0; i < POSSIBLE_MOVES_W.length; i++) {
            for (int j = 0; j < POSSIBLE_MOVES_W[i].length; j++) {
                
                //System.out.println(POSSIBLE_MOVES_W[i][j] );
                
                int go_x = initial_x + POSSIBLE_MOVES_W[i][0];
               System.out.println(go_x);
                int go_y = initial_y + POSSIBLE_MOVES_W[i][1];
                System.out.println(go_y);
                if (go_x == x2 && go_y == y2) {

                    if (Board.BOARD[y2][x2].getPiece() == null && initial_x - x2==0 ) {
                        this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        POSSIBLE_MOVES_W[3][1] = 0;
                        return true;
                    } else {
                        if (Board.BOARD[y2][x2].getPiece().getColor() == getColor()) {
                            return false;
                        } else if(initial_x - x2!=0 ){
                            
                            GUI.addImageToScrollPane(x2,y2);
                            Board.BOARD[y2][x2].removePiece();
                            Board.BOARD[y2][x2].setPiece(this);
                            Board.BOARD[initial_y][initial_x].removePiece();
                            this.setPosX(x2);
                            this.setPosY(y2);
                            POSSIBLE_MOVES_W[3][1] = 0;
                            System.out.println("koordinat silindi");
                            return true;
                        }
                    }

                }
            }
          
      
        }
        }
        if(getColor() == 1) {
             if(initial_y == 1){
                System.out.println("siyah piyon girdi loopa");
            POSSIBLE_MOVES_B[3][1] = 2;
            
            }
            System.out.print("evtra koordinbat eklendi");
            for (int i = 0; i < POSSIBLE_MOVES_B.length; i++) {
            for (int j = 0; j < POSSIBLE_MOVES_B[i].length; j++) {

                int go_x = initial_x + POSSIBLE_MOVES_B[i][0];
               // System.out.println(go_x);
                int go_y = initial_y + POSSIBLE_MOVES_B[i][1];
                //System.out.println(go_y);
                if (go_x == x2 && go_y == y2) {

                    if (Board.BOARD[y2][x2].getPiece() == null && initial_x - x2==0) {
                        System.out.println("girdi mi");
                        this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                         POSSIBLE_MOVES_B[3][1] = 0;
                        return true;
                    } else {
                        //System.out.println("girdi mi2");
                        if (Board.BOARD[y2][x2].getPiece().getColor() == getColor()) {
                            return false;
                        } else if (initial_x - x2!=0 ) {
                            
                            GUI.addImageToScrollPane(x2,y2);
                            Board.BOARD[y2][x2].removePiece();
                            Board.BOARD[y2][x2].setPiece(this);
                            Board.BOARD[initial_y][initial_x].removePiece();
                            this.setPosX(x2);
                            this.setPosY(y2);
                             POSSIBLE_MOVES_B[3][1] = 0;
                            return true;
                        }
                    }

                }
            }
        }
         
            
        }
        System.out.println("There is no possible movement");
        return false;
    }

}


