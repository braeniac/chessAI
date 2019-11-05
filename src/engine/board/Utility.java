package engine.board;

import engine.piece.Piece;

public class Utility {

    //This method will return a (deep) clone of the existing board
    public static Tile[] getClone(Tile[] board) {
        Tile[] clone = new Tile[board.length];
        for (int i=0; i<clone.length; i++) {
            clone[i] = new Tile(board[i].getCoordinate(), board[i].getPiece());
        }
        return clone;
    } //getClone



}
