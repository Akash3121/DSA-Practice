//556. Next Greater Element III

#python3
class Solution:
    def nextGreaterElement(self, n: int) -> int:
        #ex: 23102431
        #ans = 23103124 -> means from right traverse till the prev num is greater,if encountered prev < curr swap the num(i) with next biggest num(from last till{i till end} that num. ad from i+1 till end reverse and append that's the ans
        k = list(str(n))
        i = len(k) - 1

        if len(k) == 1: #only one digit
            return -1
            
        while( i-1 >= 0 and k[i] <= k[i-1]): #O(N)
            i -= 1
        if i == 0: # means all are sorted in desc so can;t give a higher num with those didgits
            return -1

        #now i-1 has the digit 2 from example
        #so traverse from i-1 till end and if num < i-1 stop the previous number is what we need to swap 
        j = i
        while j+1 < len(k) and k[j+ 1] > k[i-1]: #no need to check j because it will be greater as we already checked in the finding i loop => O(N)
            j += 1
        
        #now we need to swap with i-1 and j
        k[i-1], k[j] = k[j], k[i-1]
        #reverse digits from i till end and add
        k[i:] = k[i:][::-1] #O(N)

        ret = int(''.join(k))

        return ret if ret < 1<<31 else -1 # 1<<31 is 2^31(pow)
