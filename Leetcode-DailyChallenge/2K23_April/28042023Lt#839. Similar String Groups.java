//839. Similar String Groups

// Java
class Solution {

    boolean isSimilar(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                count++;
                if (count > 2){
                    return false;
                }
            }
        }
        return count == 2 || count == 0;
    }

    public int numSimilarGroups(String[] strs) {
        int result = 0;

        if (strs == null || strs.length == 0){
            return 0;
        }

        Set<String> visited = new HashSet<>();
        for(String s: strs){
            if(!visited.contains(s)){
                dfs(s, strs, visited);
                result ++;
            }
        }
        return result;
    }

    void dfs(String curr, String[] strs, Set<String> visited){
        if (visited.contains(curr)){
            return ;
        }

        visited.add(curr);

        for(int i = 0; i < strs.length; i++){
            if (isSimilar(curr, strs[i])){
                dfs(strs[i], strs, visited);
            }
        }
    }
}