package two_pointers;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int containerHeight = Math.min(height[left], height[right]);
            int area = width * containerHeight;

            maxArea = Math.max(maxArea, area);

            // move the pointer which is smaller
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,7,2,5,4,7,3,6};
        System.out.println(maxArea(height));  // Output: 36
    }
}

