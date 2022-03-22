package Strategy;

public class CustomWarp {
    protected WarpBehavior warpBehavior;

    public void warpAt(int n) {
        int warpedN = warpBehavior.warp(n);
        System.out.println(n + " is warped to " + warpedN);
    }

    public void setWarpBehavior(WarpBehavior warpBehavior) {
        this.warpBehavior = warpBehavior;
    }
}
