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



public class Board {

    private static final int SIZE_X = 8;
    private static final int SIZE_Y = 8;
    protected static Cell[][] BOARD = new Cell[SIZE_X][SIZE_Y];
    private static boolean cellSelected = false;
    private static int oldX,oldY;
    protected static King bk;
    protected static King wk;
    protected static char[] alphabet = "abcdefgh".toCharArray();

    public static void initalizeBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BOARD[i][j] = new Cell(j,i);
                if((i+j)%2==0)
                    BOARD[i][j].setId("bisqueCell");
                else
                    BOARD[i][j].setId("blackCell");
                
            }
        }
        Pawns bp1 = new Pawns(1,1,0,1,"bp1","Images/bp.png");
        Pawns bp2 = new Pawns(1,1,1,1,"bp2","Images/bp.png");
        Pawns bp3 = new Pawns(1,1,2,1,"bp3","Images/bp.png");
        Pawns bp4 = new Pawns(1,1,3,1,"bp4","Images/bp.png");
        Pawns bp5 = new Pawns(1,1,4,1,"bp5","Images/bp.png");
        Pawns bp6 = new Pawns(1,1,5,1,"bp6","Images/bp.png");
        Pawns bp7 = new Pawns(1,1,6,1,"bp7","Images/bp.png");
        Pawns bp8 = new Pawns(1,1,7,1,"bp8","Images/bp.png");
        Rook br1 = new Rook(1,4,0,0,"br1","Images/br.png");
        Rook br2 = new Rook(1,4,7,0,"br1","Images/br.png");
        Knights bn1 = new Knights(1,2,1,0,"bk1","Images/bn.png");
        Knights bn2 = new Knights(1,2,6,0,"bk2","Images/bn.png");
        Bishops bb1 = new Bishops(1,3,2,0,"bb1","Images/bb.png");
        Bishops bb2 = new Bishops(1,3,5,0,"bb2","Images/bb.png");
        bk = new King(1,6,3,0,"bk","Images/bk.png");
        Queen bq = new Queen(1,5,4,0,"bq","Images/bq.png");
        
        Pawns wp1 = new Pawns(0,1,1,6,"wp1","Images/wp.png");
        Pawns wp2 = new Pawns(0,1,2,6,"wp2","Images/wp.png");
        Pawns wp3 = new Pawns(0,1,3,6,"wp3","Images/wp.png");
        Pawns wp4 = new Pawns(0,1,4,6,"wp4","Images/wp.png");
        Pawns wp5 = new Pawns(0,1,5,6,"wp5","Images/wp.png");
        Pawns wp6 = new Pawns(0,1,6,6,"wp6","Images/wp.png");
        Pawns wp7 = new Pawns(0,1,7,6,"wp7","Images/wp.png");
        Pawns wp8 = new Pawns(0,1,0,6,"wp8","Images/wp.png");
        Rook wr1 = new Rook(0,4,0,7,"wr1","Images/wr.png");
        Rook wr2 = new Rook(0,4,7,7,"wr1","Images/wr.png");
        Knights wn1 = new Knights(0,2,1,7,"White Knight 1","Images/wn.png");
        Knights wn2 = new Knights(0,2,6,7,"White Knight 2","Images/wn.png");
        Bishops wb1 = new Bishops(0,3,5,7,"wb1","Images/wb.png");
        Bishops wb2 = new Bishops(0,3,2,7,"wb2","Images/wb.png");
        wk = new King(0,6,4,7,"wk","Images/wk.png");
        Queen wq = new Queen(0,5,3,7,"wq","Images/wq.png");
    }

    public static void printBoard() {

        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[i].length; j++) {
                if (BOARD[i][j].getPiece() == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + BOARD[i][j].printPiece() + "]");
                }
            }
            System.out.println();
        }

    }

    public static Cell getCell(int x, int y) {
        return BOARD[x][y];
    }

    public static Cell[][] getBOARD() {
        return BOARD;
    }

    public static void changeCell(Cell cell,int i,int j) {
        BOARD[i][j] = cell;
    }

    public static boolean isCellSelected() {
        return cellSelected;
    }

    public static void setCellSelected(boolean cellSelected) {
        Board.cellSelected = cellSelected;
    }

    public static int getOldX() {
        return oldX;
    }

    public static void setOldX(int oldX) {
        Board.oldX = oldX;
    }

    public static int getOldY() {
        return oldY;
    }

    public static void setOldY(int oldY) {
        Board.oldY = oldY;
    }

}