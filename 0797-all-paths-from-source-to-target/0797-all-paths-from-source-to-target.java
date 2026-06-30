import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, path, ans);
        return ans;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> ans) {
        path.add(node);

        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int next : graph[node]) {
                dfs(graph, next, path, ans);
            }
        }

        path.remove(path.size() - 1);
    }
}