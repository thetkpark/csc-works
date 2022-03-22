package Strategy;

public class Main {
    public static void main(String[] args) {
        CustomWarp decrementer = new Decrementer();
        CustomWarp incrementer = new Incrementer();

        System.out.println("-----Decrementer Warp Behavior-----");
        decrementer.warpAt(1);
        decrementer.warpAt(10);

        System.out.println("-----Incrementer Warp Behavior-----");
        incrementer.warpAt(1);
        incrementer.warpAt(10);
    }
}
