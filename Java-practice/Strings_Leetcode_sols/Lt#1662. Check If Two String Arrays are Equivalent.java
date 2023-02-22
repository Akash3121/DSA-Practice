//1662. Check If Two String Arrays are Equivalent

//Java
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String w1=" ";
        String w2=" ";
        for (int i = 0; i < word1.length; i++){
            w1 += word1[i];
        }
        for(int i = 0; i < word2.length; i++){
            w2 += word2[i];
        }
        
        return w1.equals(w2);
        
    }
}

#python
class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        return "".join(word1) == "".join(word2)