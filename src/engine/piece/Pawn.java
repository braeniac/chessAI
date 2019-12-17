package engine.piece;

import engine.utility.Set;
import engine.utility.Colour;
import engine.board.Board;
import engine.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

    private final String name = "P";
    private Set set;
    private int piecePosition;
    private boolean firstMove;

    //offsets derived from https://en.wikipedia.org/wiki/Pawn_(chess)
    private int[] offsets = {8, 16, 9, 7};

    public Pawn(final int piecePosition, final Set set) {
        this.piecePosition = piecePosition;
        this.set = set;
        this.firstMove = false;
    }

    public void setPiecePosition(final int piecePosition) {
        this.piecePosition = piecePosition;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Set getSet() {
        return set;
    }

    //This method calculates and returns a list of legal moves of the PAWN piece
    public List<Integer> legalMoves(Board board) {

        int destination = 0;
        int directionality = directionality();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<offsets.length; i++) {
            //directionality is either -1 (white) or 1 (black)
            destination = this.piecePosition + (directionality * offsets[i]);
            if (Utility.isValid(destination)) {
                //only allow pawn piece to move up by 1 if there is no enemy piece in destination location
                if (!board.getTile(destination).isOccupied() && offsets[i] == 8) {
                    list.add(destination);
                    //move up by 2 only if this piece has not made its first move
                } else if (offsets[i] == 16 && !this.firstMove) {
                    if (Utility.isSecondRow[this.piecePosition] && this.set == Set.BLACK
                                || Utility.isSeventhRow[this.piecePosition] && this.set == Set.WHITE) {
                        //ensures the requested piece just not jump over piece directly infront of this piece
                        if (!board.getTile(this.piecePosition + (directionality * 8)).isOccupied()) {
                            list.add((this.piecePosition + (directionality * offsets[i])));
                        }
                    }
                    //pawn attacking piece
                    //only move if and only if there exists an enemy piece
                } else if (offsets[i]== 7 || offsets[i] == 9) {
                    Piece piece = board.getTile(this.piecePosition).getPiece();
                    if (checkColumnException(this.piecePosition, offsets[i], piece)) continue;
                    if (board.getTile((this.piecePosition + (directionality * offsets[i]))).isOccupied()) {
                        list.add(destination);
                    }
                }
            }
        }

        return list;
    }


    //This method excludes all destination tiles that don't fit the offset rule
    public boolean checkColumnException(final int piecePosition, final int offset, final Piece piece) {
        if (Utility.isFirstColumn[piecePosition] &&  piece.getSet() == Set.WHITE && offset == 9
                || Utility.isFirstColumn[piecePosition] &&  piece.getSet() == Set.BLACK && offset == 7) {
            return true;
        } else if (Utility.isEighthColumn[piecePosition] && piece.getSet() == Set.WHITE && offset == 7
                ||Utility.isEighthColumn[piecePosition] && piece.getSet() == Set.BLACK && offset == 9) {
            return true;
        }
        return false;
    }

    //white pawns move up while black pawns move down -- ensures directionality
    public int directionality() {
        if (this.set == Set.WHITE) {
            return -1;
        } else {
            return 1;
        }
    }

    public void firstMove() {
        this.firstMove = true;
    }

    public boolean getFirstMove() {
        return this.firstMove;
    }

    public String getName() {
        return this.name;
    }

    public int getPiecePosition() { return piecePosition; }

    public boolean isKing() { return false; }

    public String toString() {
        return (this.set == Set.BLACK) ?  Colour.RED + name + Colour.RESET :  Colour.BLUE + name.toLowerCase() + Colour.RESET;
    }

}
