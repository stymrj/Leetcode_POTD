class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int[] x : edges){
            adj[x[0]].add(x[1]);
            adj[x[1]].add(x[0]);
        }
        return dfs(-1, 0, adj, hasApple);
    }
    private int dfs(int prev, int curr, ArrayList<Integer>[] adj, List<Boolean> hasApple) {
        int ans = 0;
        for(int x : adj[curr]) {
            if(x != prev) {
               int res = dfs(curr, x, adj, hasApple);
               if(res > 0 || hasApple.get(x)) {
                   ans += (res + 2);
               }
            }
        }
        return ans;
    }
}
