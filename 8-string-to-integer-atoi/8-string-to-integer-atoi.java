class Solution {
    public int myAtoi(String s) {
        long num = 0;
        boolean negative = false;
        char ch;
        int i=0;
        // skip leading whitespace
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        int length = s.length();
        if(i==length){
            return 0;
        }
        // handle sign +-
        ch = s.charAt(i);
        if(ch=='-'){
            negative=true;
            i++;
        }else if(ch=='+'){
            i++;
        }
        // skip leading zero
        while(i<s.length() && s.charAt(i)=='0'){
            i++;
        }
        // -2^31=-2147483648
        // 2^31-1=2147483647
        // only 10 chars, so we calculate 11 chars. To avoid num (long type) overflow
        if(length>i+11){
            length = i+11;
        }
        for(;i<length;i++){
            ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                num=num*10+ch-'0';
            }else{
                break;
            }
        }
        if(negative){
            num = -num;
        }
        if(num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)num;
    }
}