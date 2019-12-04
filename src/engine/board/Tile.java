package engine.board;

import engine.piece.Piece;

public class Tile {

    //between 0 to 63
    private int coordinate;

    //could be king, queen, bishop, knight, rook, pawn, ' ' represented as x
    private Piece piece;

    //constructor
    public Tile(final int coordinate) {
        this.coordinate = coordinate;
        this.piece = null;
    }

    //constructor
    public Tile(final int coordinate, final Piece piece) {
        this(coordinate);
        this.piece = piece;
    }

    //This method returns the tile coordinate
    public int getCoordinate() {
        return coordinate;
    }

    //This method returns the piece object
    public Piece getPiece() {
        return this.piece;
    }

    //This method checks to see if tile is occupied
    public boolean isOccupied() {
         if (this.piece != null) {
             return true;
         } else {
             return false;
         }
    }

    public void removePiece() {
        piece = null;
    }

    //This method sets piece to tile
    public void setPiece(final Piece piece) {
        this.piece = piece;
    }

}