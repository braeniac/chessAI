package engine.player;

import engine.board.Board;
import engine.board.Move;
import engine.piece.Piece;
import engine.utility.Set;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private Set set;
    private String name;
    private List<Piece> opponentPieces;

    public Player(final Set set, final String name) {
        this.set = set;
        this.name = name;
        opponentPieces = new ArrayList<>();
    }

    public void makeMove(final Board board, final int start, final int end) {
        //if destination tile has enemy piece
        if (board.getTile(end).isOccupied()) {
            //attacking move
            Move.attackingMove(board, this, start, end);
        } else {
            //non attacking move
            Move.nonAttackingMove(board, start, end);
        }
    }

    public void updateOpponentPieces(final Piece opponentPiece) {
        opponentPieces.add(opponentPiece);
    }

    public List<Piece> getOpponentPieces() {
        return this.opponentPieces;
    }

    public String getName() {
        return this.name;
    }

    public Set getSet() {
        return this.set;
    }

}
