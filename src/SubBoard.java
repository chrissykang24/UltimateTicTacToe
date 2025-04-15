import java.util.Queue;
import java.util.Stack;

/*
The smaller games within the big board
 */
public class SubBoard extends Board {

    // create a small board
    private char[][] currentSubBoard;
    private char winner = ' ';
    private int boardSize;

    /**
     * public constructor
     */
    public SubBoard(){
        boardSize = 3;
        currentSubBoard = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                currentSubBoard[i][j]=' ';
            }
        }
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
    public boolean isFilled(int row, int col) {
        return currentSubBoard[row][col] == 'X' || currentSubBoard[row][col] == 'O';
    }
    /**
     * for players to undo steps
     * @param playerTurns the sequence of players
     * @param moveHistory the positions each player made
     */
    public void undo(Queue<Character> playerTurns, Stack<Integer> moveHistory ){}

    /**
     * print the current sub board
     */
    public void printBoard(){
        System.out.println(currentSubBoard[0][0] + " | " + currentSubBoard[0][1] + " | " + currentSubBoard[0][2]);
        System.out.println("_________");
        System.out.println(currentSubBoard[1][0] + " | " + currentSubBoard[1][1] + " | " + currentSubBoard[1][2]);
        System.out.println("_________");
        System.out.println(currentSubBoard[2][0] + " | " + currentSubBoard[2][1] + " | " + currentSubBoard[2][2]);
    }

    /**
     * check if the board is full
     * @return true if the board is full
     */
    public boolean isFull(){
        for (int i = 0; i <boardSize ; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(!isFilled(i,j))
                    return false;
            }
        };
        return true;
    }

    /**
     * check if current player wins this subboard
     * @return true if a player wins
     * and set winner to winning player
     */
    public boolean hasWon(){

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (currentSubBoard[i][j]=='X');
            }

        }

        return false;
    }

    @Override
    public Board copy(Board other) {
        return null;
    }
}



