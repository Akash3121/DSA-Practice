# 59. Spiral Matrix II

# python3
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        #TC: O()
        k = 1
        # ans = [[0]*n]*n - this will not work
        ans = [[0 for _ in range(n)] for _ in range(n)] #n*n times 
        rowBegin = 0
        rowEnd = n - 1
        colBegin = 0
        colEnd = n - 1
        while (k <= n*n and rowBegin <= rowEnd and colBegin <= colEnd): #n*n times

            #traverse right - first row
            for j in range(colBegin, colEnd + 1):
                ans[rowBegin][j] = k
                k += 1
            rowBegin += 1
            
            #traverse down - last col
            for j in range(rowBegin, rowEnd + 1):
                ans[j][colEnd] = k
                k += 1
            colEnd -= 1
            
            #traverse left - last row
            for j in range(colEnd, colBegin - 1, -1):
                ans[rowEnd][j] = k
                k += 1
            rowEnd -= 1
            
            #traverse up - first column
            for j in range(rowEnd, rowBegin - 1, -1):
                ans[j][colBegin] = k
                k += 1
            colBegin += 1
            
        return ans