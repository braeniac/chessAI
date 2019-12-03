package engine.utility;

import engine.board.Board;
import engine.piece.Piece;
import engine.player.Player;

import java.util.List;

public class Check {

    //This method validates possible move
    public static boolean validate(final Player player, final Board board, final int start, final int end)  {

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


    public static boolean hasWinningMove() {

        return false;
    }


}
