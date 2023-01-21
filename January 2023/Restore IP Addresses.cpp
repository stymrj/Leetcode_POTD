/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:
Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
Constraints:
1 <= s.length <= 20
s consists of digits only.
*/




class Solution {
public:
    bool isvalid(string t){
        //three condtions to check
        
          //if t ka size() is 4 digits or if empty string
        if(  t.size()>3 or t.size()==0) return false;

        // if t>255 out of range
         if(t.size() && stoi(t)>255) return 0; //first check size of t then check for stoi() func
         // if if checks direct and let say if size()==0  and  we keep check forn stoi() leads to dikkat:)


          //first char is zero means trailing zero bali condition
        if(t.size()>1 and t[0]=='0') return 0;
       
       
        return true;

    }
    void solve(string &s,int in,int dots,vector<string>& an,string inner){
        if(dots==3){ //BC
            if(isvalid(s.substr(in))){
                an.push_back(inner+s.substr(in));
            }
            return;
        }

        //recur calls
        for(int i=in;i<s.size();i++){
            if(isvalid(s.substr(in,i-in+1))){
                //if is valid  returns true then
                inner.push_back(s[i]);
                inner.push_back('.');
                solve(s,i+1,dots+1,an,inner);
                inner.pop_back();
            }
        }
        return ;

    }
    vector<string> restoreIpAddresses(string s) {
        vector<string> an;
        // int si=s.size();
        string inner;

        solve(s,0,0,an,inner); //first zero for index, second foer number of dots ,, when dots==3 then return ki condition chl pdegi

        
        return an;
    }

};
