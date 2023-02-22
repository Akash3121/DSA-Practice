//1704. Determine if String Halves Are Alike

#python
class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        exp = ["a", "e", "i", "o", "u"]
        a=0
        b=0
        for i in range(len(s)//2):
            if s[i].lower() in exp:
                a += 1
            if s[len(s)-i-1].lower() in exp:
                b+=1
        # print(a,b)
        return a==b

//Java
class Solution {
    public boolean halvesAreAlike(String s) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length()/2; i++){
            if (isVowel(s.charAt(i))){
                a += 1;
            }
            if (isVowel(s.charAt(s.length()-i-1))){
                b += 1;
            }
        }
        return a == b;
    }

    public static boolean isVowel(char c){
        char k = Character.toLowerCase(c);

        return k == 'a' || k == 'e' || k == 'i' || k == 'o' || k == 'u';
    }
}