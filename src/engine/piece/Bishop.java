package engine.piece;

import engine.utility.Set;
import engine.utility.Colour;
import engine.board.Board;

import java.util.List;

public class Bishop implements Piece {

    private final String name = "B";
    private Set set;
    private int piecePosition;

    //offsets derived from https://en.wikipedia.org/wiki/B_(chess)
    private final static int[] offsets = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Bishop(final int piecePosition, final Set set) {
        this.piecePosition = piecePosition;
        this.set = set;
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


    public List<Integer> legalMoves(Board board) {





        return null;
    }

    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name + Colour.RESET;
    }

}
