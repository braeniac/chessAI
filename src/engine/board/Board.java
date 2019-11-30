package engine.board;

import engine.utility.Set;
import engine.piece.*;
import engine.utility.Colour;

import java.util.List;

public class Board {

    private static final int BOARD_SIZE = 64;
    private Tile[] board;

    public Board() {
        //create the game board
        board = new Tile[BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++) {
            board[i] = new Tile(i);
        }
        setBoard();
    } //constructor

    //This method returns the board
    public Tile[] getBoard() {
        return board;
    }

    //This method returns the size of the board
    public int size() {
        return BOARD_SIZE;
    }

    //This method returns the Tile at given coordinate
    public Tile getTile(final int coordinate) {
        return board[coordinate];
    }

    //This sets the initial game board
    private void setBoard() {

        //BLACK pieces
        board[0].setPiece(new Rook(0, Set.BLACK));
        board[1].setPiece(new Knight(1, Set.BLACK));
        board[2].setPiece(new Bishop(2, Set.BLACK));
        board[3].setPiece(new King(3, Set.BLACK));
        board[4].setPiece(new Queen(4, Set.BLACK));
        board[5].setPiece(new Bishop(5, Set.BLACK));
        board[6].setPiece(new Knight(6, Set.BLACK));
        board[7].setPiece(new Rook(7, Set.BLACK));
        board[8].setPiece(new Pawn(8, Set.BLACK));
        board[9].setPiece(new Pawn(9, Set.BLACK));
        board[10].setPiece(new Pawn(10, Set.BLACK));
        board[11].setPiece(new Pawn(11, Set.BLACK));
        board[12].setPiece(new Pawn(12, Set.BLACK));
        board[13].setPiece(new Pawn(13, Set.BLACK));
        board[14].setPiece(new Pawn(14, Set.BLACK));
        board[15].setPiece(new Pawn(15, Set.BLACK));

        //WHITE pieces
        board[48].setPiece(new Pawn(48, Set.WHITE));
        board[49].setPiece(new Pawn(49, Set.WHITE));
        board[50].setPiece(new Pawn(50, Set.WHITE));
        board[51].setPiece(new Pawn(51, Set.WHITE));
        board[52].setPiece(new Pawn(52, Set.WHITE));
        board[53].setPiece(new Pawn(53, Set.WHITE));
        board[54].setPiece(new Pawn(54, Set.WHITE));
        board[55].setPiece(new Pawn(55, Set.WHITE));
        board[56].setPiece(new Rook(56, Set.WHITE));
        board[57].setPiece(new Knight(57, Set.WHITE));
        board[58].setPiece(new Bishop(58, Set.WHITE));
        board[59].setPiece(new King(59, Set.WHITE));
        board[60].setPiece(new Queen(60, Set.WHITE));
        board[61].setPiece(new Bishop(61, Set.WHITE));
        board[62].setPiece(new Knight(62, Set.WHITE));
        board[63].setPiece(new Rook(63, Set.WHITE));

    } //setBoard

    //This method prints the board to the console
    public void print() {

        int x = 1;
        int y = 0;
        System.out.println();
        System.out.println(Colour.GREEN + "a b c d e f g h\n" + Colour.RESET);
        for (int i=0; i<board.length; i++) {
            if (board[i].getPiece() == null) {
                System.out.print("x" + " ");
            } else {
                System.out.print( board[i].getPiece().toString() + " ");
            }
            if (i == ((7 * x) + y) && i>1) {
                System.out.println("  " + Colour.GREEN + x + Colour.RESET);
                x++;
                y++;
            }
        }
        System.out.println(Colour.GREEN + "\na b c d e f g h\n" + Colour.RESET);
    }

}