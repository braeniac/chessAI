package engine.piece;

public class King implements Piece {
    private final String name = "K";
    private Alliance alliance;

    public String toString() {
        return name;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
