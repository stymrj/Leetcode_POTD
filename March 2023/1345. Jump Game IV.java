/*
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

Constraints:

1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108
*/

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> valIndex = new HashMap();
        for (int i = 0; i < n; i++){
            valIndex.computeIfAbsent(arr[i], l -> new ArrayList()).add(i);
        }
        
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet();

        q.add(0);
        visited.add(0);
        int steps = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int i = q.poll();
                if (n-1 == i){
                    return steps;
                }
                List<Integer> addList = valIndex.get(arr[i]);
                addList.add(i-1);
                addList.add(i+1);
                for(int j: addList){
                    if (j >= 0 && j < n && !visited.contains(j)){
                        q.add(j);
                        visited.add(j);
                    }
                } 
                addList.clear(); 
            }
            steps ++;
        }
        return -1;
    }
}
