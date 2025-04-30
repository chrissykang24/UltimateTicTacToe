
import java.util.*;

/*
contains the game loop and all the necessary methods for that
 */
public class Game {
    private MainBoard gameBoard; // the mainboard for play
    private char currentPlayer; // record player change
    private final int UNDONUMX = 3; // record number of times X player can undo steps
    private final int UNDONUMO = 3; // record number of times O player can undo steps
    private Stack<Integer> moveHistory; // record move history
    private Scanner in = new Scanner(System.in);
    private SubBoard chosen;
  //  private int moveLocation = -1;
   // a scanner to scan user input



    /**
     * public constructor
     */
    public Game() {
        chosen = null;
        gameBoard = new MainBoard();
//        currentPlayerInt = 0;
        currentPlayer = 'O';
//
        moveHistory = new Stack<>();


    }

    /**
     * a loop for players to move
     */
    public void gameLoop() {

  System.out.println("This is tic-tac-toe. \nHere are some rules you might not know: \n1. Once a player chose a board, two players must play on that board until either it's full or it has a winner. \n2. Two players take turns to initiate a board and make the first move. \n3. Each player has three chances to undo a set of steps. Just enter 'Undo' without any space on your turn. A set of steps mean two moves, one by each player. Therefore, players can only undo steps after two moves are made in any sub-board. ");
  gameBoard.printBoard();

        while (!gameBoard.hasWon()){
            while (chosen == null) {
                chooseBoard();
            }
            while (!chosen.hasWon()){
              //  System.out.println(moveHistory);
                if (moveHistory.size() >= 2) {
                 //   System.out.println(moveHistory);
                    if (in.next().equals("Undo")) {
                        System.out.println("Notice");
                        chosen.undo(moveHistory);
                    }
                }
                   Move(chosen);
                System.out.println("+1");

                if (chosen.hasWon()){
                    chosen.printBoard();
                    System.out.println(chosen.getWinner() + " WINS this board.");
                }
            if (chosen.isFull()){
                chosen.printBoard();
                System.out.println("It's full now. Let's move on! ");
                break;
            }
            }

            if (gameBoard.hasWon()){
                gameBoard.printBoard();
                System.out.println(gameBoard.getWinner() + " WINS");
            }
            else if (gameBoard.isFull()){
                gameBoard.printBoard();
                System.out.println("It is a tie better luck next time.");
                break;
            }
        }
//        gameBoard.printBoard();
//        while (!gameBoard.isFull() && !playerHasWon){
//            currentPlayer = PLAYERS[currentPlayerInt];
//
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
//
//        }


    }

    /**
     * for player to move and record the change in board
     * @throws Exception illegal positions
     */
    public void Move(SubBoard chosen) {
//
        gameBoard.printBoard();
       playerSwitch();


            try {
                System.out.println("Enter your move");
                int location = in.nextInt();
           //     System.out.println(location);
                chosen.play(currentPlayer, location);
              //  chosen.printBoard();
                moveHistory.push(location);


            } catch (InputMismatchException e) {
                System.out.println("ENTER A VALID NUMBER");
                playerSwitch();
                in.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                playerSwitch();
            }

    }

    public void playerSwitch(){
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public void chooseBoard() {
      //  System.out.println("Player " + currentPlayer + " it is your turn!");
        System.out.println("Which board (1-9) would you like to play? ");
        
            try {
                int boardNum = in.nextInt();
                gameBoard.choose(boardNum);
                System.out.println("Okay, board is chosen! Please enter your move (1-9)! ");
                chosen = gameBoard.getSubBoard(boardNum);
            } catch (InputMismatchException e) {
                System.out.println("ENTER A VALID NUMBER");
                in.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


    }

//    /**
//     * record the move history
//     */
//   public void moveRecord(){
//
//   }

//public void push(int location){
//        if (location != -1)
//           moveHistory.push(location);
//}
}
