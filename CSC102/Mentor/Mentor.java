// import java.util.Scanner;

// public class Mentor {

//     public static void main (String[] args){
//     //     Scanner sc = new Scanner(System.in);
//     //     String str = sc.nextLine();
//     //     int len = str.length();
//     //     int half = (len/2)-1;
//     //     String result = "block";
//     //     if(len%2==0){

//     //         result = str.substring(half,half+2);
            
//     //     }

//     //     if(len%2!=0){
            
//     //         result = str.substring(half, half+3);
            
//     //     }

//     //     for(int i=0;i<result.length();i++){
//     //         if(result.charAt(i) == 'o'){
//     //             result = result.substring(0,i+1) + "o" + result.substring(i);
//     //         }
//     //     }

//     //     System.out.println(result);

//     ma(5,6,1);
        
//     }

//     public static boolean q1(){
//         boolean p = true;
//         boolean q = false;
//         boolean r = false;
//         boolean result = (!(p||q)&&r) || p && (p||(!r));

//         return result;
//     }
//     public static void q2(){
//         char element1 = 'a';
//         char element2 = 'B';
//         //97+66
//         int result = element1 + element2;
//         System.out.println((char) result);
//         String result2 = String.valueOf(element1) + String.valueOf(element2);
//         System.out.println(result2);
//     }

//     public static void q3(){
//         int a = 10;
//         float b = 11.1f;
//         double c = 12.11;
//         String d = "00";

//         int result = a + (int) b + (int) c;

//         System.out.println("" + result + d);
//     }

//     public static void q4(){
//         int n = 10;
//         int x = 13;
//         System.out.println(n+n+x+ ++x);
//     }

//     public static void q5(){
//         byte a = 100;
//         System.out.println((byte) (a+100));
//     }

//     // public static void quiz(str){
//     //     int len = str.length();
//     //     if(len%2!=0){
//     //         if(str.charAt(len/2) == 'o'){
//     //             String result = new String[len+1];
//     //             for(int i=0;i<=len/2;i++){
//     //                 result[i] = str[i];
//     //             }
//     //             result[(len/2)+1] = 'o';
//     //             for(int i=(len/2)+2;i<len+1;i++){
//     //                 result[i] = str[i];
//     //             }
//     //             return result;
//     //         }
//     //     }
//     // }

//     public static void ma(int a, int b, int c){
//         double[] ans = new double[2];
//         double temp = (b*b) - (4 * a *c);
//         if(temp<0) ans = ans;
//         else if(temp==0){
//             ans[0] = ((-b) + Math.sqrt(temp)) / (2*a);
            
//         }
//         else if(temp>0){
//             ans[0] = ((-b) + Math.sqrt(temp)) / (2*a);
//             ans[1] = ((-b) - Math.sqrt(temp)) / (2*a);
            
//         }
//         System.out.println(ans[0]);
//         System.out.println(ans[1]);
//     }
        
    
// }