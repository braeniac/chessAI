package engine.piece;

public class Bishop implements Piece {
    private final String name = "B";
    private Alliance alliance;

    public String toString() {
        return name;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
