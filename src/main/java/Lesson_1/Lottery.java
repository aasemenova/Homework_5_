package Lesson_1;

import java.util.Random;

public class Lottery {
    public static void main(String[] args) {
        int[] nums = new int[100];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        shuffleArray(nums);
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void shuffleArray(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}