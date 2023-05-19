package pl.agh.edu.dp.labirynth;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }

    public Maze createMaze(StandardBuilderMaze builder, MazeFactory factory) throws Exception {
        Room r1 = new Room(1), r2 = new Room(2);
        builder.addRoom(r1);
        builder.addRoom(r2);
        builder.addCommonWall(r1, r2, Direction.North);
        builder.addDoor(r1, r2);
        return builder.getCurrentMaze();
    }
}
