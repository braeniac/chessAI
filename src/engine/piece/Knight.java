package engine.piece;

public class Knight implements Piece {
    private final String name = "N";
    private Alliance alliance;

    public String toString() {
        return name;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
