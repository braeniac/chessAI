package engine.piece;

import engine.utility.Set;
import engine.utility.Colour;
import engine.board.Board;
import engine.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Piece {

    private final String name = "N";
    private int piecePosition;
    private Set set;
    private boolean firstMove;

    //offsets derived from https://en.wikipedia.org/wiki/Knight_(chess)
    private final static int[] offsets = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(final int piecePosition, final Set set) {
        this.piecePosition = piecePosition;
        this.set = set;
        this.firstMove = false;
    }

    public void setSet(final Set set) {
        this.set = set;
    }

    public Set getSet() {
        return set;
    }

    public void setPiecePosition(final int piecePosition) {
        this.piecePosition = piecePosition;
    }

    //This method calculates and returns a list of legal moves of the KNIGHT piece
    public List<Integer> legalMoves(final Board board) {

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<offsets.length; i++) {
           int destination = this.piecePosition + offsets[i];
           //if destination is within bounds
           if (Utility.isValid(destination)) {
               //if offset rule breaks down in specified columns
               if (checkColumnException(this.piecePosition, offsets[i])) continue;
               //if destination tile is NOT occupied
               if (!board.getTile(destination).isOccupied()) {
                   list.add(destination);
               } else {
                   //if destination tile IS occupied --is the occupant an enemy piece
                   if (this.set != board.getTile(destination).getPiece().getSet()) {
                       list.add(destination);
                   }
               }
           }
        }
        return list;
    }

    //This method excludes all destination tiles that don't fit the offset rule
    private boolean checkColumnException(final int piecePosition, final int offset) {
        if (Utility.isFirstColumn[piecePosition] && (offset == -17 || offset == -10  || offset == 6 || offset == 15)) {
            return true;
        } else if (Utility.isSecondColumn[piecePosition] && (offset == -10 || offset == 6)) {
            return true;
        } else if (Utility.isSeventhColumn[piecePosition] && (offset == -6 || offset == 10)) {
            return true;
        } else if (Utility.isEighthColumn[piecePosition]  && (offset == -6 || offset == -15 || offset == 17 || offset == -15)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void firstMove() {
        this.firstMove = true;
    }

    public boolean getFirstMove() {
        return this.firstMove;
    }

    public int getPiecePosition() { return piecePosition; }

    public boolean isKing() { return false; }

    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name.toLowerCase() + Colour.RESET;
    }

}