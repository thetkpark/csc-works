package Strategy;

public class Incremeter extends CustomWarp{

    public Incremeter() {
        this.warpBehavior = new Increment();
    }
}
