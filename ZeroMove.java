package test_2;

public class ZeroMove {
    public static void main(String[] args) {
        int[] nums = {3,0,2,7,0,5};

        frontstack(nums);
        for (int i : nums) {
            System.out.println(i);
        }


    }

    public static void backstack(int [] nums) {

        int n = nums.length;
        int index = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] != 0)
            {
                nums[index] = nums[i];
                index++;
            }
        }

        for(int i = index; i<n; i++) {
            nums[index+1] = 0;

        }
    }

    public static void frontstack(int [] nums) {
        int n = nums.length;
        int index = n-1;

        for(int i=n-1; i>-1; i--) {
            if(nums[i] != 0){
                nums[index] = nums[i];
                index--;
            }
        }
        while (index >= 0) {
            nums[index] = 0;
            index--;
        }


    }
}
