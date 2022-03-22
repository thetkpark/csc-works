package Template;

public abstract class CustomWarp {
    public void warpAt(int n) {
        int warpedN = warp(n);

        System.out.println(n + " is warped to " + warpedN);
    }

    protected abstract int warp(int n);
}