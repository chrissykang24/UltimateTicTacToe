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
//        boardSize = 3;
        winner = ' ';
        currentSubBoard = new char[getSize()][getSize()];
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                currentSubBoard[i][j]=' ';
            }
        }
    }


    /**
     * Add move to the board
     * @throws Exception if location is invalid or already full
     */
    public void play(char currentPlayer, int location) throws IllegalArgumentException{
        // implement and throw exception if the move is invalid
        if (location>9||location<1)
            throw new IllegalArgumentException("Cannot Play There");
        else if (isFilled(getRow(location),getColumn(location)))
            throw new IllegalArgumentException("Spot is already full");
        else {
            currentSubBoard[getRow(location)][getColumn(location)] = currentPlayer;

        }

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
     * @param moveHistory the positions each player made
     */
    public void undo( Stack<Integer> moveHistory){
            for (int i = 0; i < 2; i++) {

                int location = moveHistory.pop();
                currentSubBoard[getRow(location)][getColumn(location)] = ' ';

        }


    }

    /**
     * print the current sub board
     */
    @Override
    public void printBoard(){
        System.out.println(currentSubBoard[0][0] + " | " + currentSubBoard[0][1] + " | " + currentSubBoard[0][2]);
        System.out.println("_________");
        System.out.println(currentSubBoard[1][0] + " | " + currentSubBoard[1][1] + " | " + currentSubBoard[1][2]);
        System.out.println("_________");
        System.out.println(currentSubBoard[2][0] + " | " + currentSubBoard[2][1] + " | " + currentSubBoard[2][2]);
    }

    /**
     * store this subboard prints into a string array
     * @return the string array
     */
    public String[] getPrintLines() {
        String[] lines = new String[getSize()];
        for (int i = 0; i < getSize(); i++) {
            lines[i] = " ";
            for (int j = 0; j < getSize(); j++) {
                if (j != getSize()-1)
                 lines[i] += currentSubBoard[i][j] + " | ";
                else
                    lines[i] += currentSubBoard[i][j];
            }
        }
        return lines;
    }


    /**
     * check if the board is full
     * @return true if the board is full
     */
    @Override
    public boolean isFull(){
        for (int i = 0; i <getSize() ; i++) {
            for (int j = 0; j < getSize(); j++) {
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
    @Override
    public boolean hasWon() {


        for (int i = 0; i < getSize(); i++) {
            int countX = 0;
            int countO = 0;
            for (int j = 0; j < getSize(); j++) {
                if (currentSubBoard[i][j] == 'X') {
                    countX++;
                } else if (currentSubBoard[i][j] == 'O') {
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
                if (currentSubBoard[j][i] == 'X') {
                    countX++;
                } else if (currentSubBoard[j][i] == 'O') {
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

            if (currentSubBoard[i][i] == 'X') {
                countX++;
            } else if (currentSubBoard[i][i] == 'O') {
                countO++;
            }
                if (countX == getSize()) {
                    winner = 'X';
  //                  System.out.println("winner is X");
//                    System.out.println(winner + "wins");
                   return true;
                } else if (countO == getSize()) {
                    winner = 'O';
                    return true;
                }
        }

        countX = 0;
        countO = 0;
        for (int i = 0; i < getSize(); i++) {

            if (currentSubBoard[i][getSize() - 1 - i] == 'X') {
                countX++;
            } else if (currentSubBoard[i][getSize() - 1 - i] == 'O'){
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



//    public SubBoard(SubBoard other) {
//        this.currentSubBoard = new char[getSize()][getSize()];
//        for (int i = 0; i < getSize(); i++) {
//            for (int j = 0; j < getSize(); j++) {
//                currentSubBoard[i][j] = other.currentSubBoard[i][j];
//            }
//        }
//        winner = other.winner;
//
//    }
//
//    @Override
//    public SubBoard newCopy(){
//        return new SubBoard(this);
//    }

}



