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


import javafx.scene.image.ImageView;

public abstract class Piece extends ImageView{
    private int color;
    private String name;
    private boolean avalibility;
    private int posX,posY;
    private int mouseX,mouseY;
    private double oldX,oldY;
    private final int type;
    
    
    public Piece(int color,int type,int posX,int posY,String name){
        this.name = name;
        this.type = type;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
        oldX = posX * 80 + 640;
        oldY = posY * 80 + 220;
        Board.getBOARD()[posY][posX].setPiece(this);
        setOnMousePressed(e -> {
            mouseX = (int) (e.getSceneX()-320)/80;
            mouseY = (int) (e.getSceneY()-80)/80;
           
        });
        setOnMouseReleased(e -> {
            int targetX = (int) (e.getSceneX()-320)/80;
            int targetY = (int) (e.getSceneY()-80)/80;
            System.out.println("X: " + getPosX() + " to " + targetX + "\nY: " + getPosY() + " to " + targetY + "\n-----------------");
            if(GUI.turn == color && (Controller.result1 == type || Controller.result2 == type || Controller.result1 == Controller.result2)){
                if(move(targetX,targetY)){
                    if(color == 0){
                        GUI.turn = 1;
                        GUI.whiteTimer.running = false;
                        GUI.blackTimer.running = true;
                        GUI.dice1.color = 1;
                        GUI.dice2.color = 1;
                    }
                    else{
                        GUI.turn = 0;
                        GUI.blackTimer.running = false;
                        GUI.whiteTimer.running = true;
                        GUI.dice1.color = 0;
                        GUI.dice2.color = 0;
                    }
                    GUI.dice1.randomNumber = -1;
                    GUI.dice1.setImage(null);
                    GUI.dice2.randomNumber = -1;
                    GUI.dice2.setImage(null);
                    GUI.moveHistory.setText(GUI.moveHistory.getText() + "\n" + this.name + " --> "  + Board.getBOARD()[posX][posY].cellName + " to " + Board.getBOARD()[targetX][targetY].cellName);
                }
            }
        });
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public void setPosY(int y) {
        this.posY = y;
    }

    public abstract boolean move(int x, int y);

}