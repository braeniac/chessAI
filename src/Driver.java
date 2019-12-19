import engine.board.Board;
import engine.player.AI.AlphaBeta;
import engine.player.BlackPlayer;
import engine.player.Player;
import engine.player.WhitePlayer;
import engine.utility.Check;
import engine.utility.Utility;

import java.util.Scanner;

public class Driver {

    //board information
    private Board board;

    //player information
    private Player human;
    private Player AI;
    private AlphaBeta alphaBeta;
    private Player current;
    private Player opponent;
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
        board = new Board();

        //create players
        human = WhitePlayer.getInstance();
        AI = BlackPlayer.getInstance();

        //AI moves
        alphaBeta = new AlphaBeta();

        //user input
        in = new Scanner(System.in);

        //players set board with pieces
        board.setBoard(AI.getPieces(), human.getPieces());

        //initial settings
        turn = 0;
        current = human;
        opponent = AI;
        isInCheck = false;
        winner = false;
        draw = false;

        //game loop
        while (true) {

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
                    validMove = Check.isMoveLegal(current, board, start, end);

                    if (validMove) {
                        Board temp = new Board();
                        temp.setCloneBoard(Utility.getClone(board.getBoard()));
                        current.makeMove(temp, AI, start, end);
                        current.removeAcquiredPiece();
                        isInCheck = Check.isInCheck(current, AI, temp);
                    }

                } else if (current.getName().equals(AI.getName())) {

                    System.out.println("Available pieces: " + AI.getPieces());
                    System.out.println("Acquired pieces: " + AI.getOpponentPieces());
                    System.out.print("AI, moves:  ");

                    fromTo = alphaBeta.makeMove(current, board);
                    start = fromTo[0];
                    end = fromTo[1];
                    System.out.println(Utility.revert(start) + ", " + Utility.revert(end));
                    validMove = Check.isMoveLegal(current, board, start, end);

                    if (validMove) {
                        Board temp = new Board();
                        temp.setCloneBoard(Utility.getClone(board.getBoard()));
                        current.makeMove(temp, human, start, end);
                        current.removeAcquiredPiece();
                        isInCheck = Check.isInCheck(current, human, temp);
                    }

                }

                if (!validMove) {
                    System.out.println("\nPlease try again! ");
                }

                if (isInCheck) {
                    System.out.println("\nOops your in check, you must protect your king! ");
                }

            } while (!validMove || isInCheck);

            //make move -- check if opponent is in check
            if (current.getName().equals(human.getName())) {
                human.makeMove(board, AI, start, end);
                if (Check.isInCheck(AI, current, board)) System.out.println("\nYour in check, you must protect your king! ");
            } else {
                AI.makeMove(board, human, start, end);
                if (Check.isInCheck(human, current, board)) System.out.println("\nYour in check, you must protect your king! ");
            }

            draw = Check.isInStaleMate(current, opponent, board);

            if (draw) {
                System.out.println("Draw Game: ");
                break;
            }

            winner = Check.isInCheckMate(current, opponent, board);

            if (winner) {
                System.out.println("\n" + current.getName().toUpperCase() + " WINS!" );
                System.out.println("Winning board: ");
                break;
            }

            //change player
            if (current.getName().equals(human.getName())) {
                current = AI;
                opponent = human;
            } else if (current.getName().equals(AI.getName())) {
                current = human;
                opponent = AI;
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
