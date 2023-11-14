package engine.utility;

import engine.board.Board;
import engine.piece.Piece;
import engine.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Check {

    //This method validates possible move
    public static boolean isMoveLegal(final Player player, final Board board, final int start, final int end)  {

        //if the tile at start position does NOT have a piece -- return false
        //can't move an empty piece from position start to position end
        if (!board.getTile(start).isOccupied()) {
            return false;
        }

        Piece piece = board.getTile(start).getPiece();
        List<Integer> possibleMoves = piece.legalMoves(board);

        //is the piece that is requested to move from start to end a piece that belongs to the player
        //is the set of the player (black or white) the same as the set of the piece (black or white)
        boolean isMyPiece = false;
        if (piece.getSet() == player.getSet()) {
            isMyPiece = true;
        }

        //is the request move apart of the list of legal moves said piece is able to make
        boolean legalMove = false;
        for (int i=0; i<possibleMoves.size(); i++) {
            if (possibleMoves.get(i) == end) {
                legalMove = true;
            }
        }

        return (isMyPiece && legalMove);
    }

    //This method checks to see if players king is in check
    public static boolean isInCheck(final Player player, final Player opponent, final Board board) {

        //get the position of the king
        int kingPosition = player.getPlayerKing().getPiecePosition();

        //get opponents active pieces
        List<Piece> activePieces = opponent.getPieces();

        //get legal moves for all active pieces
        List<Integer> allLegalMoves = new ArrayList<>();
        for (int i=0; i<activePieces.size(); i++) {
            allLegalMoves.addAll(activePieces.get(i).legalMoves(board));
        }

        //if not empty then the players king is in check
        return legalAttackingMoves(kingPosition, allLegalMoves);
    }

    //Helper method --
    private static boolean legalAttackingMoves(final int kingPosition, final List<Integer> allLegalMoves) {
        for (int i=0; i<allLegalMoves.size(); i++) {
            if (kingPosition == allLegalMoves.get(i)) {
                return true;
            }
        }
        return false;
    }

    //This method checks if game board is in stale mate
    public static boolean isInStaleMate(final Player current, final Player opponent, final Board board) {
        if (isInCheck(current, opponent, board) && !kingUnableToEscape()) {
//            return true;
        }
        return false;
    }


    //This method checks if the game board is in check mate
    public static boolean isInCheckMate(final Player current, final Player opponent, final Board board) {
        if (isInCheck(current, opponent, board) && kingUnableToEscape()) {
//            return true;
        }
        return false;
    }

    //Helper method --
    private static boolean kingUnableToEscape() {

        return true;
    }

}
