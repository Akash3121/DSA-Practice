//74. Search a 2D Matrix

//linear m+n - didn't submitted as they asked for log(m+n) sol
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length; //rows
        int n = mat[0].length; //cols

        //starting with first row last element
        int row = 0;
        int col = n - 1;
        //O(m+n)
        while (row < m && col < n && row >= 0 && col >= 0){
            if (mat[row][col] == target){
                return true;
            } else if (mat[row][col] > target){
                col --;
            } else { //mat[row][col] < target 
                row ++;
            }
        }
        return false;
        
    }
}

//binary search O(log(m*n))
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int row = mat.length - 1;
        int col = mat[0].length - 1;
        int cMid = col / 2;

        //before going through binary search check if only only 1 row is there then go fir binary search
        if (row == 0){// only one row
            return binarySearch(mat, target, row, 0, col);
        }
        // binary search in row i.e., log(m)
        int rStart = 0;
        int rEnd = row;

        while (rStart < rEnd - 1) {
            int mid = rStart + (rEnd - rStart) / 2;

            if (mat[mid][cMid] == target) {
                return true;
            } else if (mat[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }
        // rStart has the correct value, to use the next roww rStart + 1

        // now we need to check in the remaining 2 rows
        // 1,2,3,4
        // 5,6,7,8 here cMid = 1
        boolean ans = false;
        // 4 cases
        // case - 1: rStart row -> before cMid
        if (target <= mat[rStart][cMid]) {

            ans = binarySearch(mat, target, rStart, 0, cMid);
            if (ans) {
                return ans;
            }
        } // case - 2: rStart row -> after cMid till end col
        else if (mat[rStart][cMid] < target && target <= mat[rStart][col]) {
            ans = binarySearch(mat, target, rStart, cMid + 1, col);
            if (ans)
                return ans;
        } // case - 3: rStart + 1 row -> before cMid
        else if (target <= mat[rStart + 1][cMid]) {
            ans = binarySearch(mat, target, rStart + 1, 0, cMid);
            if (ans)
                return true;
        } // case - 4: rStart + 1 row -> cMid + 1 till end
        else {
            ans = binarySearch(mat, target, rStart + 1, cMid + 1, col);
            if (ans)
                return true;
        }

        return ans;
    }

    // column wise binary search with row fixed
    public boolean binarySearch(int[][] mat, int target, int row, int cStart, int cEnd) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (mat[row][mid] == target) {
                return true;
            } else if (mat[row][mid] < target) {
                cStart = mid + 1;
            } else { // mat[row][mid] > target
                cEnd = mid - 1;
            }
        }
        return false;
    }
}