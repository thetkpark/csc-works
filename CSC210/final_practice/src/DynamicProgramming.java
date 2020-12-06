public class DynamicProgramming {

    public static boolean[][] warshall(boolean[][] graph){
        int n = graph.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    graph[j][k] = graph[j][k] || (graph[i][k] && graph[j][i]);
                }
            }
        }
        return graph;
    }

    public static int[][] floyd(int[][] graph){
        int n = graph.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    graph[j][k] = Math.min(graph[j][k], graph[i][k] + graph[j][i]);
                }
            }
        }
        return graph;
    }
}
