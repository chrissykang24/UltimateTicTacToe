/**
 * Represents the state of a board in a game of Tic-Tac-Toe
 */
public abstract class Board  {
    /**
     * The number of rows and columns in this square Tic-Tac-Toe board
     */
    private int boardSize = 3;
    /**
     * A 2D array representing the state of this Tic-Tac-Toe board
     */
    //private Object[][] currentBoard;

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
     * Converts an integer board location into a column number in currentBoard.
     *
     * @param location an integer board position in range [1-9]
     * @return an integer column number in range [0-2]
     */
    public int getColumn(int location) {
        return (location-1) % getSize();
    }

    /**
     * Converts an integer board location into a row number in currentBoard.
     *
     * @param location an integer board position in range [1-9]
     * @return an integer row number in range [0-2]
     */
    public int getRow(int location) {
        // Use integer division to truncate fractional part (column info)
        // implement then remove STUB return
        return (location - 1)/getSize();

    }



    /**
     * @return true if all the spaces on the board are occupied
     */
    public abstract boolean isFull();

    /**
     * @return true if currentPlayer has won the game
     */
    public abstract boolean hasWon();


    public char getWinner(){
        return winner;
    }


    /**
     * print the current board
     */
    public abstract void printBoard();

   // public abstract Board copy(Board other);

    public abstract Board newCopy();


}
