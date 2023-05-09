//54. Spiral Matrix

# python3
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []

        if len(matrix) == 0:
            return 0
        
        rowBegin = 0
        rowEnd = len(matrix) - 1
        colBegin = 0
        colEnd = len(matrix[0]) - 1

        while (rowBegin <= rowEnd and colBegin <= colEnd):

            # Traverse Right
            for j in range(colBegin, colEnd + 1):
                res.append(matrix[rowBegin][j])
                # j += 1
            rowBegin += 1

            # Traverse Down
            for j in range(rowBegin, rowEnd + 1):
                res.append(matrix[j][colEnd])
                # j += 1
            colEnd -= 1

            #Traverse left
            if rowBegin <= rowEnd:
                for j in range(colEnd, colBegin - 1, -1):
                    res.append(matrix[rowEnd][j])
            rowEnd -= 1

            #Traverse Up
            if colBegin <= colEnd:
                for j in range(rowEnd, rowBegin - 1, -1):
                    res.append(matrix[j][colBegin])
            colBegin += 1
        

        return res

//Java
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }
}