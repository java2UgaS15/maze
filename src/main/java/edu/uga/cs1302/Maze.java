//File name: /home/profs/tyi/Courses/cs1302/maze/src/main/java/edu/uga/cs1302/Maze.java
package edu.uga.cs1302;

import java.util.*;
import java.io.*;

public class Maze {
   private static final int TRIED = 2;
   private static final int PATH = 3;

   private int numRows, numCols;
   private int[][] grid;

   public Maze(String filename) throws FileNotFoundException {
       Scanner scan = new Scanner(new File(filename));
       numRows = scan.nextInt();
       numCols = scan.nextInt();

       grid = new int[numRows][numCols];
       for (int i = 0; i < numRows; i++)
           for (int j = 0; j < numCols; j++)
               grid[i][j] = scan.nextInt();
   }

   public int getRows() {
       return numRows;
   }
   
   public int getCols() {
       return numCols;
   }

   public void markAsTried(int row, int col) {
       grid[row][col] = TRIED;
   }

   public void markAsPath(int row, int col) {
       grid[row][col] = PATH;
   }

   public boolean validPosition(int row, int col) {
       boolean result = false;

       if (row >= 0 && row < numRows &&
           col >= 0 && col < numCols) 
          if (grid[row][col] == 1)
             result = true;

       return result;
   }

   public String toString() {
       String result = "\n";
       for (int row = 0; row < numRows; row++) {
           for (int col = 0; col < numCols; col++)
               result += grid[row][col] + " ";
           result += "\n";
       }

       return result;
   }
}
