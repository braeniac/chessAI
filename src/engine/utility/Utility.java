package engine.utility;

public class Utility {

    //can't instantiate the Utility object
    private Utility() { }

    //This method check game bound 0 to 64 --64 tiles; 8x8 game board
    public static boolean isValid(final int coordinate) {
        //if the coordinate is within the game bounds return true
        return (coordinate < 64 && coordinate >= 0);
    }

//    //This method will return a (deep) clone of the existing board
//    public static Tile[] getClone(Tile[] board) {
//        Tile[] clone = new Tile[board.length];
//        for (int i=0; i<clone.length; i++) {
//            clone[i] = new Tile(board[i].getCoordinate(), board[i].getPiece());
//        }
//        return clone;
//    } //getClone

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

    //This method returns the coordinate label
    //example: Tile coordinate 40 returns label "a6"
    public static String revert(final int coordinate) {
        return board[coordinate];
    }

    //This method returns array coordinate based on user command => (from, to)
    //example: User command (a7,a6) will return (48,40)
    public static int[] readCommand(final String command) {
        //store command in array
        //command format (from , to)
        //array format fromTo[0] = from and fromTo[1] = to
        String[] fromTo = command.toLowerCase().split(",");
        int[] result = new int[2];
        for (int i = 0; i < board.length; i++) {
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

    public static final boolean[] isFirstColumn = {
            true, false, false, false, false, false, false, false,
            true, false, false, false, false, false, false, false,
            true, false, false, false, false, false, false, false,
            true, false, false, false, false, false, false, false,
            true, false, false, false, false, false, false, false,
            true, false, false, false, false, false, false, false,
            true, false, false, false, false, false, false, false,
            true, false, false, false, false, false, false, false,
    };

    public static final boolean[] isSecondColumn = {
            false, true, false, false, false, false, false, false,
            false, true, false, false, false, false, false, false,
            false, true, false, false, false, false, false, false,
            false, true, false, false, false, false, false, false,
            false, true, false, false, false, false, false, false,
            false, true, false, false, false, false, false, false,
            false, true, false, false, false, false, false, false,
            false, true, false, false, false, false, false, false,
    };

    public static final boolean[] isSeventhColumn = {
            false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, true, false,
    };

    public static final boolean[] isEighthColumn = {
            false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, true,
    };

    public static final boolean[] isSecondRow = {
            false, false, false, false, false, false, false, false,
            true , true , true , true , true , true , true , true ,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
    };

    public static final boolean[] isSeventhRow = {
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            true , true , true , true , true , true , true , true ,
            false, false, false, false, false, false, false, false,
    };

    public static final boolean[] isFirstRow = {
            true , true , true , true , true , true , true , true ,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
    };

    public static final boolean[] isEighthRow = {
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false,
            true , true , true , true , true , true , true , true ,
    };

}
