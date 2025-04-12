/*
The board that contains the other boards
 */
public class MainBoard extends Board{

    // create a whole board
    private SubBoard[][] currentMainBoard;

    /**
     * public constructor
     */
    public MainBoard(){

    }

    /**
     * check if the whole board if full
     * @return true if the subboard is full
     */
    public boolean isFull(){
        return false;
    }

    /**
     * check if the current player wins
     * @return true if the player wins
     */
   public boolean hasWon(char currentPlayer){
        return false;
   }

    /**
     * print the current main board
     */
   public void printBoard(){

   }
}
