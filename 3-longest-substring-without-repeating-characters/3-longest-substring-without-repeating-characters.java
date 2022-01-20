class Solution {
    public int lengthOfLongestSubstring(String s) {
        
         int ans=0;
        int i=0,j=0;
        HashMap<Character,Integer>hm= new HashMap<>();
        while(i<s.length()){
            char c= s.charAt(i);
            if(hm.containsKey(c)){
                j= Math.max(j,hm.get(c)+1);
            }
            hm.put(c,i);
            ans= Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}