package engine.piece;

public class Queen implements Piece {

    private final String name = "Q";
    private Alliance alliance;

    public String toString() {
        return name;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
