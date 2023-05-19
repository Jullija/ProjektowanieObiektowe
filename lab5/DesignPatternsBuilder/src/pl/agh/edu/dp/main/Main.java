package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) throws Exception{

        MazeGame mazeGame = new MazeGame();
        MazeBuilder builder = new StandardBuilderMaze();
        Maze maze = mazeGame.createMaze((StandardBuilderMaze) builder);

        System.out.println(maze.getRoomNumbers());
    }
}



