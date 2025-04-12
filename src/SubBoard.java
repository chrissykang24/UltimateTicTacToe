import java.util.Queue;
import java.util.Stack;

/*
The smaller games within the big board
 */
public class SubBoard extends Board {

    // create a small board
    private char[][] currentSubBoard;

    /**
     * public constructor
     */
    public SubBoard(){

    }

    /**
     * Add move to the board
     * @throws Exception if location is invalid or already full
     */
    public void play(char currentPlayer, int location) throws Exception {
        // implement and throw exception if the move is invalid
//        if (location>9||location<1)
//            throw new Exception("Cannot Play There");
//        else if (isFilled(getRow(location),getColumn(location)))
//            throw new Exception("Spot is already full");
//        else
//            currentBoard[getRow(location)][getColumn(location)]=currentPlayer;
    }

    /**
     * check if the board position at given index is filled
     *  @return true if the currentBoard already has an 'X' or an 'O' at
     * [row][column].
     */
    public boolean isFilled(int row, int col){
        return false;
    }

    // implement then remove STUB return
    //return currentBoard[row][col] == 'X' || currentBoard[row][col] == 'O';

    /**
     * for players to undo steps
     * @param playerTurns the sequence of players
     * @param moveHistory the positions each player made
     */
    public void undo(Queue<Character> playerTurns, Stack<Integer> moveHistory ){}

    /**
     * print the current sub board
     */
    public void printBoard(){}

    /**
     * check if the board is full
     * @return true if the board if full
     */
    public boolean isFull(){
        return false;
    }

    /**
     * check if current player wins this subboard
     * @return true if current player wins
     */
    public boolean hasWon(char currentPlayer){
        return false;
    }

}

