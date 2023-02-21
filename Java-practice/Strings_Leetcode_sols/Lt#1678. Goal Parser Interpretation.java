//1678. Goal Parser Interpretation

//Java - string builder
class Solution {
    public String interpret(String command) {
	StringBuilder S = new StringBuilder(command.length());
	for(int i = 0 ; i < command.length() ; i++){
		if(command.charAt(i)=='G') S.append('G');
		if(command.charAt(i)=='('){
			if(command.charAt(i+1)==')') {S.append('o'); i++;}
			else{S.append("al"); i = i + 3;}
		}
	}
	return S.toString();
    }
}

//Java
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

#Python
class Solution:
    def interpret(self, command: str) -> str:
        return command.replace('()','o').replace('(al)','al')

//Javascript
/**
 * @param {string} command
 * @return {string}
 */
var interpret = function(command) {
    return command.split("()").join("o").split("(al)").join("al");
};