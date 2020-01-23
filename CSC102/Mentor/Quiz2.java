// /**
//  * Quiz2
//  */
// import java.util.Scanner;
// public class Quiz2 {

//     public static void main(String[] args) {
        
//         patt();

//     }
//     public static void quiz1(){
//         Scanner sc = new Scanner(System.in);
//         int price = sc.nextInt();
//         int money = sc.nextInt();

//         int change = money-price;

//         if(change<0) System.out.println("Not enough cash");
//         else {
//             System.out.println("1000 notes : " + change/1000);
//             change = change%1000;
//             System.out.println("500 notes : " + change/500);
//             change = change%500;
//             System.out.println("100 notes : " + change/100);
//             change = change%100;
//             System.out.println("50 notes : " + change/50);
//             change = change%50;
//             System.out.println("20 notes : " + change/20);
//             change = change%20;
//             System.out.println("10 coins : " + change/10);
//             change = change%10;
//             System.out.println("5 coins : " + change/5);
//             change = change%5;
//             System.out.println("2 coins : " + change/2);
//             change = change%2;
//             System.out.println("1 coins : " + change/1);
//             change = change%1;
//         }
//     }
//     public static void quiz2() {
//         Scanner sc = new Scanner(System.in);
//         String country = sc.nextLine().toLowerCase();
//         String result = "";
//         switch(country){
//             case "brunei":
//                 result = "Bandar Seri Begawan";
//                 break;
//             case "cambodia":
//                 result = "Phnom Penh";
//                 break;
//             case "indonesia":
//                 result = "Jakarta";
//                 break;
//             case "laos":
//                 result = "Vientiane";
//                 break;
//             case "malaysia":
//                 result = "Kuala Lumpur";
//                 break;
//             case "myanmar":
//                 result = "Naypyidaw";
//                 break;
//             case "philippines":
//                 result = "Manila";
//                 break;
//             case "singapore":
//                 result = "Singapore";
//                 break;
//             case "thailand":
//                 result = "Bangkok";
//                 break;
//             case "vietnam":
//                 result = "Hanoi";
//                 break;
//         }
//         System.out.println(result);
//     }

//     public static void patt(){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         System.out.println("");
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print("-");
//             }
//             System.out.print("o");
//             System.out.println("");
//         }
//     }

// }