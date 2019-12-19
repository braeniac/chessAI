package engine.player.AI;

import engine.board.Board;
import engine.piece.Piece;
import engine.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlphaBeta {


    //This method returns a random move using the start,end format
    public int[] makeMove(final Player player, final Board board) {
        //TODO minimax with alpha beta pruning
        List<Piece> activePieces = new ArrayList<>();
        //add all pieces capable of legal moves to active pieces
        for (Piece piece : player.getPieces()) {
            if (piece.legalMoves(board).size() > 0) {
                activePieces.add(piece);
            }
        }
        Piece piece = activePieces.get(index(activePieces));
        int start = piece.getPiecePosition();
        int end = getDestination(piece.legalMoves(board));
        int[] fromTo = new int[2];
        fromTo[0] = start;
        fromTo[1] = end;
        return fromTo;
    }

    //Helper method returns start piece position
    private int index(final List<Piece> activePieces) {
        int n = new Random().nextInt(activePieces.size());
        return n;
    }

    //Helper method returns destination position
    private int getDestination(final List<Integer> legalMoves) {
        return legalMoves.get(new Random().nextInt(legalMoves.size()));
    }
}
