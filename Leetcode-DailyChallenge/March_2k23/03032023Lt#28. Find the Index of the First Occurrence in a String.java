//28. Find the Index of the First Occurrence in a String

//Java
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