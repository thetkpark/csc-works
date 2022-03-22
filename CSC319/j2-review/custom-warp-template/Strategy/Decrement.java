package Strategy;

public class Decrement implements WarpBehavior {
    @Override
    public int warp(int n) {
        return --n;
    }
}
