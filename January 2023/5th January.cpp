class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        vector<pair<int, int> > v;
        pair<int, int> p;
        p.first = points[0][0];
        p.second = points[0][1];
        for(int i = 1; i < points.size(); i++) {
            if(points[i][0] >= p.first && points[i][0] <= p.second) {
                p.second = min(p.second, points[i][1]);
            }
            else {
                v.push_back(p);
                p.first = points[i][0];
                p.second = points[i][1];
            }
        }
        v.push_back(p);
        return v.size();
    }
};
