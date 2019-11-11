package engine.board;

import engine.piece.Piece;

import java.util.HashMap;

public class Utility {

    //board label hashmap
    private static final String[] board = {
            "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1",
            "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
            "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
            "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
            "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
            "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
            "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
            "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
    };

    //can't instantiate the Utility object
    private Utility() { }

    //This method will return a (deep) clone of the existing board
    public static Tile[] getClone(Tile[] board) {
        Tile[] clone = new Tile[board.length];
        for (int i=0; i<clone.length; i++) {
            clone[i] = new Tile(board[i].getCoordinate(), board[i].getPiece());
        }
        return clone;
    } //getClone


    //This method returns array coordinate based on user command => (from, to)
    //example: User command (a7,a6) will return (48,40)
    public static int[] readCommand(final String command) {
        //store command in array
        //command format (from , to)
        //array format fromTo[0] = from and fromTo[1] = to
        String[] fromTo = command.toLowerCase().split(",");
        int[] result = new int[2];
        for (int i=0; i<board.length; i++) {
            //if from matches the board return index
            if (fromTo[0].equals(board[i])) {
                result[0] = i;
            }
            //if from matches the board return index
            if (fromTo[1].equals(board[i])) {
                result[1] = i;
            }
        }
        return result;
    }

    //This method returns the coordinate label
    //example: Tile coordinate 40 returns label "a6"
    public static String revert(final int coordinate) {
        return board[coordinate];
    }








}
