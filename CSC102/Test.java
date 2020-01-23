/**
 * Test
 */
public class Test {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1(){
        int n = 5;
        String s = "boy";
        System.out.println(5 + s + 5);
    }

    public static void test2() {
        //why 'B' + 5 != c + 5
        int n = 5;
        char c = 'B' + 5;
        //char result = n + c;
        System.out.println(c);
    }


    
}