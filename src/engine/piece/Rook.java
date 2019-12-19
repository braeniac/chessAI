package engine.piece;

import engine.utility.Set;
import engine.utility.Colour;
import engine.board.Board;
import engine.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {

    private final String name = "R";
    private Set set;
    private int piecePosition;
    private boolean firstMove;

    //offsets derived from https://en.wikipedia.org/wiki/Rook_(chess)
    private final static int[] offsets = {-8, -1, 1, 8};


    public Rook(final int piecePosition, final Set set) {
        this.piecePosition = piecePosition;
        this.set = set;
        this.firstMove = false;
    }

    public void setPiecePosition(final int piecePosition) {
        this.piecePosition = piecePosition;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Set getSet() {
        return set;
    }

    //This method calculates and returns a list of legal moves of the ROOK piece
    public List<Integer> legalMoves(Board board) {

        int destination;
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<offsets.length; i++) {
            destination = this.piecePosition;
            //keep adding offset to current piece position until we reach an invalid destination coordinate
            while(Utility.isValid(destination)) {
                destination += offsets[i];
                if(Utility.isValid(destination)) {
                    //exceptions
                    if (checkColumnException(this.piecePosition, offsets[i])) continue;
                    //if the tile is empty -- non-attacking move
                    if (!board.getTile(destination).isOccupied()) {
                        list.add(destination);
                    } else {
                        //if the upcoming tile has an enemy piece -- attacking move
                        if (this.set != board.getTile(destination).getPiece().getSet()) {
                            list.add(destination);
                        }
                        break;
                    }
                }
            }
        }
        return list;
    }

    //This method excludes all destination tiles that don't fit the offset rule
    private boolean checkColumnException(final int piecePosition, final int offset) {
        if (Utility.isFirstColumn[piecePosition] && (offset == -1)) {
            return true;
        } else if (Utility.isEighthColumn[piecePosition] & (offset == 1)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean getFirstMove() {
        return this.firstMove;
    }

    public void firstMove() {
        this.firstMove = true;
    }

    public int getPiecePosition() { return piecePosition; }

    public boolean isKing() { return false; }

    public boolean isRook() {
        return true;
    }

    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name.toLowerCase() + Colour.RESET;
    }

}

