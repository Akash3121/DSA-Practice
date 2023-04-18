//1431. Kids With the Greatest Number of Candies

//Java
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> b = new ArrayList<Boolean>(candies.length);
        int max = 0;
        for (int i : candies){
            max = Math.max(i,max);
        }
        for (int i : candies){
            b.add(i+extraCandies >= max);
        }
        return b;
    }
}