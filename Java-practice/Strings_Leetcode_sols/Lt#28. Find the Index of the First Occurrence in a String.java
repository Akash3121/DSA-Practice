//28. Find the Index of the First Occurrence in a String

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
