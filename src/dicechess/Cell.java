/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicechess;

import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane{
    private boolean isPossibleDestination;
    private Piece piece;
    private boolean isSelected = false;
    private boolean isChecked;
    private int x,y;
    private final int TILE_SIZE = 80;
    private final Rectangle border;
    private int targetX,targetY;
    protected String cellName;
    private char cellChar;
    
    public Cell(int x,int y){
        cellChar = Character.toUpperCase(Board.alphabet[y]);
        cellName = cellChar + "" + x;
        this.x = x;
        this.y = y;
        border = new Rectangle(TILE_SIZE,TILE_SIZE);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        if(piece != null)
            getChildren().addAll(border,piece);
        else
            getChildren().add(border);
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
        getChildren().add(piece);
    }
    
    public String printPiece() {
        return piece.getName();
    }
    
    public void removePiece() {
        if(piece != null)
            getChildren().remove(piece);
        piece = null;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
    
    public boolean isSelected() {
        return this.isSelected;
    }
  
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
} // Class