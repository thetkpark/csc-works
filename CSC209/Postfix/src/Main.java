import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        String[] spited = infix.split(" ");
        System.out.println("");
        ArrayList<String> postfix = new ArrayList<>();
        Stack<String> s = new Stack<>();
        int count = 0;
        for(int i=0;i<spited.length;i++){
            String letter = spited[i];
            if(isOperator(letter)){
                if(letter.equals("+")|| letter.equals("-")){
                    while(!s.isEmpty() && (s.peek().equals("*") || s.peek().equals("*") || s.peek().equals("^"))){
                        String temp = s.pop();
                        postfix.add(temp);
                    }
                    s.push(letter);
                }
                else if(letter.equals("*") || letter.equals("/")){
                    while(!s.isEmpty() && (s.peek().equals("+") || s.peek().equals("-"))){
                        String temp = s.pop();
                        postfix.add(temp);
                    }
                }
                s.push(letter);
            }
            else if(isOperand(letter)){
                postfix.add(letter);
            }
            else if(isOpenParenthesis(letter)){
                s.push(letter);
            }
            else if(isCloseParenthesis(letter)){
                while(s.peek().equals("(")){
                    String temp = s.pop();
                    postfix.add(temp);
                }
            }

            if(count == infix.length()){ // End of the infix input
                while(!s.isEmpty()){
                    String temp = s.pop();
                    postfix.add(temp);
                }
            }
            count++;
        }

        Iterator it = postfix.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

    }

     public static boolean isOperator(String letter) {
        String[] operand = {"+", "-", "*", "/", "^"};
        return Arrays.asList(operand).contains(letter);
     }

     public static boolean isOperand(String letter) {
         try {
             Double.parseDouble(letter);
             return true;
         } catch(NumberFormatException e){
             return false;
         }
     }

     public static boolean isOpenParenthesis(String letter){
        return letter.equals("(");
     }

     public static boolean isCloseParenthesis(String letter){
        return letter.equals(")");
    }

}
// 6 * 7 + 10 / 4