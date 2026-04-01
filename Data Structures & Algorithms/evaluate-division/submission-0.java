class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            String a = edge.get(0);
            String b = edge.get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String src = q.get(0), dst = q.get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                ans[i] = -1.0;
            } else if (src.equals(dst)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(src, dst, graph, visited);
            }
        }

        return ans;
    }

    private double dfs(String src, String dst, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (src.equals(dst)) return 1.0;
        visited.add(src);

        Map<String, Double> neighbors = graph.get(src);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            double weight = entry.getValue();

            if (visited.contains(next)) continue;

            double productFromNext = dfs(next, dst, graph, visited);
            if (productFromNext != -1.0) {
                // found a valid path: src -> next -> ... -> dst
                return weight * productFromNext;
            }
        }

        return -1.0;
    }
}
