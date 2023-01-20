/*
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

    1 <= nums.length <= 15
    -100 <= nums[i] <= 100


*/
class Solution {
  vector<vector<int>> vect;
  set<vector<int>>s;
  void solve(vector<int> currVect,int lastValue,vector<int> nums,int currIndex){
    if(currVect.size()>=2)
      s.insert(currVect);

    if(currIndex>=nums.size())
      return;
  
    if(nums[currIndex]>=lastValue){
      solve(currVect,lastValue,nums,currIndex+1);
      currVect.push_back(nums[currIndex]);
      solve(currVect,nums[currIndex],nums,currIndex+1);
    }
    else{
      solve(currVect,lastValue,nums,currIndex+1);
    }
  }
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
      vector<int> currVect;
      solve(currVect,INT_MIN,nums,0);
      for(auto x:s){
        vect.push_back(x);
      }
      return vect;  
    }
};
