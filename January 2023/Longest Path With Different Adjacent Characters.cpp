class Solution {
public:
    int ans=1;
    int dist[100005];
    int longestPath(vector<int>& parent, string s) {
        
        int n = parent.size();
        vector<vector<int>> adj(n);
        //covert the parent array to adjacency matrix
        for(int i=1;i<n;i++)
        {
            adj[parent[i]].push_back(i);
        }
       
        dfs(0,s,adj);
        return ans;
    }
    void dfs(int src, string& s, vector<vector<int>> &adj)
    {
        dist[src] = 1;
        for(int node: adj[src])
        {
            dfs(node,s,adj);
            if(s[src]!=s[node])
            {
                ans = max(ans,dist[src]+dist[node]);
                dist[src] = max(dist[src],dist[node]+1);
            }
        }
    }
};
