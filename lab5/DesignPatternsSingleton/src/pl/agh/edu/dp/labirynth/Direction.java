package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public Direction getOppositeSide(Direction direction) {
        return switch(direction){
            case North -> South;
            case South -> North;
            case West -> East;
            case East -> West;
        };
    }

}

