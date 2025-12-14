package Sliding_window;

import java.util.HashMap;

public class BinarySubarraysOptimized {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);//আমরা ধরেছি array এর বাইরে (শুরু করার আগে) prefix sum = 0 একবার হয়েছে।

        int prefixSum = 0;//prefixSum = এ পর্যন্ত কতগুলো 1 দেখেছো
        int count = 0;//freq = এ পর্যন্ত prefixSum কয়বার এসেছে

        for (int num : nums) {//প্রত্যেক element add করে prefix sum আপডেট করছি।
            prefixSum += num;

            if (freq.containsKey(prefixSum - goal)) {//মানে তুমি এমন একটা previous point খুঁজছো যেখানে total 1 এর সংখ্যা = prefixSum - goal
                count += freq.get(prefixSum - goal);//তাহলে i+1 থেকে j পর্যন্ত subarray এর sum = goal
                //যতবার ওই previous sum এসেছে, ততবার valid subarray আছে
            }

            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);//getOrDefault(prefixSum,0) = আগে কতবার এসেছে (না থাকলে 0)
            //+1 করে update করি → এখন এটিও map-এ আছে
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        System.out.println(numSubarraysWithSum(nums, goal)); // Output: 4
    }
}
//time=O(n)
//space=O(n)