package pl.agh.edu.dp.labirynth;

public class CountingMazeBuilder implements MazeBuilder {
    private int elementsNumber = 0;
    private Maze currentMaze;

    @Override
    public void addRoom(Room room) {
        elementsNumber += 5;

    }

    @Override
    public void addDoor(Room r1, Room r2) throws Exception {
        elementsNumber++;
    }

    @Override
    public void addCommonWall(Room r1, Room r2, Direction roomDirection) throws Exception {
        elementsNumber--;
    }

    public int GetCounts() {
        return elementsNumber;
    }

    public Maze getCurrentMaze() {
        return this.currentMaze;
    }
}
