//605. Can Place Flowers

//Java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 ){
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
                flowerbed[i] = 1;
                n--;
                if (n == 0){
                    return true;
                }
            }
        }
        return false;
    }
}

//Golang
func canPlaceFlowers(flowerbed []int, n int) bool {
    if n == 0{
        return true;
    }
    i := 0
    for i < len(flowerbed){
        if flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (len(flowerbed) - 1 == i || flowerbed[i + 1] == 0){
            flowerbed[i] = 1;
            n--;
            if n == 0{
                return true;
            }
        }
        i++;
    }
    return false;
}