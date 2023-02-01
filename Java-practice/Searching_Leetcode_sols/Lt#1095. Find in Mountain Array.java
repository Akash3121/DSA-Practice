//1095. Find in Mountain Array


class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int e = findPeak(mountainArr);
        int check = binarySearch(mountainArr, target, e);
        if (check == -1)
            check = binarySearchDesc(mountainArr, target, e);
        return check;
    }
    public int binarySearchDesc(MountainArray mountainArr, int target, int start){
        int s = 0;
        int e = mountainArr.length() - 1;
        while(s <= e){
            int mid = s + (e - s) / 2;
            if (target > mountainArr.get(mid)){
                e = mid - 1;
            }else if (target < mountainArr.get(mid)){
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public int binarySearch(MountainArray mountainArr, int target, int e){
        int s = 0;
        while(s <= e){
            int mid = s + (e - s) / 2;
            if (target > mountainArr.get(mid)){
                s = mid + 1;
            }else if (target < mountainArr.get(mid)){
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public int findPeak(MountainArray mountainArr){
        int s = 0;
        int e = mountainArr.length() - 1;
        while(s<e){
            int mid = s + (e - s) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1))
                e = mid;
            else
                s = mid + 1;
        }
        return s;
    }
}