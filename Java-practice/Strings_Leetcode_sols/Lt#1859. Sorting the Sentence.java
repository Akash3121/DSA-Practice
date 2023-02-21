//1859. Sorting the Sentence

//Java
class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] res = new String[arr.length];

        for(int i = 0; i < arr.length; i++){
            int k = arr[i].length() - 1;
            int m = arr[i].charAt(k)-'0'; //number at the end of each word
            res[m-1] = arr[i].substring(0, k); //in substring end index not included

        }

        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < res.length; j++){
            sb.append(res[j]+" ");
        }

        return (sb.toString()).trim();
        
    }
}

#python
class Solution:
    def sortSentence(self, s: str) -> str:
        arr = s.split(" ")
        res = [""] * len(arr)

        for i in range(len(arr)):
            k = len(arr[i]) - 1
            m = int( arr[i][-1])
            res[m-1] = arr[i][:-1]
        
        return " ".join(res)