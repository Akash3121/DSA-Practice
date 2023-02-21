//1678. Goal Parser Interpretation

class Solution {
    public String interpret(String command) {
        // Logic: loop through array skip ( if any other char add in res array if ) then check if index - 1 = ( then add o
        String ans = new String();
        for (int i = 0; i < command.length(); i++){
            if (command.charAt(i) == '('){
                continue;
            } else if( command.charAt(i) == ')'){
                if ( i > 0 && command.charAt(i-1) == '('){
                    ans += 'o';
                } else{
                    continue;
                }
            } else{
                ans += command.charAt(i);
            }
        }
        return ans;
    }
}