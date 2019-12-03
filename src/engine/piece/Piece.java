package engine.piece;

import engine.utility.Set;
import engine.board.Board;
import java.util.List;

public interface Piece {
    void setSet(final Set set);
    Set getSet();
    void setPiecePosition(final int piecePosition);
    List<Integer> legalMoves(final Board board);
    String toString();
    String getName();
    void firstMove();
    boolean getFirstMove();
}
