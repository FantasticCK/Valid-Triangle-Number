package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int l = 0, n = nums.length;
        while (l < nums.length && nums[l] == 0) {
            l++;
        }
        int res = 0;
        for ( ; l < n - 2; l++) {
            for (int r = l + 1; r < n-1; r++) {
                int index = findIndex(nums, l, r);
                res+= (index - r);
            }
        }
        return res;
    }

    private int findIndex(int[] nums, int l, int r) {
        int target = nums[l] + nums[r], index = Arrays.binarySearch(nums, r + 1, nums.length, target);
        if (index < 0) {
            index = - (index + 1) - 1;
        }
        while(nums[index] >= target && index > r) {
            index--;
        }
        return index;
    }
}

class Solution {
    public int triangleNumber(int[] A) {
        Arrays.sort(A);
        int count = 0, n = A.length;
        for (int i=n-1;i>=2;i--) {
            int l = 0, r = i-1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r-l;
                    r--;
                }
                else l++;
            }
        }
        return count;
    }
}


