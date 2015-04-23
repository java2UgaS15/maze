//File name: /home/profs/tyi/Courses/cs1302/maze/src/main/java/edu/uga/cs1302/MazeSolver.java
package edu.uga.cs1302;

public class MazeSolver {
    private Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public boolean traverse(int row, int col) {
        boolean done = false; //not finish traversing the maze yet.

        int numRows = maze.getRows();
        int numCols = maze.getCols();
        if (maze.validPosition(row, col)) {
           maze.markAsTried(row, col);

           if (row == numRows-1 && col == numCols-1)
              done = true;
           else {
                 done = traverse(row+1, col); //try downside neighbor
                 if (!done)
                    done = traverse(row, col+1); //try rightside neighbor
                 if (!done)
                    done = traverse(row-1, col); //try upside neighbor
                 if (!done)
                    done = traverse(row, col-1); //try left neighbor
           }

           if (done) //this location is part of the final path
              maze.markAsPath(row, col);
        }
        return done;
    }
}
