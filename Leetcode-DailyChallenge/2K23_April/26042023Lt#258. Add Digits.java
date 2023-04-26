//258. Add Digits

# python3
class Solution:
    def addDigits(self, num: int) -> int:
        while num > 9:
            sum = 0
            while num:
                sum += num % 10
                num = num // 10
            num = sum
        return num

#python 3
class Solution:
    def addDigits(self, num: int) -> int:
        if num == 0: return 0
        if num % 9 == 0: return 9
        else: return (num % 9)