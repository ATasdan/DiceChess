package dicechess;

import javafx.scene.image.Image;

public class King extends Piece {

    private static final int[][] POSSIBLE_MOVES = {{1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {0, 1}, {0, -1}, {-1, -1},
    {1, -1}};
    private static final int NUMBER_OF_MOVEMENTS = 8;
    private static final int COLOR_OF_BLACK = 1;
    private static final int COLOR_OF_WHITE = 0;

    public King(int color,int type, int posX, int posY, String name, String image_path) {
        super(color,type, posX, posY, name);
        super.setImage(new Image(getClass().getResource(image_path).toExternalForm()));
    }

    @Override
    public boolean move(int x2, int y2) {

        int initial_x = this.getPosX();
        int initial_y = this.getPosY();

        for (int i = 0; i < POSSIBLE_MOVES.length; i++) {
            for (int j = 0; j < POSSIBLE_MOVES[i].length; j++) {

                int go_x = initial_x + POSSIBLE_MOVES[i][0];
                // System.out.println(go_x);
                int go_y = initial_y + POSSIBLE_MOVES[i][1];
                //System.out.println(go_y);
                if (go_x == x2 && go_y == y2) {

                    if (Board.BOARD[y2][x2].getPiece() == null) {
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
    }
}
