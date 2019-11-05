package engine.board;

import engine.piece.*;

public class Board {

    private static final int BOARD_SIZE = 64;
    private Tile[] board;

    //constructor
    public Board() {
        //create the game board
        board = new Tile[BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++) {
            board[i] = new Tile(i);
        }
        setBoard();
    }

    //This method returns the board
    public Tile[] getBoard() {
        return board;
    } //getBoard

    //This sets the initial game board
    private void setBoard() {

        //BLACK pieces
        board[0].setPiece(new Rook());
        board[1].setPiece(new Knight());
        board[2].setPiece(new Bishop());
        board[3].setPiece(new King());
        board[4].setPiece(new Queen());
        board[5].setPiece(new Bishop());
        board[6].setPiece(new Knight());
        board[7].setPiece(new Rook());
        board[8].setPiece(new Pawn());
        board[9].setPiece(new Pawn());
        board[10].setPiece(new Pawn());
        board[11].setPiece(new Pawn());
        board[12].setPiece(new Pawn());
        board[13].setPiece(new Pawn());
        board[14].setPiece(new Pawn());
        board[15].setPiece(new Pawn());

        //set alliance -- BLACK
        for (int i=0; i<=15; i++) {
            board[i].getPiece().setAlliance(Alliance.BLACK);
        }


        //WHITE pieces
        board[48].setPiece(new Pawn());
        board[49].setPiece(new Pawn());
        board[50].setPiece(new Pawn());
        board[51].setPiece(new Pawn());
        board[52].setPiece(new Pawn());
        board[53].setPiece(new Pawn());
        board[54].setPiece(new Pawn());
        board[55].setPiece(new Pawn());
        board[56].setPiece(new Rook());
        board[57].setPiece(new Knight());
        board[58].setPiece(new Bishop());
        board[59].setPiece(new King());
        board[60].setPiece(new Queen());
        board[61].setPiece(new Bishop());
        board[62].setPiece(new Knight());
        board[63].setPiece(new Rook());

        //set alliance -- WHITE
        for (int i=48; i<=63; i++) {
            board[i].getPiece().setAlliance(Alliance.WHITE);
        }

    }

    //This method prints the board to the console
    public void print() {
        int x = 1;
        int y = 0;
        System.out.println("+---+---+---+---+---+---+---+---+");
        for (int i=0; i<board.length; i++) {
            if (board[i].getPiece() == null) {
                System.out.print("| " + " " + " ");
            } else {
                System.out.print("| " + board[i].getPiece().toString() + " ");
            }
            if (i == ((7 * x) + y) && i>1) {
                System.out.println("|" + "  " + x);
                System.out.println("+---+---+---+---+---+---+---+---+");
                x++;
                y++;
            }
        }
        System.out.println("  a   b   c   d   e   f   g   h");
    }

}