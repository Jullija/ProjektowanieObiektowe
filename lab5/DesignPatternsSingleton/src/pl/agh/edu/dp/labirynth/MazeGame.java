package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public Maze createMaze(MazeBuilder builder) throws Exception{
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        
        builder.addRoom(r1);
        builder.addRoom(r2);
        builder.addCommonWall(r1, r2, Direction.North);
        builder.addDoor(r1, r2);

        return builder.getCurrentMaze();
    }
}
