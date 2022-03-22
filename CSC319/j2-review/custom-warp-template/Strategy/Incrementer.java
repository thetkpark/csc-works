package Strategy;

public class Incrementer extends CustomWarp{
    public Incrementer() {
        this.warpBehavior = new Increment();
    }
}
