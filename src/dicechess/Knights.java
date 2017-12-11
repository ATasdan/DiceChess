package dicechess;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Knights extends Piece {

    protected static final int[][] POSSIBLE_MOVES = {{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, -1}, {2, 1}};
    private static final int MAX_MOVEMENTS = 8;
    private static final int BLACK = 1;
    private static final int WHITE = 0;

    public Knights(int color,int type, int posX, int posY, String name) {
        super(color,type, posX, posY, name);
    }

    public Knights(int color,int type, int posX, int posY, String name, String image_path) {
        super(color,type ,posX, posY, name);
        super.setImage(new Image(getClass().getResource(image_path).toExternalForm()));

    }

    @Override
    public boolean move(int x, int y) {

        ArrayList<Cell> possibleCells = possibleCells();

        for (int i = 0; i < possibleCells.size(); i++) {

            if (possibleCells.get(i).getX() == x && possibleCells.get(i).getY() == y) {
                Board.BOARD[y][x].setPiece(this);
                Board.BOARD[this.getPosY()][this.getPosX()] = null;
                return true;
            }

        }

        return false;

    }

    public ArrayList possibleCells() {

        ArrayList<Cell> possibleCells = new ArrayList<>(); 
        int count = 0;

        for (int i = 0; i < POSSIBLE_MOVES.length; i++) {

            int destX = this.getPosX() + POSSIBLE_MOVES[i][0];
            int destY = this.getPosY() + POSSIBLE_MOVES[i][1];

            if ((destX < 8 && destX >= 0) && (destY < 8 && destY >= 0)) {
                if (Board.BOARD[destY][destX].getPiece() == null) {
                    System.out.println("added");
                    possibleCells.add(new Cell(destY, destX));
                } else if (Board.BOARD[destY][destX].getPiece().getColor() != this.getColor()) {
                    System.out.println("added");
                    possibleCells.add(new Cell(destY, destX));
                }
            }

        }

        return possibleCells;

    }

}
