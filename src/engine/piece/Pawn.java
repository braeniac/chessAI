package engine.piece;

import engine.utility.Set;
import engine.utility.Colour;
import engine.board.Board;
import engine.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

    private final String name = "P";
    private Set set;
    private int piecePosition;
    private boolean jump;

    //offsets derived from https://en.wikipedia.org/wiki/Pawn_(chess)
    private int[] offsets = {8};

    public Pawn(final int piecePosition, final Set set) {
        this.piecePosition = piecePosition;
        this.set = set;
        jump = false;
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


    //This method calculates and returns a list of legal moves of the PAWN piece
    public List<Integer> legalMoves(Board board) {

        int directionality = directionality();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<offsets.length; i++) {
            //directionality is either -1 (white) or 1 (black)
            int destination = this.piecePosition + (directionality * offsets[i]);
            if (Utility.isValid(destination)) {
                //only allow pawn piece to move up by 1 if there is no enemy piece in destination location
                if (!board.getTile(destination).isOccupied() && offsets[i] == 8) {
                    list.add(destination);
                }




            }

        }

        return list;
    }

    //This method excludes all destination tiles that don't fit the offset rule
    public boolean checkColumnException(final int piecePosition, final int offset) {

        return false;
    }

    //white pawns move up while black pawns move down -- ensures directionality
    public int directionality() {
        if (this.set == Set.WHITE) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name + Colour.RESET;
    }

}
