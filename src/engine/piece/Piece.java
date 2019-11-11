package engine.piece;

import engine.board.Move;
import engine.board.Board;
import java.util.List;

public interface Piece {
    void setSet(final Set set);
    void setPiecePosition(final int piecePosition);
    List<Move> legalMoves(final Board board);
    String toString();
}
