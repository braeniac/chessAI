package engine.piece;

import engine.utility.Set;
import engine.utility.Colour;
import engine.board.Board;
import engine.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class King implements Piece {

    private final String name = "K";
    private Set set;
    private int piecePosition;
    private boolean firstMove;

    //offsets derived from https://en.wikipedia.org/wiki/King_(chess)
    private final static int[] offsets = {-9, -8, -7, -1, 1, 7, 8, 9};

    public King(final int piecePosition, final Set set) {
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

    //This method calculates and returns a list of legal moves of the KING piece
    public List<Integer> legalMoves(Board board) {

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
        if (Utility.isFirstColumn[piecePosition] && (offset == -9 || offset == 7 || offset == -1)) {
            return true;
        } else if (Utility.isEighthColumn[piecePosition] & (offset == -7 || offset == 1 || offset == 9)) {
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

    public boolean isKing() { return true; }

    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name.toLowerCase() + Colour.RESET;
    }
}
