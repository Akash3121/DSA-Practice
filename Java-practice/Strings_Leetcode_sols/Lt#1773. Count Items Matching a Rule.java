//1773. Count Items Matching a Rule

//Java
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

#Python
class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        c = 0
        for i in range(len(items)):
            if ruleKey == "type":
                if ruleValue == items[i][0]:
                    c +=1 
            elif ruleKey == "color":
                if ruleValue == items[i][1]:
                    c += 1
            else: #name
                if ruleValue == items[i][2]:
                    c += 1
        return c
        