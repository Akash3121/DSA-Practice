//686. Repeated String Match

#python3
class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        # logic: for b to be inside a, the length of a should be atleast equal to b or 1 greater, means lower bound is ceil (len(b)/len(a)) 
        # we need to multiply ans{here ans = times} * a so that equal to b length (OR) ans+1 * a 
        # so there are 2 cases we need to check ans * a with b and ans+1 * a with b if both are not satisfied then -1
        times = -(-len(b) // len(a)) # same as times = int(math.ceil(float(len(B)) / len(A)))
        # only 2 cases to check so 
        for i in range(2): # only 0, 1
            if b in (a * (times + i)):
                return (times + i)
        return -1
        # in interview don't directly use this -> return times * (b in (a * times)) or (times + 1) * (b in (a * (times + 1))) or -1

#python3
class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        # logic: for b to be inside a, the length of a should be atleast equal to b or 1 greater, means lower bound is ceil (len(b)/len(a)) 
        # we need to multiply ans{here ans = times} * a so that equal to b length (OR) ans+1 * a 
        # so there are 2 cases we need to check ans * a with b and ans+1 * a with b if both are not satisfied then -1
        times = -(-len(b) // len(a)) # same as times = int(math.ceil(float(len(B)) / len(A)))
        return times * (b in (a * times)) or (times + 1) * (b in (a * (times + 1))) or -1

//Java
class Solution {
    public int repeatedStringMatch(String a, String b) {
        String copy = "";
        int count = 0;
        while (copy.length() < b.length()){
            copy += a;
            count ++;
        }
        // ONLY 2 cases to check 
        if (copy.indexOf(b) >= 0){
            return count;
        }
        if ((copy+a).indexOf(b) >= 0){
            return ++count;
        }
        return -1;
    }
}