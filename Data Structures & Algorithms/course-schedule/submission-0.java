class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int next : graph.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.offer(next);
            }
        }
        return count == numCourses;
    }
}
