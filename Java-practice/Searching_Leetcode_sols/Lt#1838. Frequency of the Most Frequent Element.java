//1838. Frequency of the Most Frequent Element

class Solution {
    public int maxFrequency(int[] a, int k) {
        if(a.length==1) return 1;
        
        Arrays.sort(a);
		 int i=0,j=1;
		 int noOp=a[j]-a[i];
		 int mx_freq=1;
        
	   while(j<a.length && i<a.length) {
			 while(noOp<=k && j<a.length-1) {
				 noOp=noOp + (j-i+1)*(a[j+1]-a[j]);
				 j++;
				if(noOp<=k)
                 mx_freq=Math.max(mx_freq, j-i+1);
			 }
			if(noOp<=k)
                 mx_freq=Math.max(mx_freq, j-i+1);
           
			 noOp=noOp-(a[j]-a[i]);
			 i++;
		}
		return mx_freq;
    }
}