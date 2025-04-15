/*
The board that contains the other boards
 */
public class MainBoard extends Board{

    // create a whole board
    private SubBoard[][] currentMainBoard;
    private char winner = ' ';
    private int boardSize;

    /**
     * public constructor
     */
    public MainBoard(){
        boardSize = 3;
        currentMainBoard = new SubBoard[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                currentMainBoard[i][j]=new SubBoard();
            }
        }
    }

//    public MainBoard(){
//
//    }

    /**
     * check if the whole board if full
     * @return true if the subboard is full
     */
    public boolean isFull(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(!(currentMainBoard[i][j].isFull()||currentMainBoard[i][j].hasWon()))
                    return false;
            }

        }
        return true;
    }

    /**
     * check if the current player wins
     * @return true if the player wins
     */
   public boolean hasWon(){
        return false;
   }

    /**
     * print the current main board
     */
   public void printBoard(){

   }

    @Override
    public Board copy(Board other) {
        return null;
    }
}
