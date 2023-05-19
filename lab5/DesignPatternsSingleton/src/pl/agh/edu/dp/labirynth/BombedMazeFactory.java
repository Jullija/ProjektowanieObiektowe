package pl.agh.edu.dp.labirynth;

public class BombedMazeFactory extends MazeFactory {
    private static BombedMazeFactory instance;
    public BombedMazeFactory(){
        super();
    }

    public static BombedMazeFactory getInstance(){
        if( instance == null){
            instance = new BombedMazeFactory();
        }
        return instance;
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
