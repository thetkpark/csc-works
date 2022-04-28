package csc319.j4module.class1demo;

public class HiLow {
    private final int diceFace;

    public HiLow() {
        this.diceFace = (int) (Math.random() * 6);
    }

    public int getDiceFace() {
        return diceFace;
    }
}
