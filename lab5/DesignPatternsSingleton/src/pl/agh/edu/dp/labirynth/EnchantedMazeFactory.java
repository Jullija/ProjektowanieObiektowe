package pl.agh.edu.dp.labirynth;

public class EnchantedMazeFactory extends MazeFactory{

    private static EnchantedMazeFactory instance;
    public EnchantedMazeFactory(){
        super();
    }

    public static EnchantedMazeFactory getInstance(){
        if( instance == null){
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new EnchantedDoor(r1, r2);
    }

    @Override
    public Room createRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

}
