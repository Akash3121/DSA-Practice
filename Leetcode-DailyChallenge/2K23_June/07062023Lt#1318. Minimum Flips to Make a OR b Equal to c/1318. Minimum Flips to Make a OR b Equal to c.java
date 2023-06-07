//1318. Minimum Flips to Make a OR b Equal to c

//Java
class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            boolean ai = false;
            boolean bi = false;
            boolean ci = false;

            if ((a & (1 << i)) > 0) ai = true;
            if ((b & (1 << i)) > 0) bi = true;
            if ((c & (1 << i)) > 0) ci = true;

            if (ci){ //c is set bit
                if(!ai && !bi) ans ++; // both ai and bi are unset
            } else { //c is unset
                if(ai && bi) ans += 2; //both ai, bi is set, then both needs to be changed
                else if(ai || bi) ans ++;
            }
        }
        return ans;
    }
}