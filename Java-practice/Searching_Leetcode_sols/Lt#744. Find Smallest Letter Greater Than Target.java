//744. Find Smallest Letter Greater Than Target

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        
        //no change in BS algo
        while(start <= end){
            //find the middle element
            //int mid = (start + end)/2 - here start + end might be exceed the max int value in java
            int mid = start + (end - start) / 2;

            if (target < letters[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];//if no greatest elem greater than target in array, then return first char in letters array i.e., letters[0], whicj is start%n
    }
}