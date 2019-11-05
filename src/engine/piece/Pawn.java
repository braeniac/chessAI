package engine.piece;

public class Pawn implements Piece {
    private final String name = "P";
    private Alliance alliance;

    public String toString() {
        return name;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
