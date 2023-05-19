package pl.agh.edu.dp.labirynth;

public class StandardBuilderMaze implements MazeBuilder{

    private Maze currentMaze;

    public StandardBuilderMaze(){
        this.currentMaze = new Maze();
    }
    @Override
    public void addRoom(Room room) {
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.South, new Wall());
        room.setSide(Direction.West, new Wall());
        currentMaze.addRoom(room);
    }

    @Override
    public void addDoor(Room room1, Room room2) throws Exception {
        Direction doorDirection = null;
        for (Direction dir : Direction.values()){
            if (room1.getSide(dir).equals(room2.getSide(dir.getOppositeSide(dir)))){
                doorDirection = dir;
                break;
            }
        }

        if (doorDirection == null){
            throw new Exception("Not common door");
        }
        else{
            Door door = new Door(room1, room2);
            room1.setSide(doorDirection, door);
            Direction r2Direction = room1.getOppositeSide(doorDirection);
            room2.setSide(r2Direction, door);
        }
    }

    @Override
    public void addCommonWall(Room room1, Room room2, Direction direction) throws Exception{
        MapSite r1Side= room1.getSide(direction);
        if (r1Side == null){
            throw new Exception("Not common wall");
        }
        room2.setSide(direction.getOppositeSide(direction), r1Side);
    }

    public Maze getCurrentMaze() {
        return this.currentMaze;
    }
}
