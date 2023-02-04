//1346. Check If N and Its Double Exist


//o(n2)
class Solution {
    public boolean checkIfExist(int[] arr) {
        // Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i < n; i++){ //n times
            for(int j = 0; j < n; j++){ //n times
                if (i != j && arr[j] * 2 == arr[i]) return true;
            }
        }
        return false;
    }
}

//O(n)
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr){ //n times
            if (set.contains(a*2) || (a%2==0 && set.contains(a/2))){ //we are checking for even because if odd /2 gives even so wrong
                return true;
            }
            set.add(a);
        }
    return false;
    }
}

//Javascript
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function(arr) {
    let mul = {};
    let res = false;

    for(let i = 0; i< arr.length; i++ ) {
        if(arr[i]*2 in mul || arr[i]/2 in mul) {
            res = true;
            break;
        }
        mul[arr[i]] = i;
    }
    return res;
};