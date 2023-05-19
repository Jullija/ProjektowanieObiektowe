package pl.agh.edu.dp.labirynth;

public class BombedRoom extends Room{
    public BombedRoom(int num){
        super(num);
    }


    @Override
    public void Enter() {
        System.out.println("Entered bombed room");
    }
}
