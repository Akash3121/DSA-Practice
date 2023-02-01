//832. Flipping an Image 

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i< n; i++){
            //while reversing, if both elems are same invert and change it, if not same don''t change 
            int j = 0; int k = n-1;
            while (j<=k){
                
                if (image[i][j]== image[i][k]){
                image[i][j] = 1 - image[i][k];
                image[i][k] = image[i][j];}
                j++;
                k--;
            }
        }
        return image;
    }
}