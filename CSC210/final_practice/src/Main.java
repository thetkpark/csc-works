public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean[][] graph2 = new boolean[4][4]; // Warshall
        int[][] graph1 = new int[4][4]; // Floyd

        graph1[0][0] = 0; graph1[0][1] = 9999999; graph1[0][2] = 3; graph1[0][3] = 9999999;
        graph1[1][0] = 2; graph1[1][1] = 0; graph1[1][2] = 9999999; graph1[1][3] = 9999999;
        graph1[2][0] = 9999999; graph1[2][1] = 7; graph1[2][2] = 0; graph1[2][3] = 1;
        graph1[3][0] = 6; graph1[3][1] = 9999999; graph1[3][2] = 9999999; graph1[3][3] = 0;

        graph2[0][0] = false; graph2[0][1] = false; graph2[0][2] = true; graph2[0][3] = false;
        graph2[1][0] = true; graph2[1][1] = false; graph2[1][2] = false; graph2[1][3] = true;
        graph2[2][0] = false; graph2[2][1] = false; graph2[2][2] = false; graph2[2][3] = false;
        graph2[3][0] = false; graph2[3][1] = true; graph2[3][2] = false; graph2[3][3] = false;



        int[] array = {5, 20, 10, 3, 4, 9 ,23, 50, 5, 9};
        int[] countingSortResult = SpaceTime.countingSort(array);
        int[] distributionCountResult = SpaceTime.distributionCount(array);
        int[] distributeSortChingly = SpaceTime.distributionCount2(array);
        printArray(distributeSortChingly);
//        printArray(countingSortResult);
//        printArray(distributionCountResult);

//        graph = DynamicProgramming.warshall(graph2);
//        graph1 = DynamicProgramming.floyd(graph1);
//
//        for(int i=0;i<graph.length;i++){
//            for(int j=0;j<graph.length;j++){
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println("");
//        }

        String sentense = "Note is craving for some anan";
        String pattern = "anan";
//        System.out.println(SpaceTime.horspool(sentense, pattern));

    }

    public static void printArray(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
    }



}
