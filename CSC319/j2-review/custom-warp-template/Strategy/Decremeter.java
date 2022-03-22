package Strategy;

public class Decremeter extends CustomWarp {

    public Decremeter() {
        this.warpBehavior = new Decrement();
    }
}
