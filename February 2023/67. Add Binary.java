/*
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

class Solution {
    public String addBinary(String a, String b) {

        int aPos = a.length()-1;
        int bPos = b.length()-1;
        boolean one = false;
        
        StringBuilder sb = new StringBuilder();

        while(0 <= aPos || 0 <= bPos){
            int count = one? 1 : 0;
            if(0 <= aPos && a.charAt(aPos) == '1') count++;
            if(0 <= bPos && b.charAt(bPos) == '1') count++;
            
            if(2 <= count) one = true;
            else one = false;
            
            if(2 == count) sb.append('0');
            if(3 == count) sb.append('1');
            if(1 == count) sb.append('1');
            if(0 == count) sb.append('0');

            aPos--;
            bPos--;
        }

        if(one) sb.append('1');

        return sb.reverse().toString();
    }
}
