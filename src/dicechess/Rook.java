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
public class Rook extends Piece {
     public static final int[][] POSSIBLE_MOVES = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0},
    {-1, 0}, {-2, 0}, {-3, 0}, {-4, 0}, {-5, 0}, {-6, 0}, {-7, 0},
    {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7},
    {0, -1}, {0, -2}, {0, -3}, {0, -4}, {0, -5}, {0, -6}, {0, -7}};
    public static final int NUMBER_OF_MOVEMENTS = 28;
    public static final int COLOR_OF_BLACK = 1;
    public static final int COLOR_OF_WHITE = 0;
    public boolean d = true;
    
    public Rook(int color,int type, int posX, int posY, String name, String image_path) {
        super(color,type, posX, posY, name);
        super.setImage(new Image(getClass().getResource(image_path).toExternalForm()));
    }

   /* @Override
    public boolean move(int x2, int y2) {
        
        int initial_x = this.getPosX();
        int initial_y = this.getPosY();

        for (int i = 0; i < POSSIBLE_MOVES.length; i++) {
            for (int j = 0; j < POSSIBLE_MOVES[i].length; j++) {

                int go_x = initial_x + POSSIBLE_MOVES[i][0];
                //System.out.println(go_x);
                int go_y = initial_y + POSSIBLE_MOVES[i][1];
                //System.out.println(go_y);
                
                if (go_x == x2 && go_y == y2) {

                    if (Board.BOARD[y2][x2].getPiece() == null ) {
                                          
                        this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        return true;
                    } else {
                        if (Board.BOARD[y2][x2].getPiece().getColor() == getColor()) {
                            return false;
                        } else {
                            
                            Board.BOARD[y2][x2].removePiece();
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
    }*/
   public boolean move(int x2, int y2) {

        int initial_x = this.getPosX();
        int initial_y = this.getPosY();
        
        int x_dir = 0, y_dir = 0;
        if (y2-initial_y < 0)
            y_dir = -1;
        else if (y2-initial_y > 0)y_dir = 1;
        if (x2-initial_x < 0)
            x_dir = -1;
        else if (x2-initial_x > 0)
             x_dir = 1;

        for (int i = 0; i < POSSIBLE_MOVES.length; i++) {
            for (int j = 0; j < POSSIBLE_MOVES[i].length; j++) {

                int go_x = initial_x + POSSIBLE_MOVES[i][0];
                //System.out.println(go_x);
                int go_y = initial_y + POSSIBLE_MOVES[i][1];
                //System.out.println(go_y);
                int k = initial_y-y2;
                 int k2 = initial_x-x2;
                if (go_x == x2 && go_y == y2) {
                   
                    if (Board.BOARD[y2][x2].getPiece() == null){
                   
                        if(y_dir==-1 && x_dir == 0) {
                        k--;
                    System.out.println("direction doğru");
                        while (d == true && k > 0){
                            if(Board.BOARD[y2+k][x2].getPiece() == null ){
                                System.out.println("y koordinatları kontrol "+ k);
                                k--;
                                System.out.println("taş yok");
                            }else 
                            {  
                                d = false; 
                                System.out.println("taş var");
                            }
                        }
                        if (d == true){
                            System.out.println("oynucak çünkü taş yok");
                         this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        return true;
                        }
                       System.out.println("oynamıcak"); d = true ; return false;
                    }
                     
                     
                       if(y_dir== 1 && x_dir == 0) {
                        k++;
                    System.out.println("direction doğru");
                        while (d == true && k < 0){
                            if(Board.BOARD[initial_y-k][x2].getPiece() == null ){
                                System.out.println("y koordinatları kontrol "+ k);
                                k++;
                                System.out.println("taş yok");
                            }else 
                            {  
                                d = false; 
                                System.out.println("taş var");
                            }
                        }
                        if (d == true){
                            System.out.println("oynucak çünkü taş yok");
                         this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        return true;
                        }
                       System.out.println("oynamıcak"); d = true ; return false;
                    }
                     
                       
                       
                       
                       
                       
                      
                   
                        if(y_dir==0 && x_dir == 1) {
                        k2++;
                    System.out.println("direction doğru");
                        while (d == true && k2 < 0){
                            if(Board.BOARD[y2][initial_x-k2].getPiece() == null ){
                                System.out.println("x koordinatları kontrol "+ k);
                                k2++;
                                System.out.println("taş yok");
                            }else 
                            {  
                                d = false; 
                                System.out.println("taş var");
                            }
                        }
                        if (d == true){
                            System.out.println("oynucak çünkü taş yok");
                         this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        return true;
                        }
                       System.out.println("oynamıcak"); d = true ; return false;
                    }
                        
                        
                        
                        
                        
                        
                           if(y_dir==0 && x_dir == -1) {
                        k2--;
                    System.out.println("direction doğru");
                        while (d == true && k2 > 0){
                            if(Board.BOARD[y2][x2+k2].getPiece() == null ){
                                System.out.println("x koordinatları kontrol "+ k);
                                k2--;
                                System.out.println("taş yok");
                            }else 
                            {  
                                d = false; 
                                System.out.println("taş var");
                            }
                        }
                        if (d == true){
                            System.out.println("oynucak çünkü taş yok");
                         this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        return true;
                        }
                       System.out.println("oynamıcak"); d = true ; return false;
                    }
                     
                     
                     
                     
                     
                      
                       /*if (Board.BOARD[y2][x2].getPiece() == null && x_dir == -1&& y_dir==0  ) {
                            
                        k2--;
                        while (d == true && k2==0){
                            if(Board.BOARD[y2+k2][x2].getPiece() == null )
                                
                                k2++;
                            else d = false;
                        }
                        if (d == true){
                         this.setPosX(x2);
                        this.setPosY(y2);
                        Board.BOARD[y2][x2].setPiece(this);
                        Board.BOARD[initial_y][initial_x].removePiece();
                        return true;
                        }
                        else return false;      
                    
                }*/
                    }else {
                        if (Board.BOARD[y2][x2].getPiece().getColor() == getColor()) {
                            return false;
                        } else {
                            
                            Board.BOARD[y2][x2].removePiece();
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
}