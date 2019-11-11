import engine.board.Board;

import java.util.Scanner;

public class Driver {

    private static final int DRAW = 50;
    private Boolean winner;
    private Boolean validMove;
    private String move;
    private int turn;

    public Driver() {

        //create the game board
        Board game = new Board();

        //allow or user input
        Scanner in = new Scanner(System.in);

        //initialize game information
        winner = false;
        move = null;
        turn = 0;

        game.print();




    } //constructor

    public static void main (String [] args) { new Driver(); }

}
