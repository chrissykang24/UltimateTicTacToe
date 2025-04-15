
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
contains the game loop and all the necessary methods for that
 */
public class Game {
    private MainBoard gameBoard; // the mainboard for play
    private Queue<Character> currentPlayer; // record player change
    private int undoNumX; // record number of times X player can undo steps
    private int undoNumO; // record number of times O player can undo steps
    private Stack<Integer> moveHistory; // record move history
    private Scanner inputScan = new Scanner(System.in); // a scanner to scan user input



    /**
     * public constructor
     */
    public Game() {
//        gameBoard = new Board();
//        currentPlayerInt = 0;
//        currentPlayer = PLAYERS[currentPlayerInt];
        undoNumO = 3;
        undoNumX = 3;


    }

    /**
     * a loop for players to move
     */
    public void gameLoop() {
//        System.out.println("This is tic-tac-toe");
//        gameBoard.printBoard();
//        while (!gameBoard.isFull() && !playerHasWon){
//            currentPlayer = PLAYERS[currentPlayerInt];
//            System.out.println("Player " + currentPlayer + " it is your turn");
//            System.out.print("Enter an integer between 1-9: ");
//            try{
//                gameBoard.play(currentPlayer,getPlayerMove());
//                gameBoard.printBoard();
//                if(gameBoard.hasWon(currentPlayer))
//                    playerHasWon = true;
//                else if (currentPlayerInt==1) {
//                    currentPlayerInt=0;
//                }else
//                    currentPlayerInt=1;
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());;
//            }
//
//        }
//        if (playerHasWon){
//            System.out.println("Congratulations player " + currentPlayer + "! You won");
//        }else{
//            System.out.println("It is a tie better luck next time.");
//        }

    }

    /**
     * for player to move and record the change in board
     * @throws Exception illegal positions
     */
    public void Move()throws Exception{
//        if (inputScan.hasNextInt()){
//            return inputScan.nextInt();
//        }
//        inputScan.nextLine();
//        throw new Exception("That isn't an integer");

    }

    /**
     * record the move history
     */
   public void moveRecord(){

   }


}
