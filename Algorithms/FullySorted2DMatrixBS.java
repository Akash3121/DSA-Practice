import java.util.Arrays;

// Algorithm: (using 2 binary search) O(logn) {i.e., logn + 4logm}
// first binary search, used to reduce rows, taking middle column(cMid) as mid to check with target
// then, we remain with 2 rows, check in that mid column with target, if target not present
// then we have 4 cases:
// 1 - first row(rStart) before mid
// 2 - first row(rStart) after mid and less than last col
// 3 - second row(rStart + 1) before mid
// 4 - second row(rStart + 1) after mid
// do a binary search in each row for these 4 cases

//example: target = 3
// \  0, 1, 2, 3
// 0  1, 2, 3, 4
// 1  5, 6, 7, 8
// 2  9,10,11,12
// 3 13,14,15,16

// first bs gives rStart = 0, so the rows left are 0, 1
// 1,2,3,4
// 5,6,7,8
//cMid = 1, so checking 2,6 elements with target
// then bs for 1
// then bs for 3,4 - here we get the ans since 3 is present


public class FullySorted2DMatrixBS {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(Arrays.toString(search(mat, 7)));

    }

    static int[] search(int[][] mat, int target) {
        int row = mat.length - 1;
        int col = mat[0].length - 1; // becautious matrix may be empty
        int cMid = col / 2;

        // binary search for finalizing 2 rows
        int rStart = 0;
        int rEnd = row; 
        
        //run this loop till 2 rows are remaining
        while (rStart < rEnd - 1) { // if rStart <= rEnd runs infinite loop
            int mid = rStart + (rEnd - rStart) / 2;

            if (mat[mid][cMid] == target) {
                return new int[] { mid, cMid };
            } else if (mat[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }
        //output rStart as the main row
        
        // 2rows left, rStart, rStart + 1.
        // Now check if numbers in the cMid column for rStart & rStart+1 rows
        if (mat[rStart][cMid] == target) {
            return new int[] { rStart, cMid };
        } else if (mat[rStart + 1][cMid] == target) {
            return new int[] { rStart + 1, cMid };
        }

        // now we need to check in these 2 rows before and after cMid
        // then we have 4 cases:
        // 1 - first row(rStart) before mid
        if (target <= mat[rStart][cMid - 1]){ // 0 to cMid - 1
            return binarySearch(mat, target, rStart, 0, cMid - 1);
        }
        // 2 - first row(rStart) after mid and less than last col
        else if(mat[rStart][cMid + 1] <= target && mat[rStart][col] >= target){ // cMid + 1 to col
            return binarySearch(mat, target, rStart, cMid + 1, col);
        }
        // 3 - second row(rStart + 1) before mid
        else if (target <= mat[rStart + 1][cMid - 1]){// 0 to cMid - 1 in rStart + 1
            return binarySearch(mat, target, rStart + 1, 0, cMid - 1);
        }
        // 4 - second row(rStart + 1) after mid
        else{ //cMid + 1 to col
            return binarySearch(mat, target, rStart + 1, cMid + 1, col);
        }

        // return new int[] { -1, -1 };
    }

    //binary search for each row in those 4 cases
    static int[] binarySearch(int[][] mat, int target, int row, int cStart, int cEnd){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;

            if (mat[row][mid] == target){
                return new int[] {row, mid};
            } else if (mat[row][mid] < target){
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }

        return new int[] {-1, -1};
    }

}
