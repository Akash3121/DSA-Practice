//1309. Decrypt String from Alphabet to Integer Mapping

//Java
class Solution {
    public String freqAlphabets(String s) {
        // first do for # then for 1-9
        for (int i = 10; i <= 26; i++){
            s = s.replaceAll(i+"#", (char)('a'+(i-1)) + "");
        }
        for (int i = 1; i <= 9; i++){
            s = s.replaceAll(i+"", (char)('a' + (i-1)) +"");
        }
        return s;
    }
}