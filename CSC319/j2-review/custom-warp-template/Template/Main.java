package Template;

public class Main {
    public static void main(String[] args) {
        CustomWarp incrementer = new Incrementer();
        CustomWarp decrementer = new Decrementer();

        System.out.println("-----Incrementer-----");
        incrementer.warpAt(2);
        incrementer.warpAt(5);
        incrementer.warpAt(10);

        System.out.println("-----Decrementer-----");
        decrementer.warpAt(1);
        decrementer.warpAt(6);
        decrementer.warpAt(0);
    }
}
