//28. Find the Index of the First Occurrence in a String

//KMP - Knuth–Morris–Pratt Algorithm
class Solution {
    public int strStr(String haystack, String needle) {
        // KMP algorithm

        int m = needle.length();
        int n = haystack.length();

        if (n < m){ //if haystack length is less than needle length 
            return -1;
        }

        //preprocessing
        //longest_border_array 
        int[] longest_border = new int[m];

        int prev = 0;

        //Iterating from index-1, longest_border[0] will always be 0
        int i = 1;

        while (i < m){
            if (needle.charAt(i) == needle.charAt(prev)){
                //length of longest border increased
                prev += 1;
                longest_border[i] = prev;
                i += 1;
            }
            else{ //not matched
                //only empty border exist
                if (prev == 0){
                    longest_border[i]=0;
                    i += 1;
                }
                else{
                    // try finding longest border for this i  with reduced prev
                    prev = longest_border[prev-1];
                }
            }
        }

        //searching
        //pointer for haystack
        int haystackPointer = 0;
        //pointer for needle
        int needlePointer = 0; //also indicates no.of characters matched in current window

        while (haystackPointer < n){
            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)){ //match
                //matched - increment both
                haystackPointer ++;
                needlePointer ++;

                //all matched
                if (needlePointer == m){ //m is needle length
                    return haystackPointer - m; //since m chars behind, will be window start
                }
            }
            else{ //donot match 
                if (needlePointer == 0){
                    //nothing or zero matched - not even first character matched
                    haystackPointer ++;
                }
                else{ //some characters matched
                    //shift needlePointer, don't change haystackPointer
                    needlePointer = longest_border[needlePointer - 1];
                }
            }
        }

        return -1;
    }
}

//sliding window
class Solution {
    public int strStr(String haystack, String needle) {
        // tc: O(nm)
        // sc: O(1)
       //sliding window 
       int m = needle.length();
       int n = haystack.length();

        //n times
       for(int windowStart = 0; windowStart <= n - m; windowStart++){ //or < n-m+1
           for (int i = 0; i < m; i++){ //m times
               if (needle.charAt(i) != haystack.charAt(windowStart+i)){
                   break;
               }
               if (i == m-1){ // last index also matched for needle(m)
                return windowStart;
               }
           }
       }
       return -1; 
    }
}

//Java
class Solution {
    public int strStr(String haystack, String needle) {
        String res = haystack.replaceFirst(needle, "*");
        for(int i = 0; i < res.length(); i++){
            if (res.charAt(i) == '*'){
                return i;
            }
        }
        return -1;
    }
}

//Java
class Solution {
    public int strStr(String haystack, String needle) {
        //TC is more not good approach
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) { //n times
            if (haystack.charAt(i) == needle.charAt(0)){ //if first letter matched
                for (int j = 0; (i+j) < haystack.length() && j < needle.length(); j++) { //n times 
                    if ( haystack.charAt(i+j) == needle.charAt(j)){
                        if (j == needle.length()-1){
                            return i;
                        }
                    }
                    else{ //if any char not matching
                        // i = i+j-1;
                        break;
                    }
                }
            }
            
        }

        return -1;
    }
}
