//1528. Shuffle String

#python
class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        res = [''] * len(s)
        for i, ch in enumerate(s):
            res[indices[i]] = ch
        return "".join(res)
//Java
class Solution {
    public String restoreString(String s, int[] indices) {
		char temp[] = new char[indices.length];
		for (int i = 0; i < indices.length; i++) {
			temp[indices[i]] = s.charAt(i);
		}
		return new String(temp);
	}
}

//javascript
/**
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
var restoreString = function(s, indices) {
    let ans = new Array(indices.length);

    for(let i = 0; i < indices.length; i++){
        ans[indices[i]] = s[i];
    }

    return ans.join("");
    
};