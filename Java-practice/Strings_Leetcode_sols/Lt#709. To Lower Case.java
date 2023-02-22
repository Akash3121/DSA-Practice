//709. To Lower Case

#python
class Solution:
    def toLowerCase(self, s: str) -> str:
        # return s.lower()
        arr = list(s)
        for i in range(len(arr)):
            if ord(arr[i]) <= ord("Z") and ord(arr[i]) >= ord("A"):
                arr[i] = chr(ord(arr[i]) + ord("a") - ord("A"))
        return "".join(arr)

#python
class Solution:
    def toLowerCase(self, s: str) -> str:
        return s.lower()

//Java
class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}