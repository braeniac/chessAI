package engine.board;

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
    public void setBoard(final List<Piece> blackPieces, final List<Piece> whitePieces) {

        for (int i=0; i<blackPieces.size(); i++) {
            board[i].setPiece(blackPieces.get(i));
        }

        for (int i=0; i<whitePieces.size(); i++) {
            board[48+i].setPiece(whitePieces.get(i));
        }

    } //setBoard

    public void setCloneBoard(final Tile[] board) {
        this.board = board;
    }

    //This method prints the board to the console
    public void print() {

        int x = 1;
        int y = 0;
        System.out.println();
        System.out.println(Colour.GREEN + "a  b  c  d  e  f  g  h\n" + Colour.RESET);
        for (int i=0; i<board.length; i++) {
            if (board[i].getPiece() == null) {
                System.out.print("-" + "  ");
            } else {
                System.out.print(board[i].getPiece().toString() + "  ");
            }
            if (i == ((7 * x) + y) && i>1) {
                System.out.println("  " + Colour.GREEN + x + Colour.RESET);
                x++;
                y++;
            }
        }
        System.out.println(Colour.GREEN + "\na  b  c  d  e  f  g  h\n" + Colour.RESET);
    }

}