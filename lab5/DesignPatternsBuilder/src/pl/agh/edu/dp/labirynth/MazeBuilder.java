package pl.agh.edu.dp.labirynth;

public interface MazeBuilder {
    void addRoom(Room room);
    void addCommonWall(Room room1, Room room2, Direction direction) throws Exception;
    void addDoor(Room room1, Room room2) throws Exception;
     Maze getCurrentMaze();

}
