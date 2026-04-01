class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList();
        int count = 0;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        } 
        boolean[] visited = new boolean[n];
        boolean[] cycle = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
            }
            dfs(graph,visited,cycle,i);
        }
        return count;
    }

    public void dfs( List<List<Integer>> graph, boolean[] visited, boolean[] cycle,  int parent ){
        if(cycle[parent]){
            return;
        }
        visited[parent] = true;
        cycle[parent]= true;
        for(int edge : graph.get(parent)){
            if(!cycle[edge]){
                dfs(graph,visited,cycle,edge);
            }
        }
    }
}
