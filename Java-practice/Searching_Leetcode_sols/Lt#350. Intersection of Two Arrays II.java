//350. Intersection of Two Arrays II

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
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
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        //placing set result into array
        int[] ans = new int[list.size()];
        i = 0;
        for (Integer num : list){
            ans[i++] = num;
        }
        return ans;
    }
}