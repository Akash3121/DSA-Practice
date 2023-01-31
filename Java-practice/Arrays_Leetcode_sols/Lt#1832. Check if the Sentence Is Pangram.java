//1832. Check if the Sentence Is Pangram

//java
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] b = new boolean[26];
        for(char c: sentence.toCharArray()){
            b[c-'a'] = true;
        }
        for(boolean k: b){
            if(k!=true)
                return false;
        }
        return true;
    }
}

