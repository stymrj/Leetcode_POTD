class Solution {
    public int minDeletionSize(String[] strs) {
        int l = strs[0].length();
        String str = "";
        for(int i = 0; i < strs.length; i++) {
            str += strs[i];
        }
        int ans = 0;
        for(int i = 0; i < l; i++) {
            for(int j = i; j < str.length() - l; j += l) {
                if(str.charAt(j) > str.charAt(j + l)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
