package engine.player;

import engine.board.Board;
import engine.board.Move;
import engine.piece.King;
import engine.piece.Piece;
import engine.utility.Set;

import java.util.List;

public abstract class Player {

    //This method makes move
    public void makeMove(final Board board, final Player opponent, final int start, final int end) {
        //if destination tile has enemy piece
        if (board.getTile(end).isOccupied()) {
            //attacking move
            Move.attackingMove(board,this, opponent, start, end);
        } else {
            //non attacking move
            Move.nonAttackingMove(board, start, end);
        }
    }

    public abstract Set getSet();
    public abstract String getName();
    public abstract List<Piece> getPieces();
    public abstract List<Piece> getOpponentPieces();
    public abstract void acquirePiece(final Piece piece);
    public abstract void update(final Piece piece);
    public abstract King getPlayerKing();

}
