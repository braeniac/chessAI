package engine.piece;

public class Rook implements Piece {
    private final String name = "R";
    private Alliance alliance;

    public String toString() {
        return name;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}

