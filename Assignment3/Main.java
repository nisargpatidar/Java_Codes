/*
Write the following function that tests whether a two-dimensional list has 4 consecutive 
numbers of the same value, either horizontally, vertically, or diagonally.

Write a test program that prompts that randomly generates the number of rows and columns of 
a two-dimensional list and then the values in the list and displays True if the list contains four 
consecutive numbers with the same value along side with the array. Otherwise, display False. 
*/

// using java.util.Random;
import java.util.Random;

class Main {

  // Random number generator
  public static int RandomNumberGenerator(int maxLimit) {
    Random rand = new Random();

    // Generate random integers in range 0 to 9
    return rand.nextInt(maxLimit);
  }

  // 2D Array create
  public static void BoardCreation(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = RandomNumberGenerator(9);
    }
  }

  // 2D Array print
  public static void PrintBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++)
        System.out.print(board[i][j] + " ");
      System.out.print("\n");
    }
  }

  // Check the 4 number, if it's consecutive or not
  public static int CheckConsecutive(int[][] board, int x, int y, int sizeX, int sizeY) {
    // To check if we can check horizontally, vertically or diagonally downward

    if (sizeX > (x + 4)) {
      if (sizeY > (y + 4)) {
        //Checking diagonally downward
        if (board[x][y] == board[x + 1][y + 1] && board[x][y] == board[x + 2][y + 2]
          && board[x][y] == board[x + 3][y + 3]) {
        return 1;
        }
      }

      //Checking vertically
      if (board[x][y] == board[x + 1][y] && board[x][y] == board[x + 2][y] && board[x][y] == board[x + 3][y]) {
        return 1;
      }
    }
    
    if (sizeY > (y + 4)) {
      // To check if we can check the diagonally upward
      if (0 < (x - 4)) {
        if (board[x][y] == board[x - 1][y + 1] && board[x][y] == board[x - 2][y + 2]
          && board[x][y] == board[x - 3][y + 3]) {
        return 1;
        }
      }
      
      //Check horizontally
      if (board[x][y] == board[x][y + 1] && board[x][y] == board[x][y + 2] && board[x][y] == board[x][y + 3]) {
        return 1;
      }
    }
    
    return 0;
  }

  public static void main(String[] args) {

    // Number between 0 to 9, inclusive
    int x = RandomNumberGenerator(20);
    int y = RandomNumberGenerator(20);

    System.out.println("Sizex for the Array is: " + x + "\nSizey for the Array is: " + y);

    //Create Board for the Array
    int[][] board = new int[x][y];

    //Create Board
    BoardCreation(board);

    //Print Board
    PrintBoard(board);


    //If the both size is less than 4, then we can't find the consecutive number
    if (x < 4 && y < 4) {
      System.out.println("Size is less, so no 4 consecutive number can be found");
      System.out.println("False");

      return;
    }

    //If the size is 0 then we can't find anything.
    if (x < 1 || y < 1){
      System.out.println("Atleast one size is less than 0, so no 4 consecutive number can be found");
      System.out.println("False");

      return;
    }

    //We will start finding the 4 consecutive number here
    int temp = -2;
    for (int i = 0; i < board.length; i++) {
      for (int j = i; j < board[i].length; j++) {
        
        temp = CheckConsecutive(board, i, j, x, y);
        
        if (temp == 1) {
          System.out.println("Four consecutive number has been found");
          System.out.println("True");

          return;
        }

        else if (temp == -2) {
          System.out.println("Unexpected Error");

          return;
        }
      }
    }

    if (temp == 0) {
      System.out.println("Four consecutive number has not been found");
      System.out.println("False");
    } else {
      System.out.println("Unexpected Error");
    }

    return;
  }
}