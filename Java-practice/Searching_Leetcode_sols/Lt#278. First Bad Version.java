//278. First Bad Version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //ex: 1,2,3,4,5
        //bad:f,f,f,t,t => so ans = 4
        int start = 1;
        int end = n;
        //binary search
        while (start < end){
            int mid = start + (end - start ) / 2;

            if (isBadVersion(mid)){//True
                end = mid;
            }
            else {//False
                start = mid + 1;
            }
        }
        return start; //here start = end 
    }
}