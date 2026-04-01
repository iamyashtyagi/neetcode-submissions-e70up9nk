// class Solution {
//     public boolean validTree(int n, int[][] edges) {
//         ArrayList<Integer>[] graph = new ArrayList<>[n];
//         for(int i=0;i<edges.length;i++){
//             graph.add(edges[i][1]-1);
//         }
//         boolean[] visited = new boolean[n];
//         for(int i=0;i<n;i++){
//             visited[i]=true;
//             if(!dfs(graph, visited,0)){
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int parent){
//         for(int child : graph[parent]){
//             if(visited[child-1]){
//                 return false;
//             }
//             dfs(graph,visited,child);
//         }
//         return true;
//     }
// }


class Solution {
    public boolean validTree(int n, int[][] edges) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        // build undirected graph
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // detect cycle
        if(!dfs(graph, visited, 0, -1)){
            return false;
        }

        // check connectivity
        for(boolean v : visited){
            if(!v) return false;
        }

        return true;
    }

    private boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int node, int parent){
        if(visited[node]) return false;

        visited[node] = true;

        for(int child : graph[node]){
            if(child == parent) continue;

            if(!dfs(graph, visited, child, node)){
                return false;
            }
        }
        return true;
    }
}