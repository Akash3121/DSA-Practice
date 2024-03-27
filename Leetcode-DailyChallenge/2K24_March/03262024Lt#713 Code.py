def bruteforce(nums, k): #O(n^2)
    count = 0
    for i in range(len(nums)):
        pass
        counter = 1 # sub array product
        for j in range(i, len(nums)):
            counter *= nums[j]
            if counter < k:
                count += 1
            else:
                break
    # print(count)
    return count

def optimal(nums, k): #O(n)
    # kinda sliding window protocol
    res = 0
    l = 0
    product = 1

    for r in range(len(nums)):
        product *= nums[r]

        while l <= r and product >= k:
            product = product // nums[l]
            l += 1
        res += (r - l + 1) # here r-l+1 is the window length
    return res

nums = [10,5,2,6]
k = 100
# k = 0
# nums = [1, 2, 3]
# print(bruteforce(nums, k))
print(optimal(nums, k))