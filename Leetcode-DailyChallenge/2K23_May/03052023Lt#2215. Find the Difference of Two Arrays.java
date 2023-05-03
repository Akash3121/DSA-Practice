//2215. Find the Difference of Two Arrays

//Java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n: nums1){
            set1.add(n);
        }
        for (int n: nums2){
            set2.add(n);
        }

        for (int n: set1){
            if(set2.contains(n) == false){
                ans1.add(n);
            }
        }
        for (int n: set2){
            if(set1.contains(n) == false){
                ans2.add(n);
            }
        }

        result.add(ans1);
        result.add(ans2);
        return result;
    }
}