package engine.board;

import engine.piece.*;
import engine.player.Player;
import engine.utility.Set;
import engine.utility.Utility;

import java.util.Scanner;

public class Move {

    //This method is an non attacking move
    public static void nonAttackingMove(final Board board, final int start, final int end) {

        Tile startTile  = board.getTile(start);
        Tile endTile = board.getTile(end);
        Piece myPiece = board.getTile(start).getPiece();

        //remove piece from start location
        startTile.removePiece();

        if (Utility.isFirstRow[end] && myPiece.getSet() == Set.WHITE && myPiece.getName() == "P"
                || Utility.isEighthRow[end] && myPiece.getSet() == Set.BLACK && myPiece.getName() == "P") {
            pawnPromotion(myPiece, end, endTile);
        } else {
            //set this piece to destination location
            endTile.setPiece(myPiece);
            myPiece.setPiecePosition(end);
        }

        //if piece moves for the very first time -- mark it
        if (!myPiece.getFirstMove()) {
            myPiece.firstMove();
        }

    }

    //This method is an attacking move
    public static void attackingMove(final Board board, final Player player, final Player opponent, final int start, final int end) {

        Tile startTile = board.getTile(start);
        Tile endTile = board.getTile(end);
        Piece myPiece = startTile.getPiece();
        Piece opponentPiece = endTile.getPiece();

        //remove piece from start location
        startTile.removePiece();

        if (Utility.isFirstRow[end] && myPiece.getSet() == Set.WHITE && myPiece.getName() == "P"
                || Utility.isEighthRow[end] && myPiece.getSet() == Set.BLACK && myPiece.getName() == "P") {
            pawnPromotion(myPiece, end, endTile);
        } else {
            //set this piece to destination location
            endTile.setPiece(myPiece);
            myPiece.setPiecePosition(end);
        }

        //opponent loses piece -- remove piece from list of pieces
        opponent.update(opponentPiece);
        //player acquires opponent piece
        player.acquirePiece(opponentPiece);

        //if piece moves for the very first time -- mark it
        if (!myPiece.getFirstMove()) {
            myPiece.firstMove();
        }

    }

    //This method allows for pawn promotion
    private static void pawnPromotion(final Piece myPiece, final int end, final Tile endTile) {
        Scanner in = new Scanner(System.in);
        System.out.print("Yippeee! What should i become? (Q, R, N, B) ");
        String input = in.nextLine().toUpperCase();
        switch (input) {
            case "Q": {
                endTile.setPiece(new Queen(end, myPiece.getSet()));
                break;
            }
            case "R": {
                endTile.setPiece(new Rook(end, myPiece.getSet()));
                break;
            }
            case "N": {
                endTile.setPiece(new Knight(end, myPiece.getSet()));
                break;
            }
            case "B": {
                endTile.setPiece(new Bishop(end, myPiece.getSet()));
                break;
            }
        }
    }


}
