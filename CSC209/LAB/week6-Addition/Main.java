public class Main {

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(6);
        s.push(10);
        s.push(301);
        s.push(4);
        System.out.println(s.pop() + " " + s.getSize());
        System.out.println(s.pop() + " " + s.getSize());
        System.out.println(s.pop() + " " + s.getSize());
        System.out.println(s.pop() + " " + s.getSize());
        System.out.println(s.pop() + " " + s.getSize());
        System.out.println(s.pop() + " " + s.getSize());

        AddLargeNumber cal = new AddLargeNumber(10);
        System.out.println(cal.add("1253453453","762964753"));




    }
}
