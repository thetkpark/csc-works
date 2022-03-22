package Strategy;

public class Increment implements WarpBehavior {
    @Override
    public int warp(int n) {
        return ++n;
    }
}
