import engine.board.Board;
import engine.player.BlackPlayer;
import engine.player.Player;
import engine.player.WhitePlayer;
import engine.utility.Check;
import engine.utility.Utility;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Driver {

    //board information
    private Board board;

    //player information
    private Player human;
    private Player AI;
    private Player current;
    private Scanner in;
    private String move;
    private int[] fromTo;
    private int start;
    private int end;

    //game information
    private int turn;
    private boolean winner;
    private boolean isInCheck;
    private boolean draw;
    private boolean validMove;

    public Driver() {

        //create board
        board = Board.getInstance();

        //create players
        human = WhitePlayer.getInstance();
        AI = BlackPlayer.getInstance();

        //user input
        in = new Scanner(System.in);

        //players set board with pieces
        board.setBoard(AI.getPieces(), human.getPieces());

        //initial settings
        current = human;
        turn = 0;
        winner = false;
        isInCheck = false;

        //game loop
        while (true) {

            if (draw) {
                System.out.println("Draw Game: ");
                break;
            }

            do {
                board.print();
                if (current.getName().equals(human.getName())) {
                    System.out.println("Available pieces: " + human.getPieces());
                    System.out.println("Acquired pieces: " + human.getOpponentPieces());
                    System.out.print("Human, make your move (i.e) a7,a6): ");
                    move = in.nextLine().toLowerCase();
                    fromTo = Utility.readCommand(move);
                    start = fromTo[0];
                    end = fromTo[1];
                    isInCheck = Check.isInCheck(current, AI, board);
                    validMove = Check.isMoveLegal(current, board, start, end);
                } else if (current.getName().equals(AI.getName())) {
                    System.out.println("Available pieces: " + AI.getPieces());
                    System.out.println("Acquired pieces: " + AI.getOpponentPieces());
                    System.out.print("AI, moves (i.e a7,a6):  ");
                    move = in.nextLine();
                    fromTo = Utility.readCommand(move);
                    start = fromTo[0];
                    end = fromTo[1];
                    isInCheck = Check.isInCheck(current, human, board);
                    validMove = Check.isMoveLegal(current, board, start, end);
                }

                if (!validMove) {
                    System.out.println("\nPlease try again! ");
                }

                if (isInCheck) {
                    System.out.println("\nOops your in check, you must protect your king! ");
                }

            } while (!validMove || isInCheck);

            //make move
            if (current.getName().equals(human.getName())) {
                human.makeMove(board, AI, start, end);
            } else {
                AI.makeMove(board, human, start, end);
            }

            //does the current player have a checkmate


            if (winner) {
                System.out.println(current.getName() + " Wins!" );
                System.out.println("Winning board: ");
                break;
            }

            //change player
            if (current.getName().equals(human.getName())) {
                current = AI;
            } else if (current.getName().equals(AI.getName())) {
                current = human;
            }

            //increment turn
            turn++;

        }

        //print draw/winning board
        board.print();
        in.close();

    } //constructor

    public static void main (String [] args) {
        new Driver();
    }

}
