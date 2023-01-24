//1773. Count Items Matching a Rule

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int row = items.size();
        int c = 0;
        for (int i = 0; i<row; i++){
            if (ruleKey.equals("type")){
                if (items.get(i).get(0).equals(ruleValue)) c++;
            }
            else if (ruleKey.equals("color")){
                if (items.get(i).get(1).equals(ruleValue)) c++;
            }
            else {
                if (items.get(i).get(2).equals(ruleValue)) c++;
            }
        }
        return c;

    }
}