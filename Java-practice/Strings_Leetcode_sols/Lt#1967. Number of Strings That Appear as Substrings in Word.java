//1967. Number of Strings That Appear as Substrings in Word

//Java
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int k = 0;
        for (int i = 0; i < patterns.length; i++){ //
            if (word.contains(patterns[i])){
                k++;
            }
        }
        return k;
    }
}

#python
class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        return sum(p in word for p in patterns)
        