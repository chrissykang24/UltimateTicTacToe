/*
The board that contains the other boards
 */
public class MainBoard extends Board{

    // create a whole board
    private SubBoard[][] currentMainBoard;


//    private int boardSize;

    /**
     * public constructor
     */
    public MainBoard(){
//        boardSize = 3;

        winner = ' ';
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
     * check if the whole board if full
     * @return true if the subboard is full
     */
    public boolean isFull(){
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if(!(currentMainBoard[i][j].isFull() || currentMainBoard[i][j].hasWon()) )
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
//                   System.out.println();
                   countX++;
               } else if (currentMainBoard[j][i].getWinner() == 'O') {
                   countO++;
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
//               System.out.println(currentMainBoard[i][i].getWinner() + "note");
           } else if (currentMainBoard[i][i].getWinner() == 'O') {
               countO++;
           }
               if (countX == getSize()) {
                   winner = 'X';
                   return true;
               } else if (countO == getSize()) {
                   winner = 'O';
                   return true;
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
     * return subboard at given index
     * @param boardNum given index
     * @return subbaord
     */
   public SubBoard getSubBoard(int boardNum){
       return currentMainBoard[getRow(boardNum)][getColumn(boardNum)];
   }

    /**
     * uses choose which board to play
     * @param location userinput
     * @throws IllegalArgumentException as follow
     */
   public void choose(int location) throws IllegalArgumentException{
       if (location>9||location<1)
           throw new IllegalArgumentException("Cannot Play There");
       else if (getSubBoard(location).isFull())
           throw new IllegalArgumentException("Board has been played");
       else if (getSubBoard(location).hasWon())
           throw new IllegalArgumentException("Board has been played");



   }
    /**
     * print the current main board
     */
   public void printBoard(){

       for (int i = 0; i < getSize(); i++) {
           String[] board1lines = currentMainBoard[i][0].getPrintLines();
           String[] board2lines = currentMainBoard[i][1].getPrintLines();
           String[] board3lines = currentMainBoard[i][2].getPrintLines();
           for (int j = 0; j < getSize(); j++) {

               System.out.print(board1lines[j] + " || ");
               System.out.print(board2lines[j] + " || ");
               System.out.print(board3lines[j] + " ");
               if (j < getSize() - 1) {
                   System.out.println();
                   System.out.println("----------------------------------------");
               }
           }
           System.out.println();
           System.out.println("========================================");
       }
   }


}
