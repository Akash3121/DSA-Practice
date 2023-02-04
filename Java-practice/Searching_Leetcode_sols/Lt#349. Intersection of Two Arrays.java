//349. Intersection of Two Arrays

//O(n2)
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        a = []
        for i in nums1:#n times
            if i in nums2: #n times
                if i not in a:
                    a.append(i)
        return a

//two pointer nlogn
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        //two pointer
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                i++;
            } else if (nums1[i] > nums2[j]){
                j++;
            } else{// both equal
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        //placing set result into array
        int[] ans = new int[set.size()];
        i = 0;
        for (Integer num : set){
            ans[i++] = num;
        }
        return ans;
    }
}