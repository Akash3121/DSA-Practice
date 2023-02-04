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

//