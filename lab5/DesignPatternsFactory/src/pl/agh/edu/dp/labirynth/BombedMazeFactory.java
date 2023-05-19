package pl.agh.edu.dp.labirynth;

public class BombedMazeFactory extends MazeFactory {
    public BombedMazeFactory(){
        super();
    }
    @Override
    public Room createRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }
}
