package pl.agh.edu.dp.labirynth;

public class EnchantedMazeFactory extends MazeFactory{

    public EnchantedMazeFactory(){
        super();
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
