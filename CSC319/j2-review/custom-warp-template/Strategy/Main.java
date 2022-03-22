package Strategy;

public class Main {
    public static void main(String[] args) {
        CustomWarp decremeter = new Decremeter();
        CustomWarp incremeter = new Incremeter();

        System.out.println("-----Decrementer Warp Behavior-----");
        decremeter.warpAt(1);
        decremeter.warpAt(10);

        System.out.println("-----Incremeter Warp Behavior-----");
        incremeter.warpAt(1);
        incremeter.warpAt(10);
    }
}
