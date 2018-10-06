import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int cur = 1;
        int max = 1;
        int prev;
        int vis[] = new int[26];
        Arrays.fill(vis,-1);
        vis[s.charAt(0)-'a'] = 0;
        for(int i=1;i<n;i++){
            prev = vis[s.charAt(i)-'a'];
            if(prev==-1||i-cur>prev){
                cur++;
            }
            else{
                if(cur>max)
                    max = cur;
                cur = i-prev;
            }
            vis[s.charAt(i)-'a'] = i;
        }
        if (cur>max) max = cur;
        return max;
    }
}