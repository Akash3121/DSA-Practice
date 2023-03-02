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

//Java - better approach using StringBuilder
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder s = new StringBuilder();
        while(i < word1.length() || j < word2.length()){
            if (i < word1.length()){
                s.append(word1.charAt(i++));
            }
            if (j < word2.length()){
                s.append(word2.charAt(j++));
            }
        }

        return s.toString();
    }
}