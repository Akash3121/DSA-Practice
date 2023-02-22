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

#python
class Solution:
    def freqAlphabets(self, s: str) -> str:
        # check for s[i+2] = "#" then s[i to i+1] is the values 
        # else i is the value
        res = []
        i = 0
        while i < len(s):
            if i+2 < len(s) and s[i+2] == "#":
                val = int(s[i:i+2])
                res.append(chr(val + 96)) #+96 is for the a is 97 so 96 + the val
                i += 3
            else:
                res.append(chr(int(s[i]) + 96))
                i += 1

        return ''.join(res)