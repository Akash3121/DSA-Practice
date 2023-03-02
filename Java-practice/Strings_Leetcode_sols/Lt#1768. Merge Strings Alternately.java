//1768. Merge Strings Alternately

//Java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        String s = "";
        while(i < word1.length() && j < word2.length()){
            s += word1.charAt(i++);
            s += word2.charAt(j++);
        }

        while(i < word1.length()){
            s += word1.charAt(i++);
        }

        while(j < word2.length()){
            s += word2.charAt(j++);
        }

        return s;
    }
}