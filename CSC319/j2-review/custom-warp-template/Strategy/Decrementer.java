package Strategy;

public class Decrementer extends CustomWarp {
    public Decrementer() {
        this.warpBehavior = new Decrement();
    }
}
