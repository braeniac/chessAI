package engine.player;

import engine.piece.*;
import engine.utility.Set;

import java.util.ArrayList;
import java.util.List;

public class BlackPlayer extends Player {

    private static BlackPlayer SINGLE_INSTANCE = null;

    private Set set;
    private String name;
    private List<Piece> blackPieces;
    private List<Piece> opponentPieces;
    private King playerKing;

    private BlackPlayer() {
        this.set = Set.BLACK;
        this.name = "AI";
        //complete set of black pieces
        this.blackPieces = blackPieces();
        //complete set of white pieces -- empty at this point
        this.opponentPieces = new ArrayList<>();
        //establish player king
        this.playerKing = (King) establishKing();
    }

    public static BlackPlayer getInstance() {
        if (SINGLE_INSTANCE == null) {
            SINGLE_INSTANCE = new BlackPlayer();
        }
        return SINGLE_INSTANCE;
    }

    public List<Piece> getPieces() {
        return this.blackPieces;
    }

    public List<Piece> getOpponentPieces() {
        return this.opponentPieces;
    }

    public Set getSet() {
        return this.set;
    }

    public String getName() {
        return this.name;
    }

    public void acquirePiece(final Piece piece) {
        opponentPieces.add(piece);
    }

    public void update(final Piece piece) {
        blackPieces.remove(piece);
    }

    public King getPlayerKing () {
        return this.playerKing;
    }

    private List<Piece> blackPieces() {

        Rook   LBRook   = new Rook  (0, Set.BLACK);
        Knight LBKnight = new Knight(1, Set.BLACK);
        Bishop LBBishop = new Bishop(2, Set.BLACK);
        King   BKing    = new King  (3, Set.BLACK);
        Queen  BQueen   = new Queen (4, Set.BLACK);
        Bishop RBBishop = new Bishop(5, Set.BLACK);
        Knight RBKnight = new Knight(6, Set.BLACK);
        Rook   RBRook   = new Rook  (7, Set.BLACK);

        Pawn APawn = new Pawn(8,  Set.BLACK);
        Pawn BPawn = new Pawn(9,  Set.BLACK);
        Pawn CPawn = new Pawn(10, Set.BLACK);
        Pawn DPawn = new Pawn(11, Set.BLACK);
        Pawn EPawn = new Pawn(12, Set.BLACK);
        Pawn FPawn = new Pawn(13, Set.BLACK);
        Pawn GPawn = new Pawn(14, Set.BLACK);
        Pawn HPawn = new Pawn(15, Set.BLACK);

        blackPieces = new ArrayList<>();

        blackPieces.add(LBRook);
        blackPieces.add(LBKnight);
        blackPieces.add(LBBishop);
        blackPieces.add(BKing);
        blackPieces.add(BQueen);
        blackPieces.add(RBBishop);
        blackPieces.add(RBKnight);
        blackPieces.add(RBRook);
        blackPieces.add(APawn);
        blackPieces.add(BPawn);
        blackPieces.add(CPawn);
        blackPieces.add(DPawn);
        blackPieces.add(EPawn);
        blackPieces.add(FPawn);
        blackPieces.add(GPawn);
        blackPieces.add(HPawn);

        return blackPieces;
    }

    private Piece establishKing() {
        Piece temp = null;
        for (Piece piece : blackPieces) {
            if (piece.isKing()) {
                temp = piece;
            }
        }
        return temp;
    }


}
