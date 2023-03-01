//14. Longest Common Prefix

//Java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Logic: sort the array and then take first and last elements/strings (because after sorted the first has smallest length and last string has highest element)
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int index = 0;
        while (index < s1.length() && index < s2.length()){
            if (s1.charAt(index) == s2.charAt(index)){
                index++;
            }else{
                break;
            }
        }
        
        return s1.substring(0, index);
    }
}

#python3
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # Vertical algo: first take the first string in strs and iterate through it and then internally through each strs from 1 to length 
        prefix = ''

        if not strs:
            return prefix
        
        for i in range(len(strs[0])):
            char = strs[0][i]
            for j in range(1, len(strs)):
                if i == len(strs[j]) or char != strs[j][i]:
                    return prefix
            prefix += char


        return prefix

#python3
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        #Horizontal Algo: fixing the first string as prefix and checking with aother strings from 1 to length end if the string length till prefix length not matches then prefix last char is eliminated
        prefix = strs[0]

        for str in strs[1:]:
            while str[:len(prefix)] != prefix:
                prefix = prefix[:-1] #remove the last character

                if not prefix:
                    return ''
        
        return prefix