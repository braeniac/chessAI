package engine.board;

import engine.piece.Piece;
import engine.player.Player;

public class Move {

    //This method is an non attacking move
    public static void nonAttackingMove(final Board board, final int start, final int end) {
        Tile startTile  = board.getTile(start);
        Tile endTile = board.getTile(end);
        Piece myPiece = board.getTile(start).getPiece();
        startTile.removePiece();
        endTile.setPiece(myPiece);
        myPiece.setPiecePosition(end);
    }


    //This method is an attacking move
    public static void attackingMove(final Board board, final Player player, final int start, final int end) {
        Tile startTile = board.getTile(start);
        Tile endTile = board.getTile(end);
        Piece myPiece = startTile.getPiece();
        Piece opponentPiece = endTile.getPiece();
        startTile.removePiece();
        endTile.setPiece(myPiece);
        myPiece.setPiecePosition(end);
        player.updateOpponentPieces(opponentPiece);
    }

}
