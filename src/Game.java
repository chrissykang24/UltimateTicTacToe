
import java.util.*;

/*
contains the game loop and all the necessary methods for that
 */
public class Game {
    private MainBoard gameBoard; // the mainboard for play
    private char currentPlayer; // record player change
    private int UndoNumX = 0; // record number of times X player can undo steps
    private int UndoNumO = 0; // record number of times O player can undo steps
    private Stack<Integer> moveHistory; // record move history
    private Scanner in = new Scanner(System.in);
    private SubBoard chosen;


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

  System.out.println("This is tic-tac-toe. \nHere are some rules you might not know: \n1. Once a player chose a board, two players must play on that board until either it's full or it has a winner. \n2. Player who lost the previous board can initiate a new board and make the first move. If nobody wins a board, then the next person can start. \n3. Each player has three chances to undo a set of steps. A set of steps mean two moves, one by each player. \nTherefore, players can only undo steps after two moves are made in any sub-board. After each board is full or has a winner, players cannot undo anymore");
  gameBoard.printBoard();

        while (!gameBoard.hasWon()){
            chosen = null;
            moveHistory.clear();
            while (chosen == null) {
                chooseBoard();
            }
            while (!chosen.hasWon()){
                if (! chosen.isFull()) {
                    if (currentPlayer == 'X' && UndoNumX < 3) {

                        if (moveHistory.size() >= 2) {

                              System.out.println(moveHistory);
                            System.out.println("Player X, it's your turn");
                            System.out.println("Enter 'Undo' if you want or enter NO! ");
                            if (in.next().equals("Undo")) {
                                System.out.println("Notice");
                                chosen.undo(moveHistory);
                                UndoNumX++;
                                if (UndoNumX == 3)
                                    System.out.println("X has used all the undo chances");
                                chosen.printBoard();
                                Move(chosen);
                            } else {
                                Move(chosen);
                            }

                        } else {
                            Move(chosen);
                        }
                    } else if (currentPlayer == 'O' && UndoNumO < 3) {
                        if (moveHistory.size() >= 2) {
                            System.out.println("Player O, it's your turn");
                            System.out.println("Enter 'Undo' if you want or enter NO! ");
                            if (in.next().equals("Undo")) {
                                System.out.println("Notice");
                                chosen.undo(moveHistory);
                                UndoNumO++;
                                if (UndoNumO == 3)
                                    System.out.println("O has used all the undo chances");
                                chosen.printBoard();
                            } else {
                                Move(chosen);
                            }

                        } else {
                            Move(chosen);
                        }

                    } else {
                        Move(chosen);
                    }
                } else {

                        Move(chosen);
                }

                if (chosen.hasWon()){
                    chosen.printBoard();
                    System.out.println(chosen.getWinner() + " WINS this board.");
                    break;
                }
            if (chosen.isFull()){
                chosen.printBoard();
                System.out.println("It's full now. Let's move on! ");
                break;
            }
            }

            if (gameBoard.hasWon()){
                gameBoard.printBoard();
                System.out.println("Congrats!" + gameBoard.getWinner() + " WINS this game!");
                break;
            }
            else if (gameBoard.isFull()){
                gameBoard.printBoard();
                System.out.println("It is a tie better luck next time.");
                break;
            }
        }

    }

    /**
     * for player to move and record the change in board
     * @throws Exception illegal positions
     */
    public void Move(SubBoard chosen) {
//
            try {
                System.out.println("Enter your move, " + currentPlayer);
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
        playerSwitch();
        gameBoard.printBoard();
    }

    /**
     * swtich the player
     */
    public void playerSwitch(){
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    /***
     * players  choose which board to play
     */
    public void chooseBoard() {
      //  System.out.println("Player " + currentPlayer + " it is your turn!");
        System.out.println("Which board (1-9) would you like to play, " + currentPlayer + " ?");

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

}
