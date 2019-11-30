package engine.piece;

import engine.utility.Set;
import engine.utility.Colour;
import engine.board.Board;

import java.util.List;

public class King implements Piece {

    private final String name = "K";
    private Set set;
    private int piecePosition;

    public King(final int piecePosition, final Set set) {
        this.piecePosition = piecePosition;
        this.set = set;
    }

    @Override
    public void setPiecePosition(final int piecePosition) {
        this.piecePosition = piecePosition;
    }

    @Override
    public void setSet(Set set) {
        this.set = set;
    }

    @Override
    public Set getSet() {
        return set;
    }

    @Override
    public List<Integer> legalMoves(Board board) {
        return null;
    }

    @Override
    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name + Colour.RESET;
    }



}
