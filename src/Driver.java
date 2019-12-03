import engine.board.Board;
import engine.player.Player;
import engine.utility.Check;
import engine.utility.Set;
import engine.utility.Utility;

import java.util.Scanner;

public class Driver {

    //system information
    private Scanner in;

    //game information
    private Board board;
    private Boolean winner;
    private Boolean validMove;
    private int turn;

    //player information
    private Player human;
    private Player AI;
    private String player;
    private String input;
    private int[] command;
    private int start;
    private int end;


    public Driver() {

        //create instance of game board
        board = new Board();

        //allows for user input
        in = new Scanner(System.in);

        //player information
        human = new Player(Set.WHITE, "human");
        AI = new Player(Set.BLACK, "AI");

        //game information
        winner = false;
        player = "human";
        turn = 0;

        //game loop
        while(true) {

            do {
                //print game board
                board.print();

                if (player == human.getName()) {
                    System.out.print("Human, make your move (i.e a7,a6):  ");
                    input = in.nextLine().toLowerCase();
                    if (input.equals("exit")) {
                        System.exit(0);
                    } else {
                        command = Utility.readCommand(input);
                        start = command[0];
                        end = command[1];
                        validMove = Check.validate(human, board, start, end);
                    }
                } else if (player == AI.getName()) {
                    System.out.print("AI, moves (i.e a7,a6):  ");
                    input = in.nextLine();
                    command = Utility.readCommand(input);
                    start = command[0];
                    end = command[1];
                    validMove = Check.validate(AI, board, start, end);
                }
                if (!validMove) {
                    System.out.println("\nPlease try again!");
                }

            } while (!validMove);

            //makes the move
            if (player == "human") {
                human.makeMove(board, start, end);
                System.out.println("Acquired pieces: " + human.getOpponentPieces());
            } else {
                AI.makeMove(board, start, end);
                System.out.println("Acquired pieces: " + AI.getOpponentPieces());
            }

            //check if player has winning move
            winner = Check.hasWinningMove();

            //break out if current player has winning move
            if (winner) {
                System.out.println("\nWinning board: ");
                break;
            }

            //change player
            if (player == "human") {
                player = "AI";
            } else if (player == "AI") {
                player = "human";
            }

            //update turn
            turn++;

        }
        board.print();

    } //constructor

    public static void main (String [] args) {
        new Driver();
    }

}
