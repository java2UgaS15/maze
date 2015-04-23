package edu.uga.cs1302;

import java.io.*;

public class App {
    public static void main( String[] args) throws FileNotFoundException {
        Maze maze = new Maze(args[0]);
        MazeSolver solver = new MazeSolver(maze);

        if (solver.traverse(0, 0))
           System.out.println("The maze was successfully traversed."); 
        else System.out.println("There is no solution to this maze.");

        System.out.println(maze);
    }
}
