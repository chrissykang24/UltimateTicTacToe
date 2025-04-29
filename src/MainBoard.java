/*
The board that contains the other boards
 */
public class MainBoard extends Board{

    // create a whole board
    private SubBoard[][] currentMainBoard;
    private char winner = ' ';
//    private int boardSize;

    /**
     * public constructor
     */
    public MainBoard(){
//        boardSize = 3;
        currentMainBoard = new SubBoard[getSize()][getSize()];
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
     * check if the whole board if full or it has a winner
     * @return true if the subboard is full or it has a winner
     */
    public boolean isFull(){
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
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
       for (int i = 0; i < getSize(); i++) {
           int countX = 0;
           int countO = 0;
           for (int j = 0; j < getSize(); j++) {
               if (currentMainBoard[i][j].getWinner() == 'X') {
                   countX++;
               } else if (currentMainBoard[i][j].getWinner() == 'O') {
                   countO++;
               }
           }
           if (countO == 3) {
               winner = 'O';
               return true;
           } else if (countX == 3) {
               winner = 'X';
               return true;
           }
       }


       for (int i = 0; i < getSize(); i++) {
           int countX = 0;
           int countO = 0;
           for (int j = 0; j < getSize(); j++) {
               if (currentMainBoard[j][i].getWinner() == 'X') {
                   winner = 'X';
               } else if (currentMainBoard[j][i].getWinner() == 'O') {
                   winner = 'O';
               }
           }
           if (countO == getSize()) {
               winner = 'O';
               return true;
           } else if (countX == getSize()) {
               winner = 'X';
               return true;
           }
       }


       int countX = 0;
       int countO = 0;

       for (int i = 0; i < getSize(); i++) {

           if (currentMainBoard[i][i].getWinner() == 'X') {
               countX++;
           } else if (currentMainBoard[i][i].getWinner() == 'O') {
               countO++;
               if (countX == getSize()) {
                   winner = 'X';
                   return true;
               } else if (countO == getSize()) {
                   winner = 'O';
                   return true;
               }
           }
       }

       countX = 0;
       countO = 0;
       for (int i = 0; i < getSize(); i++) {

           if (currentMainBoard[i][getSize() - 1 - i].getWinner() == 'X') {
               countX++;
           } else if (currentMainBoard[i][getSize() - 1 - i].getWinner() == 'O'){
               countO++;
           }
           if (countX == getSize()) {
               winner = 'X';
               return true;
           } else if (countO == 3) {
               winner = 'O';
               return true;
           }
       }

       return false;
   }

    /**
     * print the current main board
     */
   public void printBoard(){
       for (int i = 0; i < getSize(); i++) {
           for (int j = 0; j < getSize(); j++) {
               System.out.print(currentMainBoard[i][j].getPrintBoardFirstLine());
               if (j != getSize() -1 )
                   System.out.print("||");
           }
           System.out.println();
           System.out.println("_________");
       }
   }

    @Override
    public Board newCopy() {
        return null;
    }
}
