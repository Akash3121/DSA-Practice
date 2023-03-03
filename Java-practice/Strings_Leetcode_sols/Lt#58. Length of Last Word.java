//58. Length of Last Word

//Java
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length()-1;
        while (i >=0){
            if (s.charAt(i) != ' '){
                break;
            }
            i--;
        }
        for(int j = i; j>=0; j--){
            if (s.charAt(j) == ' '){
                break;
            }
            len++;
        }
        return len;
    }
}