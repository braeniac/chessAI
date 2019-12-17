package engine.player;
import engine.piece.*;
import engine.utility.Set;

import java.util.ArrayList;
import java.util.List;

public class WhitePlayer extends Player {

    private static WhitePlayer SINGLE_INSTANCE = null;

    private Set set;
    private String name;
    private List<Piece> whitePieces;
    private List<Piece> opponentPieces;
    private King playerKing;

    private WhitePlayer() {
        this.set = Set.WHITE;
        this.name = "human";
        //complete set of white pieces
        this.whitePieces = whitePieces();
        //complete set of black pieces -- empty at this point
        this.opponentPieces = new ArrayList<>();
        //establish player king
        this.playerKing = (King) establishKing();
    }

    public static WhitePlayer getInstance() {
        if (SINGLE_INSTANCE == null) {
            SINGLE_INSTANCE = new WhitePlayer();
        }
        return SINGLE_INSTANCE;
    }

    public List<Piece> getPieces() {
        return this.whitePieces;
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
        whitePieces.remove(piece);
    }

    public King getPlayerKing() {
        return playerKing;
    }

    private List<Piece> whitePieces() {

        Pawn APawn = new Pawn(48, Set.WHITE);
        Pawn BPawn = new Pawn(49, Set.WHITE);
        Pawn CPawn = new Pawn(50, Set.WHITE);
        Pawn DPawn = new Pawn(51, Set.WHITE);
        Pawn EPawn = new Pawn(52, Set.WHITE);
        Pawn FPawn = new Pawn(53, Set.WHITE);
        Pawn GPawn = new Pawn(54, Set.WHITE);
        Pawn HPawn = new Pawn(55, Set.WHITE);

        Rook   LWRook   = new Rook  (56, Set.WHITE);
        Knight LWKnight = new Knight(57, Set.WHITE);
        Bishop LWBishop = new Bishop(58, Set.WHITE);
        King   WKing    = new King  (59, Set.WHITE);
        Queen  WQueen   = new Queen (60, Set.WHITE);
        Bishop RWBishop = new Bishop(61, Set.WHITE);
        Knight RWKnight = new Knight(62, Set.WHITE);
        Rook   RWRook   = new Rook  (63, Set.WHITE);

        whitePieces = new ArrayList<>();

        whitePieces.add(APawn);
        whitePieces.add(BPawn);
        whitePieces.add(CPawn);
        whitePieces.add(DPawn);
        whitePieces.add(EPawn);
        whitePieces.add(FPawn);
        whitePieces.add(GPawn);
        whitePieces.add(HPawn);
        whitePieces.add(LWRook);
        whitePieces.add(LWKnight);
        whitePieces.add(LWBishop);
        whitePieces.add(WKing);
        whitePieces.add(WQueen);
        whitePieces.add(RWBishop);
        whitePieces.add(RWKnight);
        whitePieces.add(RWRook);

        return whitePieces;

    }

    private Piece establishKing() {
        Piece temp = null;
        for (Piece piece : getPieces()) {
            if (piece.isKing()) {
                temp = piece;
            }
        }
        return temp;
    }



}
