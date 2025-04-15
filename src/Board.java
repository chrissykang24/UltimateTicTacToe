/**
 * Represents the state of a board in a game of Tic-Tac-Toe
 */
public abstract class Board  {
    /**
     * The number of rows and columns in this square Tic-Tac-Toe board
     */
    private int boardSize;
    /**
     * A 2D array representing the state of this Tic-Tac-Toe board
     */
    private Object[][] currentBoard;

    private char winner;

    /**
     * Creates an empty Tic-Tac-Toe board
     */
    public Board() {
//        for (int i = 1; i < 10; i++) {
//            currentBoard[getRow(i)][getColumn(i)] = ' ';
//        }
    }

    /**
     * return Size of the board
     */
    public int getSize(){
        return boardSize;
    }






    /**
     * @return true if all the spaces on the board are occupied
     */
    public abstract boolean isFull();

    /**
     * @return true if currentPlayer has won the game
     */
    public abstract boolean hasWon();





    /**
     * print the current board
     */
    public abstract void printBoard();

    public abstract Board copy(Board other);


}
