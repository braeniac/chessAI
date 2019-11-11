package engine.piece;

import engine.Colour;
import engine.board.Board;
import engine.board.Move;

import java.util.List;

public class Pawn implements Piece {

    private final String name = "P";
    private Set set;
    private int piecePosition;

    public Pawn(final int piecePosition, final Set set) {
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
    public List<Move> legalMoves(Board board) {
        return null;
    }

    @Override
    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name + Colour.RESET;
    }

}
